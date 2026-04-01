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
import android.util.TypedValue
import android.view.Gravity

/**
 * Arabic Transliteration Input Method Service.
 *
 * Physical keyboard: RAlt + key → transliteration character
 * Soft keyboard: Grid of transliteration character buttons
 */
class TranslitInputMethodService : InputMethodService() {

    private var isShiftOn = false
    private var isRaltDown = false

    // ========== PHYSICAL KEYBOARD HANDLING ==========

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event == null) return super.onKeyDown(keyCode, event)

        // Track Right Alt state
        if (keyCode == KeyEvent.KEYCODE_ALT_RIGHT) {
            isRaltDown = true
            return true
        }

        // Track Shift state
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            isShiftOn = true
        }

        // Check for RAlt + key combo OR Meta state has ALT_RIGHT
        val hasRalt = isRaltDown ||
            (event.metaState and KeyEvent.META_ALT_RIGHT_ON) != 0

        if (hasRalt) {
            val mapping = TranslitMap.mappings[keyCode]
            if (mapping != null) {
                val hasShift = isShiftOn ||
                    (event.metaState and KeyEvent.META_SHIFT_ON) != 0
                val text = if (hasShift) mapping.upper else mapping.lower
                currentInputConnection?.commitText(text, 1)
                return true
            }
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ALT_RIGHT) {
            isRaltDown = false
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            isShiftOn = false
        }
        return super.onKeyUp(keyCode, event)
    }

    // ========== SOFT KEYBOARD (ON-SCREEN) ==========

    override fun onCreateInputView(): View {
        return createSoftKeyboard()
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }

    private fun createSoftKeyboard(): View {
        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#1a1a2e"))
            setPadding(8, 8, 8, 8)
        }

        // Header bar
        val headerBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(16, 8, 16, 8)
        }

        val titleText = TextView(this).apply {
            text = "Arabic Transliteration"
            setTextColor(Color.parseColor("#e0e0e0"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            typeface = Typeface.DEFAULT_BOLD
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }
        headerBar.addView(titleText)

        // Shift toggle button
        val shiftBtn = Button(this).apply {
            text = "⇧"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            setBackgroundColor(Color.parseColor("#16213e"))
            setTextColor(Color.WHITE)
            setPadding(24, 8, 24, 8)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        var softShift = false
        shiftBtn.setOnClickListener {
            softShift = !softShift
            shiftBtn.setBackgroundColor(
                if (softShift) Color.parseColor("#e94560") else Color.parseColor("#16213e")
            )
            updateGrid(rootLayout, softShift)
        }
        headerBar.addView(shiftBtn)

        rootLayout.addView(headerBar)

        // Character grid
        val grid = createCharGrid(false)
        grid.tag = "charGrid"
        rootLayout.addView(grid)

        // Bottom utility row
        val utilRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(4, 4, 4, 4)
        }

        // Space button
        val spaceBtn = createUtilButton("Space", 2f) {
            currentInputConnection?.commitText(" ", 1)
        }
        utilRow.addView(spaceBtn)

        // Backspace button
        val bkspBtn = createUtilButton("⌫", 1f) {
            currentInputConnection?.deleteSurroundingText(1, 0)
        }
        utilRow.addView(bkspBtn)

        // Enter button
        val enterBtn = createUtilButton("↵", 1f) {
            currentInputConnection?.commitText("\n", 1)
        }
        utilRow.addView(enterBtn)

        rootLayout.addView(utilRow)

        return rootLayout
    }

    private fun createCharGrid(shift: Boolean): GridLayout {
        val grid = GridLayout(this).apply {
            columnCount = 5
            setPadding(4, 4, 4, 4)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        TranslitMap.allChars.forEachIndexed { index, (lower, upper) ->
            val displayChar = if (shift) upper else lower
            val btn = Button(this).apply {
                text = displayChar
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                setTextColor(Color.WHITE)
                setBackgroundColor(Color.parseColor("#16213e"))
                minWidth = 0
                minHeight = 0
                minimumWidth = 0
                minimumHeight = 0
                setPadding(8, 16, 8, 16)

                val params = GridLayout.LayoutParams().apply {
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    columnSpec = GridLayout.spec(index % 5, 1, 1f)
                    rowSpec = GridLayout.spec(index / 5)
                    setMargins(4, 4, 4, 4)
                }
                layoutParams = params

                setOnClickListener {
                    currentInputConnection?.commitText(displayChar, 1)
                }
            }
            grid.addView(btn)
        }

        return grid
    }

    private fun updateGrid(rootLayout: LinearLayout, shift: Boolean) {
        // Find and replace the grid
        for (i in 0 until rootLayout.childCount) {
            val child = rootLayout.getChildAt(i)
            if (child is GridLayout && child.tag == "charGrid") {
                rootLayout.removeViewAt(i)
                val newGrid = createCharGrid(shift)
                newGrid.tag = "charGrid"
                rootLayout.addView(newGrid, i)
                break
            }
        }
    }

    private fun createUtilButton(label: String, weight: Float, onClick: () -> Unit): Button {
        return Button(this).apply {
            text = label
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor("#0f3460"))
            setPadding(16, 12, 16, 12)
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, weight).apply {
                setMargins(4, 4, 4, 4)
            }
            setOnClickListener { onClick() }
        }
    }
}
