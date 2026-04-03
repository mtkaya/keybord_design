package com.mtkaya.transliteration

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.Gravity

/**
 * Arabic Transliteration + Turkish Input Method Service.
 *
 * Physical keyboard: RAlt/AltGr + key → special character
 * Soft keyboard: Compact toolbar (expandable on tap), 3 modes: Translit / TR / All
 */
class TranslitInputMethodService : InputMethodService() {

    private var isShiftOn = false
    private var isRaltDown = false
    // Also track Left Ctrl for AltGr emulation (some keyboards send Ctrl+Alt for AltGr)
    private var isLctrlDown = false
    private var isLaltDown = false

    // Current mode: 0=Translit, 1=Turkish, 2=All
    private var currentMode = 0
    private val modeNames = arrayOf("Translit", "TR", "All")

    // Soft keyboard expanded state
    private var isExpanded = false
    private var softShift = false

    private var rootLayout: LinearLayout? = null
    private var gridContainer: LinearLayout? = null
    private var toggleBtn: Button? = null
    private var modeBtn: Button? = null
    private var shiftBtn: Button? = null

    // ========== PHYSICAL KEYBOARD HANDLING ==========

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event == null) return super.onKeyDown(keyCode, event)

        // Track modifier states
        when (keyCode) {
            KeyEvent.KEYCODE_ALT_RIGHT -> { isRaltDown = true; return true }
            KeyEvent.KEYCODE_ALT_LEFT -> { isLaltDown = true }
            KeyEvent.KEYCODE_CTRL_LEFT -> { isLctrlDown = true }
            KeyEvent.KEYCODE_SHIFT_LEFT, KeyEvent.KEYCODE_SHIFT_RIGHT -> { isShiftOn = true }
        }

        // Detect RAlt: direct key, meta state, or Ctrl+Alt combo (AltGr emulation)
        val metaState = event.metaState
        val hasRalt = isRaltDown
            || (metaState and KeyEvent.META_ALT_RIGHT_ON) != 0
            || (isLctrlDown && isLaltDown)
            || (metaState and (KeyEvent.META_CTRL_ON or KeyEvent.META_ALT_ON)) ==
                (KeyEvent.META_CTRL_ON or KeyEvent.META_ALT_ON)

        if (hasRalt) {
            // Pick mapping based on current mode
            val mapping = when (currentMode) {
                1 -> TranslitMap.turkishMappings[keyCode]
                else -> TranslitMap.translitMappings[keyCode]
                    ?: TranslitMap.turkishMappings[keyCode]
            }
            if (mapping != null) {
                val hasShift = isShiftOn || (metaState and KeyEvent.META_SHIFT_ON) != 0
                val text = if (hasShift) mapping.upper else mapping.lower
                currentInputConnection?.commitText(text, 1)
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_ALT_RIGHT -> { isRaltDown = false; return true }
            KeyEvent.KEYCODE_ALT_LEFT -> { isLaltDown = false }
            KeyEvent.KEYCODE_CTRL_LEFT -> { isLctrlDown = false }
            KeyEvent.KEYCODE_SHIFT_LEFT, KeyEvent.KEYCODE_SHIFT_RIGHT -> { isShiftOn = false }
        }
        return super.onKeyUp(keyCode, event)
    }

    // ========== SOFT KEYBOARD ==========

    override fun onCreateInputView(): View {
        return createSoftKeyboard()
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }

    private fun createSoftKeyboard(): View {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(COLOR_BG)
        }
        rootLayout = root

        // === Toolbar (always visible, compact) ===
        val toolbar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(8, 6, 8, 6)
            setBackgroundColor(COLOR_TOOLBAR)
        }

        // Toggle expand/collapse button
        toggleBtn = makeToolbarBtn(if (isExpanded) "▼" else "▲") {
            isExpanded = !isExpanded
            toggleBtn?.text = if (isExpanded) "▼" else "▲"
            gridContainer?.visibility = if (isExpanded) View.VISIBLE else View.GONE
        }
        toolbar.addView(toggleBtn)

        // Mode switch button
        modeBtn = makeToolbarBtn(modeNames[currentMode]) {
            currentMode = (currentMode + 1) % modeNames.size
            modeBtn?.text = modeNames[currentMode]
            refreshGrid()
        }
        toolbar.addView(modeBtn)

        // Shift button
        shiftBtn = makeToolbarBtn("⇧") {
            softShift = !softShift
            shiftBtn?.setTextColor(if (softShift) COLOR_ACCENT else Color.WHITE)
            refreshGrid()
        }
        toolbar.addView(shiftBtn)

        // Quick-access: most used characters in toolbar
        val quickChars = listOf("ā", "ḥ", "ṣ", "ṭ", "ʿ", "ş")
        for (ch in quickChars) {
            val btn = makeToolbarBtn(ch) {
                currentInputConnection?.commitText(ch, 1)
            }
            btn.layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(2, 2, 2, 2)
            }
            toolbar.addView(btn)
        }

        root.addView(toolbar)

        // === Expandable grid container (hidden by default) ===
        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            visibility = View.GONE
            setPadding(4, 4, 4, 4)
        }
        gridContainer = container

        // Character grid
        container.addView(createCharGrid())

        // Utility row
        val utilRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(4, 2, 4, 2)
        }
        utilRow.addView(makeUtilBtn("Space", 2.5f) {
            currentInputConnection?.commitText(" ", 1)
        })
        utilRow.addView(makeUtilBtn("⌫", 1f) {
            currentInputConnection?.deleteSurroundingText(1, 0)
        })
        utilRow.addView(makeUtilBtn("↵", 1f) {
            currentInputConnection?.commitText("\n", 1)
        })
        container.addView(utilRow)

        root.addView(container)

        return root
    }

    private fun createCharGrid(): GridLayout {
        val chars = when (currentMode) {
            0 -> TranslitMap.translitChars
            1 -> TranslitMap.turkishChars
            else -> TranslitMap.allChars
        }

        val cols = if (chars.size <= 6) 3 else 5

        val grid = GridLayout(this).apply {
            columnCount = cols
            tag = "charGrid"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        chars.forEachIndexed { index, (lower, upper) ->
            val displayChar = if (softShift) upper else lower
            val btn = Button(this).apply {
                text = displayChar
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                setTextColor(Color.WHITE)
                setBackgroundColor(COLOR_KEY)
                minWidth = 0; minHeight = 0
                minimumWidth = 0; minimumHeight = 0
                setPadding(8, 12, 8, 12)

                layoutParams = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(index % cols, 1, 1f)
                    rowSpec = GridLayout.spec(index / cols)
                    setMargins(3, 3, 3, 3)
                }

                setOnClickListener {
                    currentInputConnection?.commitText(displayChar, 1)
                }
            }
            grid.addView(btn)
        }

        return grid
    }

    private fun refreshGrid() {
        val container = gridContainer ?: return
        // Remove old grid
        for (i in 0 until container.childCount) {
            if (container.getChildAt(i) is GridLayout) {
                container.removeViewAt(i)
                container.addView(createCharGrid(), i)
                return
            }
        }
    }

    // ========== UI HELPERS ==========

    private fun makeToolbarBtn(label: String, onClick: () -> Unit): Button {
        return Button(this).apply {
            text = label
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            setTextColor(Color.WHITE)
            setBackgroundColor(COLOR_KEY)
            minWidth = 0; minHeight = 0
            minimumWidth = 0; minimumHeight = 0
            setPadding(12, 6, 12, 6)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(3, 2, 3, 2) }
            setOnClickListener { onClick() }
        }
    }

    private fun makeUtilBtn(label: String, weight: Float, onClick: () -> Unit): Button {
        return Button(this).apply {
            text = label
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
            setTextColor(Color.WHITE)
            setBackgroundColor(COLOR_UTIL)
            setPadding(12, 8, 12, 8)
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, weight).apply {
                setMargins(3, 3, 3, 3)
            }
            setOnClickListener { onClick() }
        }
    }

    companion object {
        private const val COLOR_BG = 0xFF1a1a2e.toInt()
        private const val COLOR_TOOLBAR = 0xFF16213e.toInt()
        private const val COLOR_KEY = 0xFF0f3460.toInt()
        private const val COLOR_UTIL = 0xFF16213e.toInt()
        private const val COLOR_ACCENT = 0xFFe94560.toInt()
    }
}
