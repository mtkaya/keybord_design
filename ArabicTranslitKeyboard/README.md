# Arabic Transliteration Keyboard (Android)

Android IME (Input Method Editor) for academic Arabic transliteration. Designed for Samsung Galaxy Tab S10 Ultra with physical keyboard.

## Features

- **Physical keyboard**: RAlt + key → transliteration character (system-wide)
- **Soft keyboard**: On-screen grid with all 15 transliteration characters
- **Shift support**: Uppercase via RAlt + Shift + key or on-screen shift toggle
- **Standard**: DIN 31635 / Encyclopaedia of Islam (EI2)
- **Zero interference**: Normal typing unaffected, only RAlt combos trigger transliteration

## Key Mappings

| Combo | Output | Arabic |
|-------|--------|--------|
| RAlt+a | ā/Ā | ا Alif |
| RAlt+i | ī/Ī | ي Yāʾ |
| RAlt+u | ū/Ū | و Wāw |
| RAlt+h | ḥ/Ḥ | ح Ḥāʾ |
| RAlt+s | ṣ/Ṣ | ص Ṣād |
| RAlt+t | ṭ/Ṭ | ط Ṭāʾ |
| RAlt+d | ḍ/Ḍ | ض Ḍād |
| RAlt+z | ẓ/Ẓ | ظ Ẓāʾ |
| RAlt+c | š/Š | ش Shīn |
| RAlt+g | ġ/Ġ | غ Ghayn |
| RAlt+x | ḫ/Ḫ | خ Khāʾ |
| RAlt+v | ṯ/Ṯ | ث Thāʾ |
| RAlt+e | ḏ/Ḏ | ذ Dhāl |
| RAlt+[ | ʿ | ع ʿAyn |
| RAlt+] | ʾ | ء Hamza |

## Build

```bash
cd ArabicTranslitKeyboard
./gradlew assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`

## Install

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

Or transfer the APK to your tablet and open it.

## Setup on Device

1. Open the app
2. Tap "Enable Keyboard in Settings" → toggle on "Arabic Transliteration Keyboard"
3. Tap "Switch to This Keyboard" → select it
4. Connect physical keyboard and use RAlt combos

## Requirements

- Android 8.0+ (API 26)
- Android Studio or Gradle 8.5+ for building
- Physical keyboard with Right Alt key (recommended)

## License

MIT
