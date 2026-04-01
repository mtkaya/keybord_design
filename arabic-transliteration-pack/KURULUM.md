# Kurulum Rehberi — Hizli Baslangic

## Yontem 1: External Keyboard Helper Pro (Onerilen)

### Adim 1: Uygulamayi Yukle
- Google Play Store > "External Keyboard Helper Pro" (Apedroid) > Yukle

### Adim 2: Etkinlestir
- Ayarlar > Genel Yonetim > Klavye listesi ve varsayilan
- "External Keyboard Helper" acik konuma getir

### Adim 3: Duzeni Yukle
- External Keyboard Helper uygulamasini ac
- "Custom layouts" > "+" > "Arabic Transliteration" adi ver
- `configs/ekh-layout.json` dosyasindaki eslestirmeleri tek tek gir:
  - Her satirda: Key combination > Output character
  - Ornek: Right Alt + a > ā

### Adim 4: Fiziksel Klavyeye Ata
- Ayarlar > Genel Yonetim > Fiziksel klavye
- Klavyeni sec > "External Keyboard Helper" > "Arabic Transliteration"

### Adim 5: Test Et
- Herhangi bir uygulamada RAlt + a yazarak ā gordugunuzu dogrulayin

---

## Yontem 2: Gboard Sozluk (Ucretsiz, Hizli)

### Adim 1: Gboard Yukle
- Google Play Store > Gboard

### Adim 2: Kisayollari Ekle
- Gboard Ayarlar > Sozluk > Kisisel sozluk > Turkce/English
- `configs/gboard-dictionary.txt` dosyasindaki her satiri ekle:
  - Kelime: ā / Kisayol: \aa
  - Kelime: ḥ / Kisayol: \hd
  - ... (tum liste dosyada mevcut)

### Adim 3: Kullan
- Yazarken \aa yaz > oneri cubugundan ā sec

---

## Yontem 3: Multiling O (Ucretsiz, Guclu)

### Adim 1: Yukle
- Google Play Store > Multiling O Keyboard

### Adim 2: Duzeni Aktar
- Multiling O > Ayarlar > Physical keyboard > Custom layout
- `configs/multiling-o-layout.txt` icerigini yapistir

### Adim 3: Etkinlestir
- Ayarlar > Genel Yonetim > Klavye listesi > Multiling O etkinlestir

---

## Paket Icerigi

```
arabic-transliteration-pack/
├── KURULUM.md                          ← Bu dosya
├── configs/
│   ├── ekh-layout.json                 ← External Keyboard Helper ayarlari
│   ├── gboard-dictionary.txt           ← Gboard sozluk kisayollari
│   └── multiling-o-layout.txt          ← Multiling O klavye duzeni
└── cheatsheet/
    └── cheatsheet.md                   ← Yazdirilabilir hizli referans karti
```

## Onerilen Fontlar

Android'de dogru gorunum icin bu fontlardan birini kullanin:
- **Gentium Plus** — transliterasyon icin ozel tasarlanmis
- **Charis SIL** — akademik font
- **Noto Serif** — Android'de yerlesik, genis Unicode destegi
