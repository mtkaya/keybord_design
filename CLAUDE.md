# Arabic Transliteration Keyboard - Project Notes

## Project Overview
Android IME (Input Method Editor) for academic Arabic transliteration + Turkish characters.
Target device: Samsung Galaxy Tab S10 Ultra with physical keyboard.

## Build Instructions
```bash
cd ArabicTranslitKeyboard
export JAVA_HOME=/opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk/Contents/Home
export ANDROID_HOME=$HOME/Library/Android/sdk
./gradlew clean assembleDebug
```
APK output: `app/build/outputs/apk/debug/app-debug.apk`

## Branch
- Development: `claude/arabic-transliteration-android-GwEdj`
- PR: mtkaya/keybord_design#1

## Key Files
- `ArabicTranslitKeyboard/` — Android IME app (Kotlin)
  - `TranslitMap.kt` — Character mappings (translit + Turkish)
  - `TranslitInputMethodService.kt` — IME service (physical + soft keyboard)
  - `MainActivity.kt` — Setup wizard + key reference
- `arabic-transliteration-android.md` — Full documentation
- `arabic-transliteration-pack/` — Config files for existing keyboard apps
- `.github/workflows/build-apk.yml` — CI/CD for APK build

## RAlt Key Mappings

### Transliteration (Translit mode)
| Key | Output | Key | Output |
|-----|--------|-----|--------|
| RAlt+a | ā/Ā | RAlt+h | ḥ/Ḥ |
| RAlt+i | ī/Ī | RAlt+s | ṣ/Ṣ |
| RAlt+u | ū/Ū | RAlt+t | ṭ/Ṭ |
| RAlt+d | ḍ/Ḍ | RAlt+z | ẓ/Ẓ |
| RAlt+c | š/Š | RAlt+g | ġ/Ġ |
| RAlt+x | ḫ/Ḫ | RAlt+v | ṯ/Ṯ |
| RAlt+e | ḏ/Ḏ | RAlt+[ | ʿ |
| RAlt+] | ʾ | | |

### Turkish (TR mode)
| Key | Output |
|-----|--------|
| RAlt+o | ö/Ö |
| RAlt+u | ü/Ü |
| RAlt+s | ş/Ş |
| RAlt+g | ğ/Ğ |
| RAlt+i | ı/İ |
| RAlt+c | ç/Ç |

## User Feedback (Hüseyin Şen, 3 Apr 2026)
- [x] RAlt + key not working on physical keyboard → Fixed: added Ctrl+Alt combo detection
- [x] Add Turkish characters (İ, Ş, Ğ, Ö, Ü, Ç) → Added TR mode
- [x] Soft keyboard takes too much screen space → Collapsible toolbar (▲/▼)
- [x] Language switching (EN/TR/Translit) → Mode button cycles through
- [ ] Future: Integrated DH workbench (web-based editor + tools)

## Future Vision (from Hüseyin)
- Web-based editor with transliteration support
- Online login, document management
- Digital humanities tool integration (IIIF, TEI-XML, OCR, Zotero)
