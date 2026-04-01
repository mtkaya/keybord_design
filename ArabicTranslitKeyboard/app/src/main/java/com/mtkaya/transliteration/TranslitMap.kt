package com.mtkaya.transliteration

import android.view.KeyEvent

/**
 * Maps physical keyboard keys (with RAlt modifier) to Arabic transliteration characters.
 * Standard: DIN 31635 / Encyclopaedia of Islam (EI2)
 */
object TranslitMap {

    data class TranslitChar(
        val lower: String,
        val upper: String,
        val arabicLetter: String,
        val name: String
    )

    // keyCode -> TranslitChar
    val mappings: Map<Int, TranslitChar> = mapOf(
        // Long vowels (macrons)
        KeyEvent.KEYCODE_A to TranslitChar("ā", "Ā", "ا", "Alif"),
        KeyEvent.KEYCODE_I to TranslitChar("ī", "Ī", "ي", "Yāʾ"),
        KeyEvent.KEYCODE_U to TranslitChar("ū", "Ū", "و", "Wāw"),

        // Dot below consonants
        KeyEvent.KEYCODE_H to TranslitChar("ḥ", "Ḥ", "ح", "Ḥāʾ"),
        KeyEvent.KEYCODE_S to TranslitChar("ṣ", "Ṣ", "ص", "Ṣād"),
        KeyEvent.KEYCODE_T to TranslitChar("ṭ", "Ṭ", "ط", "Ṭāʾ"),
        KeyEvent.KEYCODE_D to TranslitChar("ḍ", "Ḍ", "ض", "Ḍād"),
        KeyEvent.KEYCODE_Z to TranslitChar("ẓ", "Ẓ", "ظ", "Ẓāʾ"),

        // Special consonants
        KeyEvent.KEYCODE_X to TranslitChar("ḫ", "Ḫ", "خ", "Khāʾ"),
        KeyEvent.KEYCODE_G to TranslitChar("ġ", "Ġ", "غ", "Ghayn"),
        KeyEvent.KEYCODE_C to TranslitChar("š", "Š", "ش", "Shīn"),

        // Line below
        KeyEvent.KEYCODE_V to TranslitChar("ṯ", "Ṯ", "ث", "Thāʾ"),
        KeyEvent.KEYCODE_E to TranslitChar("ḏ", "Ḏ", "ذ", "Dhāl"),

        // Ayn and Hamza
        KeyEvent.KEYCODE_LEFT_BRACKET to TranslitChar("ʿ", "ʿ", "ع", "ʿAyn"),
        KeyEvent.KEYCODE_RIGHT_BRACKET to TranslitChar("ʾ", "ʾ", "ء", "Hamza")
    )

    /**
     * All transliteration characters for the soft keyboard grid.
     * Each pair: (lowercase, uppercase)
     */
    val allChars: List<Pair<String, String>> = listOf(
        "ā" to "Ā",
        "ī" to "Ī",
        "ū" to "Ū",
        "ḥ" to "Ḥ",
        "ṣ" to "Ṣ",
        "ṭ" to "Ṭ",
        "ḍ" to "Ḍ",
        "ẓ" to "Ẓ",
        "š" to "Š",
        "ṯ" to "Ṯ",
        "ḫ" to "Ḫ",
        "ġ" to "Ġ",
        "ḏ" to "Ḏ",
        "ʿ" to "ʿ",
        "ʾ" to "ʾ"
    )
}
