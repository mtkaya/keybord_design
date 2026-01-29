---
title: "Keyboard Design: Ergonomiden Mekaniğe Kapsamlı Bir Rehber"
emoji: ⌨️
colorFrom: blue
colorTo: purple
sdk: static
pinned: false
license: mit
tags:
  - keyboard
  - design
  - ergonomics
  - mechanical-keyboard
  - hardware
---

# ⌨️ Keyboard Design: Ergonomiden Mekaniğe Kapsamlı Bir Rehber

## Giriş

Klavye tasarımı, insan-bilgisayar etkileşiminin en temel bileşenlerinden biridir. Günde ortalama 8 saat bilgisayar başında çalışan bir profesyonel, yılda yaklaşık **2 milyon tuş vuruşu** gerçekleştirir. Bu nedenle klavye tasarımı; ergonomi, malzeme bilimi, elektronik mühendisliği ve kullanıcı deneyimi gibi birçok disiplini kapsayan kritik bir alandır.

Bu makalede klavye tasarımının temel prensiplerini, modern yaklaşımları ve gelecekteki trendleri inceliyoruz.

---

## 1. Klavye Düzeninin Evrimi

### 1.1 QWERTY ve Tarihi

1873 yılında Christopher Latham Sholes tarafından geliştirilen QWERTY düzeni, daktilo çağından günümüze kadar varlığını sürdürmüştür. İlk tasarım amacı mekanik kolların birbirine takılmasını önlemekti — ancak bu düzen, dijital çağda ergonomik açıdan sorgulanmaktadır.

### 1.2 Alternatif Düzenler

| Düzen | Yıl | Avantaj |
|-------|-----|---------|
| **Dvorak** | 1936 | Daha az parmak hareketi |
| **Colemak** | 2006 | QWERTY'den kolay geçiş |
| **Workman** | 2010 | Parmak kuvvetine göre optimize |
| **BÉPO** | 2003 | Fransızca için optimize |
| **F-Klavye** | 1955 | Türkçe için optimize (İhsan Sıtkı Yener) |

### 1.3 Türk F-Klavye

Türkçe'nin harf frekans analizi temel alınarak tasarlanan F-Klavye, Türkçe yazımda QWERTY'ye kıyasla **%30 daha az parmak hareketi** sağlar. Ancak günümüzde yaygın kullanımı sınırlı kalmıştır.

---

## 2. Ergonomik Tasarım Prensipleri

### 2.1 Temel Ergonomik Faktörler

```
┌─────────────────────────────────────────┐
│           Ergonomik Klavye Tasarımı       │
├─────────────┬─────────────┬─────────────┤
│  Fiziksel   │  Düzen      │  Kullanım   │
│  Form       │  Optimizas. │  Alışkanlık │
├─────────────┼─────────────┼─────────────┤
│ • Eğim açısı│ • Harf      │ • Tuş       │
│ • Bölünmüş  │   frekansı  │   kuvveti   │
│   tasarım   │ • Parmak    │ • Geri      │
│ • Tentleme  │   mesafesi  │   bildirim  │
│ • Bilek     │ • El        │ • Ses       │
│   desteği   │   alternansı│   seviyesi  │
└─────────────┴─────────────┴─────────────┘
```

### 2.2 Split (Bölünmüş) Klavye Tasarımı

Bölünmüş klavyeler, omuz genişliğinde konumlandırma imkânı sunarak ulnar deviasyonu (bileklerin içe bükülmesi) minimize eder. Öne çıkan örnekler:

- **Ergodox EZ** — Tamamen bölünmüş, ortolineer
- **Kinesis Advantage360** — Konkav tuş yuvası, bölünmüş
- **ZSA Moonlander** — Modüler, ayarlanabilir açı
- **Dactyl Manuform** — 3D baskı, özelleştirilebilir

### 2.3 Tuş Sayısı ve Katman Sistemi

Modern ergonomik tasarımda, daha az tuş kullanılarak katman (layer) sistemiyle tüm fonksiyonlara erişim sağlanır:

| Boyut | Tuş Sayısı | Kullanım |
|-------|-----------|----------|
| Full-size | 104+ | Geleneksel |
| TKL (Tenkeyless) | ~87 | Numpad'siz |
| 75% | ~84 | Kompakt TKL |
| 65% | ~68 | Fonksiyon satırsız |
| 60% | ~61 | Minimal |
| 40% | ~40-48 | Ultra kompakt, katman tabanlı |

---

## 3. Mekanik Anahtar (Switch) Teknolojisi

### 3.1 Anahtar Tipleri

Mekanik anahtarlar üç ana kategoride incelenir:

**Lineer (Doğrusal)**
- Pürüzsüz, kesintisiz basış
- Örnek: Cherry MX Red, Gateron Yellow
- Kullanım: Oyun, hızlı yazım

**Taktil (Dokunsal)**
- Basış noktasında belirgin tırtık
- Örnek: Cherry MX Brown, Holy Panda
- Kullanım: Programlama, genel yazım

**Clicky (Tıklamalı)**
- Sesli geri bildirim
- Örnek: Cherry MX Blue, Kailh Box White
- Kullanım: Daktilovari his isteyenler

### 3.2 Anahtar Parametreleri

```
Kuvvet-Mesafe Grafiği (Taktil Anahtar)

Kuvvet (gf)
  60 │         ╭─╮
  55 │        ╭╯ ╰╮
  50 │       ╭╯   ╰╮
  45 │      ╭╯     ╰─────── Dip noktası
  40 │     ╭╯
  35 │    ╭╯  ← Taktil nokta
  30 │   ╭╯
  25 │  ╭╯
  20 │ ╭╯
  15 │╭╯
     └──────────────────── Mesafe (mm)
      0  0.5  1  1.5  2  2.5  3  3.5  4
```

**Temel parametreler:**
- **Aktüasyon kuvveti**: 35-80gf arası
- **Aktüasyon mesafesi**: 1.0-2.0mm
- **Toplam mesafe**: 3.0-4.0mm
- **Ömür**: 50-100 milyon basış

---

## 4. PCB ve Elektronik Tasarım

### 4.1 Mikrodenetleyici Seçimi

| MCU | Çekirdek | Fiyat | Özellik |
|-----|----------|-------|---------|
| ATmega32U4 | AVR 8-bit | $ | Klasik, QMK desteği |
| STM32F072 | ARM Cortex-M0 | $$ | USB, daha güçlü |
| RP2040 | ARM Cortex-M0+ | $ | Çift çekirdek, ucuz |
| nRF52840 | ARM Cortex-M4 | $$$ | Bluetooth 5.0 |

### 4.2 Tuş Matrisi

Tuş matrisi, satır ve sütun hatları ile minimum pin kullanımı sağlar:

```
        C0    C1    C2    C3
        │     │     │     │
R0 ──┬──┤──┬──┤──┬──┤──┬──┤
     [K] │ [K] │ [K] │ [K] │
R1 ──┬──┤──┬──┤──┬──┤──┬──┤
     [K] │ [K] │ [K] │ [K] │
R2 ──┬──┤──┬──┤──┬──┤──┬──┤
     [K] │ [K] │ [K] │ [K] │
        │     │     │     │

4 satır × 4 sütun = 16 tuş, sadece 8 pin ile
```

### 4.3 Firmware

Açık kaynak firmware seçenekleri:

- **QMK** — En yaygın, C tabanlı, kapsamlı özellik seti
- **ZMK** — Zephyr RTOS tabanlı, kablosuz odaklı
- **KMK** — CircuitPython tabanlı, kolay öğrenme eğrisi
- **Kaleidoscope** — Keyboardio projeleri için

---

## 5. Kasa ve Malzeme Tasarımı

### 5.1 Malzeme Karşılaştırması

| Malzeme | Ağırlık | Ses | Maliyet | Üretim |
|---------|---------|-----|---------|--------|
| ABS Plastik | Hafif | Yüksek | Düşük | Enjeksiyon kalıp |
| Alüminyum | Orta | Düşük | Orta | CNC freze |
| Pirinç | Ağır | Çok düşük | Yüksek | CNC freze |
| Polikarbonat | Hafif | Orta | Düşük | Enjeksiyon kalıp |
| Ahşap | Orta | Düşük | Orta | CNC/El işçiliği |
| Reçine (3D) | Değişken | Orta | Düşük | 3D baskı |

### 5.2 Montaj Stilleri

```
Tray Mount        Gasket Mount       Top Mount
┌──────────┐     ┌──────────┐      ┌──────────┐
│ ▓▓▓▓▓▓▓▓ │     │ ▓▓▓▓▓▓▓▓ │      │╲▓▓▓▓▓▓╱ │
│ │      │ │     │ ░▓▓▓▓▓▓░ │      │ ▓▓▓▓▓▓▓▓ │
│ │      │ │     │ ░      ░ │      │          │
│ ▲  ▲  ▲ │     │ ░      ░ │      │          │
└──────────┘     └──────────┘      └──────────┘
  Vida noktaları   Gasket (conta)     Üst bağlantı
```

- **Tray Mount**: Basit, sert his
- **Gasket Mount**: Esnek, premium his
- **Top Mount**: Dengeli, hafif esnek

---

## 6. Keycap (Tuş Kapağı) Tasarımı

### 6.1 Profiller

```
SA      Cherry    DSA     MT3     XDA
╭───╮   ╭───╮   ╭───╮   ╭───╮   ╭───╮
│   │   │   │   │   │   │   │   │   │
│   │   ╰───╯   ╰───╯   │   │   ╰───╯
│   │                    ╰───╯
╰───╯
Yüksek  Orta     Düşük   Yüksek  Düşük
Sculpted Sculpted Uniform Sculpted Uniform
```

### 6.2 Malzeme

- **ABS**: Pürüzsüz, zamanla parlar, doubleshot uyumlu
- **PBT**: Dayanıklı, mat yüzey, parmak izi tutmaz
- **POM**: Pürüzsüz, dayanıklı, nadir

### 6.3 Baskı Yöntemleri

1. **Doubleshot**: İki renkli plastik enjeksiyon — en dayanıklı
2. **Dye-sublimation**: Isı ile boya transferi — detaylı tasarım
3. **Pad printing**: Yüzey baskı — en ucuz, aşınır
4. **Laser etching**: Lazer kazıma — hassas ama sınırlı renk

---

## 7. Ses ve His Optimizasyonu

### 7.1 Modifikasyonlar

Modern klavye meraklıları aşağıdaki modları uygular:

| Mod | Etki | Zorluk |
|-----|------|--------|
| **Lube (Yağlama)** | Pürüzsüz his, düşük ses | Orta |
| **Film** | Anahtar kasa sıkılığı | Kolay |
| **Tape mod** | Daha derin ses tonu | Kolay |
| **PE foam** | Pop ses karakteri | Kolay |
| **Band-aid mod** | Stabilizer gıcırtı azaltma | Kolay |
| **Holee mod** | Stabilizer tel ses azaltma | Zor |
| **Spring swap** | Kuvvet özelleştirme | Orta |
| **Force break mod** | Esnek PCB hissi | Orta |

### 7.2 Ses Profili Bileşenleri

```
Ses = Anahtar sesi + Plaka materyali + Kasa materyali
      + Dolgu malzemesi + Stabilizer kalitesi
      + Keycap profili + Masa yüzeyi
```

---

## 8. Tasarım Süreci: Sıfırdan Klavye

### Adım 1: Düzen Belirleme
Keyboard Layout Editor (KLE) ile düzeninizi çizin.

### Adım 2: PCB Tasarımı
KiCad veya EasyEDA ile şematik ve PCB tasarımı yapın.

### Adım 3: Plaka Tasarımı
Ai03 Plate Generator veya SwillKB ile plaka DXF dosyası oluşturun.

### Adım 4: Kasa Tasarımı
Fusion 360, FreeCAD veya SolidWorks ile 3D model oluşturun.

### Adım 5: Prototipleme
3D baskı ile ilk prototipleri üretin ve test edin.

### Adım 6: Firmware
QMK veya ZMK ile firmware yazın ve tuş haritasını yapılandırın.

### Adım 7: Test ve İterasyon
Kullanıcı testleri yapın, geri bildirim toplayın, iyileştirin.

---

## 9. Yapay Zeka ve Klavye Tasarımı

AI, klavye tasarımında yeni olanaklar sunmaktadır:

- **Düzen optimizasyonu**: Genetik algoritmalar ile dil bazlı tuş düzeni optimizasyonu
- **Ses analizi**: Spektrogram analizi ile ses profili tahmini
- **Ergonomi modelleme**: Biomeknik simülasyonlar ile el yorgunluğu tahmini
- **Kişiselleştirme**: Kullanıcı yazım verilerine göre adaptif tuş haritaları
- **Üretim kalite kontrol**: Bilgisayarlı görü ile switch/PCB denetimi

---

## 10. Gelecek Trendler

1. **Hall Effect anahtarlar** — Manyetik algılama, sıfır temas aşınması
2. **Analog tuş girişi** — Basış derinliğine duyarlı kontrol
3. **Haptic feedback** — Programlanabilir dokunsal geri bildirim
4. **Optik anahtarlar** — Işık tabanlı aktüasyon, ultra hızlı tepki
5. **Sürdürülebilir malzemeler** — Geri dönüştürülmüş/biyobozunur malzemeler
6. **AI destekli adaptif düzenler** — Gerçek zamanlı tuş haritası optimizasyonu

---

## Kaynaklar ve Topluluk

- [QMK Firmware](https://qmk.fm/) — Açık kaynak klavye firmware
- [ZMK Firmware](https://zmk.dev/) — Kablosuz klavye firmware
- [Keyboard Layout Editor](http://www.keyboard-layout-editor.com/) — Düzen tasarım aracı
- [ai03 Design Guide](https://wiki.ai03.com/) — PCB tasarım rehberi
- [GeekHack](https://geekhack.org/) — Mekanik klavye forumu
- [r/MechanicalKeyboards](https://reddit.com/r/MechanicalKeyboards) — Reddit topluluğu

---

## Lisans

Bu makale MIT lisansı altında paylaşılmaktadır. Katkıda bulunmak için pull request gönderebilirsiniz.

---

*Bu makale klavye tasarımına ilgi duyan mühendisler, tasarımcılar ve meraklılar için hazırlanmıştır.*
