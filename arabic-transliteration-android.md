# Arabic Academic Transliteration on Android with Physical Keyboard

## Setup Guide for Samsung Galaxy Tab S10 Ultra

This guide provides practical solutions for typing standard scholarly Arabic transliteration characters (ISO 233 / DIN 31635 / EI2) on an Android tablet with a physical keyboard. It is designed for cataloguing, critical editions, and academic writing in the history of Arabic science and manuscripts.

---

## Quick Reference: Transliteration Characters

| Character | Unicode | Name | Usage |
|-----------|---------|------|-------|
| ā Ā | U+0101 / U+0100 | a with macron | Long vowel alif |
| ī Ī | U+012B / U+012A | i with macron | Long vowel yāʾ |
| ū Ū | U+016B / U+016A | u with macron | Long vowel wāw |
| ḥ Ḥ | U+1E25 / U+1E24 | h with dot below | Hāʾ (ح) |
| ṣ Ṣ | U+1E63 / U+1E62 | s with dot below | Ṣād (ص) |
| ṭ Ṭ | U+1E6D / U+1E6C | t with dot below | Ṭāʾ (ط) |
| ḍ Ḍ | U+1E0D / U+1E0C | d with dot below | Ḍād (ض) |
| ẓ Ẓ | U+1E93 / U+1E92 | z with dot below | Ẓāʾ (ظ) |
| š Š | U+0161 / U+0160 | s with caron | Shīn (ش) |
| ṯ Ṯ | U+1E6F / U+1E6E | t with line below | Thāʾ (ث) |
| ḫ Ḫ | U+1E2B / U+1E2A | h with breve below | Khāʾ (خ) |
| ġ Ġ | U+0121 / U+0120 | g with dot above | Ghayn (غ) |
| ʿ | U+02BF | modifier letter left half ring | ʿAyn (ع) |
| ʾ | U+02BE | modifier letter right half ring | Hamza (ء) |
| ḏ Ḏ | U+1E0F / U+1E0E | d with line below | Dhāl (ذ) |
| ṉ Ṉ | U+1E49 / U+1E48 | n with line below | (variant) |

---

## Solution 1: Custom Android Keyboard Layout with CKBM (Recommended)

### Overview

**Custom Keyboard Builder for Mechanical keyboards (CKBM)** or similar tools cannot directly create system-level Android keyboard layouts. Instead, we use the **Physical Keyboard** layout feature built into Android combined with a third-party input method.

### Step-by-step: Using "External Keyboard Helper Pro"

This is the most powerful and reliable solution for physical keyboard users on Android.

**1. Install External Keyboard Helper Pro**

- Open Google Play Store
- Search for **"External Keyboard Helper Pro"** (by Apedroid)
- Install the app (~$2.49, one-time purchase)

**2. Enable it as an Input Method**

- Go to **Settings > General Management > Keyboard list and default**
- Toggle on **External Keyboard Helper**
- Set it as the **default keyboard** when a physical keyboard is connected

**3. Create a Custom Layout**

- Open the External Keyboard Helper app
- Tap **"Custom layouts"**
- Tap **"+"** to create a new layout
- Name it: **"Arabic Transliteration"**

**4. Configure Key Mappings**

Map a modifier key (e.g., Right Alt / AltGr) as your transliteration layer trigger:

```
┌─────────────────────────────────────────────────────────────────┐
│                TRANSLITERATION LAYER (Right Alt + Key)          │
├──────────┬──────────┬──────────┬──────────┬──────────┬─────────┤
│ RAlt + a │ RAlt + i │ RAlt + u │ RAlt + h │ RAlt + s │ RAlt + t│
│    ā     │    ī     │    ū     │    ḥ     │    ṣ     │    ṭ    │
├──────────┼──────────┼──────────┼──────────┼──────────┼─────────┤
│ RAlt + d │ RAlt + z │ RAlt + x │ RAlt + g │ RAlt + c │ RAlt + v│
│    ḍ     │    ẓ     │    ḫ     │    ġ     │    š     │    ṯ    │
├──────────┼──────────┼──────────┼──────────┼──────────┼─────────┤
│ RAlt + [ │ RAlt + ] │ RAlt + e │ RAlt + n │          │         │
│    ʿ     │    ʾ     │    ḏ     │    ṉ     │          │         │
└──────────┴──────────┴──────────┴──────────┴──────────┴─────────┘

UPPERCASE: Right Alt + Shift + Key → Ā, Ī, Ū, Ḥ, Ṣ, Ṭ, Ḍ, Ẓ, Ḫ, Ġ, Š, Ṯ, Ḏ
```

**5. Map Each Key**

In the app's custom layout editor:

| Physical Key Combo | Output Character | Unicode |
|---|---|---|
| `RAlt + a` | ā | U+0101 |
| `RAlt + Shift + a` | Ā | U+0100 |
| `RAlt + i` | ī | U+012B |
| `RAlt + Shift + i` | Ī | U+012A |
| `RAlt + u` | ū | U+016B |
| `RAlt + Shift + u` | Ū | U+016A |
| `RAlt + h` | ḥ | U+1E25 |
| `RAlt + Shift + h` | Ḥ | U+1E24 |
| `RAlt + s` | ṣ | U+1E63 |
| `RAlt + Shift + s` | Ṣ | U+1E62 |
| `RAlt + t` | ṭ | U+1E6D |
| `RAlt + Shift + t` | Ṭ | U+1E6C |
| `RAlt + d` | ḍ | U+1E0D |
| `RAlt + Shift + d` | Ḍ | U+1E0C |
| `RAlt + z` | ẓ | U+1E93 |
| `RAlt + Shift + z` | Ẓ | U+1E92 |
| `RAlt + x` | ḫ | U+1E2B |
| `RAlt + Shift + x` | Ḫ | U+1E2A |
| `RAlt + g` | ġ | U+0121 |
| `RAlt + Shift + g` | Ġ | U+0120 |
| `RAlt + c` | š | U+0161 |
| `RAlt + Shift + c` | Š | U+0160 |
| `RAlt + v` | ṯ | U+1E6F |
| `RAlt + Shift + v` | Ṯ | U+1E6E |
| `RAlt + e` | ḏ | U+1E0F |
| `RAlt + Shift + e` | Ḏ | U+1E0E |
| `RAlt + [` | ʿ | U+02BF |
| `RAlt + ]` | ʾ | U+02BE |

**6. Save and Activate**

- Save the layout
- Connect your physical keyboard
- Go to **Settings > General Management > Physical keyboard**
- Select your keyboard, then choose **"External Keyboard Helper"**
- Select your custom **"Arabic Transliteration"** layout

---

## Solution 2: Gboard with Text Replacement (Simple, No App Purchase)

### Overview

Use Gboard's built-in **text replacement / personal dictionary** feature to create shortcut expansions. This works system-wide and requires no extra apps.

### Setup

**1. Install Gboard** (if not already installed)

- Google Play Store > **Gboard - the Google Keyboard**

**2. Add Text Replacements**

- Open **Gboard Settings > Dictionary > Personal dictionary > English**
- Add entries:

| Shortcut | Expansion | Notes |
|----------|-----------|-------|
| `\aa` | ā | Long a |
| `\AA` | Ā | Capital long a |
| `\ii` | ī | Long i |
| `\II` | Ī | Capital long i |
| `\uu` | ū | Long u |
| `\UU` | Ū | Capital long u |
| `\hd` | ḥ | h-dot-below |
| `\HD` | Ḥ | Capital h-dot |
| `\sd` | ṣ | s-dot-below |
| `\SD` | Ṣ | Capital s-dot |
| `\td` | ṭ | t-dot-below |
| `\TD` | Ṭ | Capital t-dot |
| `\dd` | ḍ | d-dot-below |
| `\DD` | Ḍ | Capital d-dot |
| `\zd` | ẓ | z-dot-below |
| `\ZD` | Ẓ | Capital z-dot |
| `\sv` | š | s-caron |
| `\SV` | Š | Capital s-caron |
| `\th` | ṯ | t-line-below |
| `\TH` | Ṯ | Capital t-line |
| `\kh` | ḫ | h-breve-below |
| `\KH` | Ḫ | Capital h-breve |
| `\gh` | ġ | g-dot-above |
| `\GH` | Ġ | Capital g-dot |
| `\dh` | ḏ | d-line-below |
| `\DH` | Ḏ | Capital d-line |
| `\ayn` | ʿ | Ayn |
| `\ham` | ʾ | Hamza |

**3. Usage**

Type the shortcut and select the replacement from the suggestion bar:

```
Type: al-\hd ak\ii m    →    al-ḥakīm
Type: \ayn ilm           →    ʿilm
Type: kit\aa b           →    kitāb
```

### Limitations

- Requires tapping the suggestion bar to confirm each replacement
- Slightly slower than direct key mappings
- May conflict with autocorrect in some cases

---

## Solution 3: Samsung Keyboard with Unicode Compose (Built-in)

### Overview

Samsung Keyboard on One UI supports a limited set of special characters through long-press on the software keyboard. For physical keyboards, you can use the **Unicode input method** built into Android.

### Method A: Samsung Clipboard Manager

**1. Create a Clipboard Collection**

- Open Samsung Keyboard
- Tap the **clipboard icon** in the toolbar
- Create a **pinned collection** named "Transliteration"
- Manually add each character by copying from the reference table above

**2. Quick Access**

- While typing, open the clipboard panel
- Tap the pinned transliteration character

### Method B: Samsung Text Shortcuts

- Go to **Settings > General Management > Samsung Keyboard Settings > Text shortcuts**
- Add shortcuts similar to Solution 2

---

## Solution 4: Multiling O Keyboard (Free, Highly Customizable)

### Overview

**Multiling O Keyboard** is a free, lightweight keyboard that supports custom physical keyboard layouts with full Unicode character mapping.

### Setup

**1. Install**

- Google Play Store > **Multiling O Keyboard**

**2. Enable**

- Settings > General Management > Keyboard list and default
- Enable Multiling O Keyboard

**3. Create Custom Layout**

- Open Multiling O Keyboard settings
- Go to **"Physical keyboard"** section
- Tap **"Custom layout"**
- Define key mappings using the same RAlt scheme as Solution 1

**4. Layout Definition**

Multiling O uses a text-based layout format. Create a file with these definitions:

```
# Arabic Transliteration Layout for Multiling O
# RAlt (AltGr) layer mappings

RALT a = ā
RALT A = Ā
RALT i = ī
RALT I = Ī
RALT u = ū
RALT U = Ū
RALT h = ḥ
RALT H = Ḥ
RALT s = ṣ
RALT S = Ṣ
RALT t = ṭ
RALT T = Ṭ
RALT d = ḍ
RALT D = Ḍ
RALT z = ẓ
RALT Z = Ẓ
RALT x = ḫ
RALT X = Ḫ
RALT g = ġ
RALT G = Ġ
RALT c = š
RALT C = Š
RALT v = ṯ
RALT V = Ṯ
RALT e = ḏ
RALT E = Ḏ
RALT [ = ʿ
RALT ] = ʾ
```

---

## Solution 5: Compose Key via Hacker's Keyboard (Advanced)

### Overview

Use **Hacker's Keyboard** which supports Compose key sequences similar to Linux, allowing intuitive multi-key input.

### Compose Sequences

```
Compose + - + a  →  ā   (macron = dash over letter)
Compose + - + i  →  ī
Compose + - + u  →  ū
Compose + . + h  →  ḥ   (dot below)
Compose + . + s  →  ṣ
Compose + . + t  →  ṭ
Compose + . + d  →  ḍ
Compose + . + z  →  ẓ
Compose + v + s  →  š   (caron / háček)
Compose + _ + t  →  ṯ   (line below)
Compose + _ + d  →  ḏ
Compose + u + h  →  ḫ   (breve below)
Compose + . + g  →  ġ   (dot above, mnemonic: dot + g)
```

---

## Recommended Setup

For serious academic work on the Galaxy Tab S10 Ultra, the recommended priority is:

### Tier 1: Best Experience
**External Keyboard Helper Pro** (Solution 1)
- Direct key mappings with RAlt modifier
- No delay, no suggestions to tap
- Works in every app system-wide
- Survives app updates and Android upgrades
- One-time $2.49 cost

### Tier 2: Free and Good
**Multiling O Keyboard** (Solution 4)
- Free and open-source
- Custom physical keyboard layouts
- Slightly less polished UI

### Tier 3: Quick and Simple
**Gboard Text Replacement** (Solution 2)
- No extra apps needed
- Works immediately
- Slightly slower workflow (must tap suggestion)

---

## Design Rationale for Key Mappings

The RAlt-based layout was designed with these principles:

### Mnemonic Associations

```
┌────────────────────────────────────────────────────────────────┐
│                    MNEMONIC LOGIC                               │
├──────────┬─────────────────────────────────────────────────────┤
│ RAlt + a │ ā — same base letter, intuitive                     │
│ RAlt + i │ ī — same base letter                                │
│ RAlt + u │ ū — same base letter                                │
│ RAlt + h │ ḥ — same base letter (hāʾ)                          │
│ RAlt + s │ ṣ — same base letter (ṣād)                          │
│ RAlt + t │ ṭ — same base letter (ṭāʾ)                          │
│ RAlt + d │ ḍ — same base letter (ḍād)                          │
│ RAlt + z │ ẓ — same base letter (ẓāʾ)                          │
│ RAlt + g │ ġ — same base letter (ghayn)                        │
│ RAlt + c │ š — c for č/š Slavic convention, easy to remember   │
│ RAlt + v │ ṯ — v for thāʾ (th voiced pair position on QWERTY) │
│ RAlt + x │ ḫ — x often represents kh-sound in transcription    │
│ RAlt + e │ ḏ — e for ḏhāl (dh pair)                           │
│ RAlt + [ │ ʿ — opening bracket shape ≈ left half ring          │
│ RAlt + ] │ ʾ — closing bracket shape ≈ right half ring         │
└──────────┴─────────────────────────────────────────────────────┘
```

### Finger Ergonomics

- All macron vowels (ā, ī, ū) are on the home row or top row for easy access
- Most frequent transliteration characters (ā, ī, ḥ, ṣ) are on strong fingers
- ʿAyn (ʿ) and Hamza (ʾ) on `[` and `]` — visually suggestive of their glyphs
- Right Alt is used as the modifier because the left hand remains free for letter keys

---

## Testing Your Setup

After configuration, test with these common transliteration examples:

| Arabic | Transliteration | Test String |
|--------|----------------|-------------|
| الحكيم | al-ḥakīm | al-RAlt+h akRAlt+i m |
| علم | ʿilm | RAlt+[ ilm |
| كتاب | kitāb | kitRAlt+a b |
| الصلاة | al-ṣalāt | al-RAlt+s alRAlt+a t |
| الطبيعيات | al-ṭabīʿiyyāt | al-RAlt+t abRAlt+i RAlt+[ iyyRAlt+a t |
| الخوارزمي | al-Ḫwārizmī | al-RAlt+Shift+x wRAlt+a rizmRAlt+i |
| الغزالي | al-Ġazālī | al-RAlt+Shift+g azRAlt+a lRAlt+i |
| شمس الدين | Šams al-Dīn | RAlt+Shift+c ams al-DRAlt+i n |
| ابن رشد | Ibn Rušd | Ibn RuRAlt+c d |
| الفارابي | al-Fārābī | al-FRAlt+a rRAlt+a bRAlt+i |
| ثابت بن قرة | Ṯābit ibn Qurra | RAlt+Shift+v RAlt+a bit ibn Qurra |
| حنين بن إسحاق | Ḥunayn ibn Isḥāq | RAlt+Shift+h unayn ibn IsRAlt+h RAlt+a q |

---

## Compatibility Notes

### Samsung Galaxy Tab S10 Ultra Specific

- **One UI 6.x / 7.x**: All solutions above are compatible
- **DeX Mode**: External Keyboard Helper Pro works in Samsung DeX
- **Bluetooth keyboards**: All solutions work with Bluetooth and USB keyboards
- **Samsung Book Cover Keyboard**: Fully compatible, RAlt key is available

### App Compatibility

| App | Status | Notes |
|-----|--------|-------|
| Microsoft Word | Works | Full Unicode support |
| Google Docs | Works | Full Unicode support |
| Samsung Notes | Works | Full Unicode support |
| Zotero | Works | For bibliography with transliteration |
| Obsidian | Works | Markdown notes with transliteration |
| Plain text editors | Works | Any app accepting Unicode text |
| LaTeX editors (Overleaf) | Works | Direct Unicode or `\textit{...}` commands |

### Font Recommendations

Not all fonts display combining diacritics correctly. Use these fonts for reliable rendering:

- **Gentium Plus** — Designed specifically for Latin-script transliteration of non-Latin scripts
- **Charis SIL** — Academic font with full IPA and transliteration support
- **Brill** — Professional academic font (Brill publishing house)
- **Junicode** — Medievalist and scholarly font
- **Linux Libertine** — Good general-purpose with broad Unicode coverage
- **Noto Serif / Noto Sans** — Google's universal font, preinstalled on Android

---

## Troubleshooting

### Common Issues

**Problem**: RAlt key not recognized as AltGr
**Solution**: In External Keyboard Helper, go to Settings > "Right Alt behavior" > Select "AltGr / Compose"

**Problem**: Characters appear as boxes or question marks
**Solution**: The app's font doesn't support the Unicode character. Switch to a supported font (see Font Recommendations above)

**Problem**: Keyboard layout resets after disconnecting
**Solution**: In Settings > General Management > Physical keyboard, make sure your preferred layout is pinned as default

**Problem**: Autocorrect "fixes" transliteration characters
**Solution**: Disable autocorrect for your transliteration keyboard layout, or add transliteration words to your personal dictionary

**Problem**: Some characters render with separate diacritics instead of precomposed forms
**Solution**: Make sure you're using the precomposed Unicode characters (e.g., U+1E25 for ḥ) rather than combining sequences (e.g., h + U+0323). External Keyboard Helper outputs precomposed forms by default.

---

## Appendix: Complete Character Map with Arabic Equivalents

```
┌────────┬───────────┬──────────────┬──────────┬────────────────┐
│ Arabic │ Name      │ Transliterat.│ Key Combo│ Unicode        │
├────────┼───────────┼──────────────┼──────────┼────────────────┤
│   ا    │ Alif      │ ā            │ RAlt+a   │ U+0101         │
│   ب    │ Bāʾ       │ b            │ b        │ (standard)     │
│   ت    │ Tāʾ       │ t            │ t        │ (standard)     │
│   ث    │ Thāʾ      │ ṯ            │ RAlt+v   │ U+1E6F         │
│   ج    │ Jīm       │ ǧ / j       │ j        │ (standard)     │
│   ح    │ Ḥāʾ       │ ḥ            │ RAlt+h   │ U+1E25         │
│   خ    │ Khāʾ      │ ḫ            │ RAlt+x   │ U+1E2B         │
│   د    │ Dāl       │ d            │ d        │ (standard)     │
│   ذ    │ Dhāl      │ ḏ            │ RAlt+e   │ U+1E0F         │
│   ر    │ Rāʾ       │ r            │ r        │ (standard)     │
│   ز    │ Zāy       │ z            │ z        │ (standard)     │
│   س    │ Sīn       │ s            │ s        │ (standard)     │
│   ش    │ Shīn      │ š            │ RAlt+c   │ U+0161         │
│   ص    │ Ṣād       │ ṣ            │ RAlt+s   │ U+1E63         │
│   ض    │ Ḍād       │ ḍ            │ RAlt+d   │ U+1E0D         │
│   ط    │ Ṭāʾ       │ ṭ            │ RAlt+t   │ U+1E6D         │
│   ظ    │ Ẓāʾ       │ ẓ            │ RAlt+z   │ U+1E93         │
│   ع    │ ʿAyn      │ ʿ            │ RAlt+[   │ U+02BF         │
│   غ    │ Ghayn     │ ġ            │ RAlt+g   │ U+0121         │
│   ف    │ Fāʾ       │ f            │ f        │ (standard)     │
│   ق    │ Qāf       │ q            │ q        │ (standard)     │
│   ك    │ Kāf       │ k            │ k        │ (standard)     │
│   ل    │ Lām       │ l            │ l        │ (standard)     │
│   م    │ Mīm       │ m            │ m        │ (standard)     │
│   ن    │ Nūn       │ n            │ n        │ (standard)     │
│   ه    │ Hāʾ       │ h            │ h        │ (standard)     │
│   و    │ Wāw       │ w / ū        │ w/RAlt+u │ (std)/U+016B   │
│   ي    │ Yāʾ       │ y / ī        │ y/RAlt+i │ (std)/U+012B   │
│   ء    │ Hamza     │ ʾ            │ RAlt+]   │ U+02BE         │
│   ة    │ Tāʾ marb. │ a / at       │ a/at     │ (standard)     │
│   ال   │ Article   │ al-          │ al-      │ (standard)     │
└────────┴───────────┴──────────────┴──────────┴────────────────┘
```

---

## License

This guide is released under the MIT License as part of the Keyboard Design project.
