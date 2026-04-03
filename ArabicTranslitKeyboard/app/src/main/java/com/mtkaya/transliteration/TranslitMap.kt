package com.mtkaya.transliteration

import android.view.KeyEvent

/**
 * Maps physical keyboard keys (with RAlt/AltGr modifier) to special characters.
 * Supports: Arabic transliteration (DIN 31635) + Turkish characters.
 */
object TranslitMap {

    data class TranslitChar(
        val lower: String,
        val upper: String,
        val label: String
    )

    // Arabic transliteration: RAlt + key
    val translitMappings: Map<Int, TranslitChar> = mapOf(
        // Long vowels (macrons)
        KeyEvent.KEYCODE_A to TranslitChar("ā", "Ā", "Alif"),
        KeyEvent.KEYCODE_I to TranslitChar("ī", "Ī", "Yāʾ"),
        KeyEvent.KEYCODE_U to TranslitChar("ū", "Ū", "Wāw"),

        // Dot below consonants
        KeyEvent.KEYCODE_H to TranslitChar("ḥ", "Ḥ", "Ḥāʾ"),
        KeyEvent.KEYCODE_S to TranslitChar("ṣ", "Ṣ", "Ṣād"),
        KeyEvent.KEYCODE_T to TranslitChar("ṭ", "Ṭ", "Ṭāʾ"),
        KeyEvent.KEYCODE_D to TranslitChar("ḍ", "Ḍ", "Ḍād"),
        KeyEvent.KEYCODE_Z to TranslitChar("ẓ", "Ẓ", "Ẓāʾ"),

        // Special consonants
        KeyEvent.KEYCODE_X to TranslitChar("ḫ", "Ḫ", "Khāʾ"),
        KeyEvent.KEYCODE_G to TranslitChar("ġ", "Ġ", "Ghayn"),
        KeyEvent.KEYCODE_C to TranslitChar("š", "Š", "Shīn"),

        // Line below
        KeyEvent.KEYCODE_V to TranslitChar("ṯ", "Ṯ", "Thāʾ"),
        KeyEvent.KEYCODE_E to TranslitChar("ḏ", "Ḏ", "Dhāl"),

        // Ayn and Hamza
        KeyEvent.KEYCODE_LEFT_BRACKET to TranslitChar("ʿ", "ʿ", "ʿAyn"),
        KeyEvent.KEYCODE_RIGHT_BRACKET to TranslitChar("ʾ", "ʾ", "Hamza")
    )

    // Turkish characters: RAlt + key (keys not used by transliteration)
    val turkishMappings: Map<Int, TranslitChar> = mapOf(
        KeyEvent.KEYCODE_O to TranslitChar("ö", "Ö", "ö"),
        KeyEvent.KEYCODE_U to TranslitChar("ü", "Ü", "ü"),
        KeyEvent.KEYCODE_S to TranslitChar("ş", "Ş", "ş"),
        KeyEvent.KEYCODE_G to TranslitChar("ğ", "Ğ", "ğ"),
        KeyEvent.KEYCODE_I to TranslitChar("ı", "İ", "ı/İ"),
        KeyEvent.KEYCODE_C to TranslitChar("ç", "Ç", "ç")
    )

    // Soft keyboard characters per mode
    val translitChars: List<Pair<String, String>> = listOf(
        "ā" to "Ā", "ī" to "Ī", "ū" to "Ū",
        "ḥ" to "Ḥ", "ṣ" to "Ṣ", "ṭ" to "Ṭ",
        "ḍ" to "Ḍ", "ẓ" to "Ẓ", "š" to "Š",
        "ṯ" to "Ṯ", "ḫ" to "Ḫ", "ġ" to "Ġ",
        "ḏ" to "Ḏ", "ʿ" to "ʿ", "ʾ" to "ʾ"
    )

    val turkishChars: List<Pair<String, String>> = listOf(
        "ç" to "Ç", "ğ" to "Ğ", "ı" to "İ",
        "ö" to "Ö", "ş" to "Ş", "ü" to "Ü"
    )

    // Combined: all special chars for the "All" soft keyboard view
    val allChars: List<Pair<String, String>> = translitChars + turkishChars
}
