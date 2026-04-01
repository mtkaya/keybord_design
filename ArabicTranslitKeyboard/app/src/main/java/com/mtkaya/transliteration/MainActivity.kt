package com.mtkaya.transliteration

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * Main activity: shows setup instructions and keyboard reference.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scrollView = ScrollView(this).apply {
            setBackgroundColor(Color.parseColor("#1a1a2e"))
            setPadding(32, 32, 32, 32)
        }

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
        }

        // Title
        root.addView(createText(
            "Arabic Transliteration Keyboard",
            22f, true, Color.WHITE
        ))
        root.addView(createText(
            "Academic Arabic transliteration for physical keyboards",
            14f, false, Color.parseColor("#a0a0a0")
        ))

        root.addView(createSpacer(32))

        // Setup section
        root.addView(createText("Setup", 18f, true, Color.parseColor("#e94560")))
        root.addView(createSpacer(16))

        // Step 1: Enable keyboard
        val enableBtn = Button(this).apply {
            text = "Step 1: Enable Keyboard in Settings"
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor("#0f3460"))
            setPadding(32, 24, 32, 24)
            setOnClickListener {
                startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
            }
        }
        root.addView(enableBtn)
        root.addView(createSpacer(12))

        // Step 2: Switch to keyboard
        val switchBtn = Button(this).apply {
            text = "Step 2: Switch to This Keyboard"
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor("#0f3460"))
            setPadding(32, 24, 32, 24)
            setOnClickListener {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showInputMethodPicker()
            }
        }
        root.addView(switchBtn)

        root.addView(createSpacer(32))

        // Physical keyboard section
        root.addView(createText(
            "Physical Keyboard Shortcuts",
            18f, true, Color.parseColor("#e94560")
        ))
        root.addView(createText(
            "Hold Right Alt (RAlt) + key. Add Shift for uppercase.",
            13f, false, Color.parseColor("#a0a0a0")
        ))
        root.addView(createSpacer(16))

        // Reference table
        root.addView(createText("Long Vowels", 15f, true, Color.parseColor("#53d8fb")))
        root.addView(createRefRow("RAlt + a", "ā / Ā", "Alif (ا)"))
        root.addView(createRefRow("RAlt + i", "ī / Ī", "Yāʾ (ي)"))
        root.addView(createRefRow("RAlt + u", "ū / Ū", "Wāw (و)"))

        root.addView(createSpacer(12))
        root.addView(createText("Dot Below", 15f, true, Color.parseColor("#53d8fb")))
        root.addView(createRefRow("RAlt + h", "ḥ / Ḥ", "Ḥāʾ (ح)"))
        root.addView(createRefRow("RAlt + s", "ṣ / Ṣ", "Ṣād (ص)"))
        root.addView(createRefRow("RAlt + t", "ṭ / Ṭ", "Ṭāʾ (ط)"))
        root.addView(createRefRow("RAlt + d", "ḍ / Ḍ", "Ḍād (ض)"))
        root.addView(createRefRow("RAlt + z", "ẓ / Ẓ", "Ẓāʾ (ظ)"))

        root.addView(createSpacer(12))
        root.addView(createText("Special", 15f, true, Color.parseColor("#53d8fb")))
        root.addView(createRefRow("RAlt + c", "š / Š", "Shīn (ش)"))
        root.addView(createRefRow("RAlt + g", "ġ / Ġ", "Ghayn (غ)"))
        root.addView(createRefRow("RAlt + x", "ḫ / Ḫ", "Khāʾ (خ)"))
        root.addView(createRefRow("RAlt + v", "ṯ / Ṯ", "Thāʾ (ث)"))
        root.addView(createRefRow("RAlt + e", "ḏ / Ḏ", "Dhāl (ذ)"))

        root.addView(createSpacer(12))
        root.addView(createText("Ayn & Hamza", 15f, true, Color.parseColor("#53d8fb")))
        root.addView(createRefRow("RAlt + [", "ʿ", "ʿAyn (ع)"))
        root.addView(createRefRow("RAlt + ]", "ʾ", "Hamza (ء)"))

        root.addView(createSpacer(32))

        // Examples
        root.addView(createText("Examples", 18f, true, Color.parseColor("#e94560")))
        root.addView(createSpacer(8))
        root.addView(createText("al-ḥakīm  •  ʿilm  •  kitāb  •  al-Ḫwārizmī", 16f, false, Color.WHITE))
        root.addView(createText("Šams al-Dīn  •  al-Ġazālī  •  Ṯābit ibn Qurra", 16f, false, Color.WHITE))

        root.addView(createSpacer(32))

        root.addView(createText(
            "Tip: This keyboard works alongside your normal keyboard. " +
            "Regular keys work normally — only RAlt combos produce transliteration characters.",
            13f, false, Color.parseColor("#808080")
        ))

        root.addView(createSpacer(48))

        scrollView.addView(root)
        setContentView(scrollView)
    }

    private fun createText(text: String, size: Float, bold: Boolean, color: Int): TextView {
        return TextView(this).apply {
            this.text = text
            setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
            setTextColor(color)
            if (bold) typeface = Typeface.DEFAULT_BOLD
            setPadding(0, 4, 0, 4)
        }
    }

    private fun createRefRow(combo: String, output: String, desc: String): LinearLayout {
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 6, 0, 6)
            gravity = Gravity.CENTER_VERTICAL

            addView(TextView(context).apply {
                this.text = combo
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
                setTextColor(Color.parseColor("#b0b0b0"))
                typeface = Typeface.MONOSPACE
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)
            })
            addView(TextView(context).apply {
                this.text = output
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
                setTextColor(Color.WHITE)
                typeface = Typeface.DEFAULT_BOLD
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1.5f)
            })
            addView(TextView(context).apply {
                this.text = desc
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
                setTextColor(Color.parseColor("#707070"))
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 2f)
            })
        }
    }

    private fun createSpacer(height: Int): View {
        return View(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, height
            )
        }
    }
}
