Merhaba! Dosyaları inceledim. Bu pratik proje aslında **OOP (Nesne Yönelimli Programlama) + Java Collections + Generics + Functional Interface (Predicate/Function) + Sıralama (Comparable/Comparator)** konularını tek bir senaryoda göstermek için yazılmış.

Aşağıda önce **projenin genel hedefini**, sonra da **App.java içindeki yorum bloklarının (/* … */ ve // …) Türkçe açıklamasını** veriyorum. En sonda da **sınav için “bu projeden ne sorarlar?”** şeklinde hızlı hazırlık notları var.

---

## 1) Projenin öğretmek istediği genel hedef

Bu proje, farklı geometrik şekilleri (**Triangle/Rectangle/Square/Circle**) tek bir üst tipe bağlayıp (**GeometricShape**) şunları öğretmek istiyor:

* **Soyutlama (Abstraction / Soyutlama):**
  `GeometricShape` soyut sınıf; “Her şeklin alanı ve çevresi vardır” fikrini zorunlu kılıyor:
  `calculateArea()` ve `calculatePerimeter()` abstract.

* **Kalıtım (Inheritance / Kalıtım):**
  `Rectangle extends GeometricShape`, `Square extends Rectangle`, `Circle/Triangle extends GeometricShape`.

* **Çok biçimlilik (Polymorphism / Çok biçimlilik):**
  `ArrayList<GeometricShape>` içine farklı şekiller ekleyip aynı metodları (`calculateArea`, `toString` vs.) tek listeden çağırmak.

* **Karşılaştırma & Sıralama (Comparable/Comparator):**

    * `GeometricShape implements Comparable` → doğal sıralama (alan üzerinden).
    * `GeometricShapeAreaComparator`, `GeometricShapePerimeterComparator` → alternatif sıralamalar.

* **Fonksiyonel programlama temeli (Functional Interface):**

    * `Predicate<GeometricShape>` ile filtreleme (`filterShapes`)
    * `Function<T,R>` ile dönüştürme/uygulama (`applyToShapes`)
    * **Anonymous class (Anonim sınıf)** ve **lambda** örnekleri

* **Generics (Jenerikler):**
  `applyToShapes` metodunda `T extends GeometricShape` gibi bounded generic kullanımı.

> Not: `App.java` içinde yorumlarda geçen `CustomLinkedList`, `MyGenericMethodDemo`, `Utility.Validator` sınıfları bu yüklenen dosyaların içinde yok. Muhtemelen derste başka pratiklerden kalmış/başka dosyalarda vardı.

---

## 2) Yorum satırlarının Türkçe açıklaması (App.java)

Aşağıdaki açıklamalar, **App.java içindeki her yorum bloğunun neyi göstermek için yazıldığını** anlatır.

### Blok 1 (CustomLinkedList kullanımı)

Bu yorum bloğu şunu göstermek için:

* `CustomLinkedList<Integer>` ve `CustomLinkedList<String>` ile **generic sınıf (Generic Class / Jenerik sınıf)** kullanımını
* Listeye `add`, listeden `remove`, `get(index)`, `size`, `isEmpty` gibi temel operasyonları
* `Iterator` ile dolaşmayı:

    * `for-each` döngüsü (`for (Integer number : numberList)`)
    * manuel iterator (`while(iterator.hasNext())`)

✅ Sınavda: “Iterator nedir?”, “for-each arkasında ne çalışır?” gibi sorular buradan gelir.

---

### Blok 2 (Generic method ile array yazdırma)

Burada amaç:

* `MyGenericMethodDemo.printArray(...)` gibi **generic method (Generic Method / Jenerik metot)** kullanımını göstermek.
* Şu iki kullanımın aynı anlama geldiğini vurgulamak:

    * `MyGenericMethodDemo.<Integer>printArray(integers);`
    * `MyGenericMethodDemo.printArray(integers);` (type inference / tür çıkarımı)

---

### Blok 3 (calculateTax örneği)

Amaç:

* `MyGenericMethodDemo` içindeki bir metodun kullanımını (muhtemelen basit bir örnek metot).
* “Nesne oluştur → metot çağır → sonuç yazdır” temel akışı.

---

### Blok 4 (copyTo ve generics type compatibility)

Bu blok çok “sınavlık”:

* `src: ArrayList<Integer>`
* `dest: ArrayList<Object>` / `ArrayList<Number>` / `ArrayList<Integer>` gibi hedeflere kopyalama denemeleri var.

Vermek istediği mesaj:

* Generics **invariance** (jeneriklerin tür uyumluluğu) meselesi:
  `ArrayList<Integer>` **bir** `ArrayList<Number>` değildir (normalde direkt atama olmaz).
  Ama doğru yazılmış bir `copyTo` metodu `? super Integer` gibi wildcard ile bunu çözebilir.
* Yorumda özellikle “`ArrayList<Double>` içine `Integer` kopyalayamazsın” denmiş.

✅ Sınavda: “`? extends` vs `? super` ne işe yarar?” sorusu buradan çıkabilir.

---

## 3) Geometrik şekiller kısmındaki yorumlar

### App içinde tek satır yorum (//Predicate<GeometricShape> a = …)

```java
//Predicate<GeometricShape> a = (t) -> t.calculateArea()>12;
```

Türkçesi:
“Alanı 12’den büyük olan şekilleri seçen bir Predicate yazılabilir; bu satır bunun örneği.”

---

### Blok 5 (Filtrelemenin kısa lambda ile yapılması denemesi)

Bu blok biraz karışık yazılmış ama niyet şu:

* `filterShapes(elements, (t) -> t.calculateArea()>12)` gibi **lambda ile predicate verme** fikri.
* Yorum içinde ayrıca “anonim sınıfla da yapılır” alternatifi gösterilmeye çalışılmış.

---

### Blok 6 (filteredShapes_ listesini yazdırma)

Bu blok:

* `filteredShapes_` ile (renge göre filtreleme: `t.getColor().equals("Red")`)
* Filtrelenmiş listeyi dolaşıp yazdırmayı gösteriyor.
* `"___________"` çizgisi: çıktıyı ayırmak için.

---

### Blok 7 (Static nested class ile predicate kullanımı)

```java
new GeometricShape.AreaGreaterThan12Predicate()
```

Amaç:

* `GeometricShape` içinde tanımlı **static nested class (Statik iç sınıf)** olan predicate’i kullanmak.
* “Predicate’i ayrı bir sınıf olarak da tanımlayabilirsin” yaklaşımı.

Not: Aynı iş için ayrıca ayrı dosya olarak `AreaGreaterThan12Predicate.java` da var (iki farklı öğretim yolu).

---

### Blok 8 (Anonim sınıf açıklama bloğu)

Bu blok, ders anlatımı gibi:

* “Unnamed/anonymous class (Anonim sınıf) tanımlıyorum”
* “Predicate interface’ini burada implement ediyorum”
* “Noktayı koymayı unutma (`;`)” gibi vurgular

---

### Blok 9 (Anonymous class ile predicate vererek filtreleme)

Bu blok doğrudan şunu yapıyor:

* `new Predicate<GeometricShape>() { ... }` şeklinde **anonim sınıf** oluşturuyor
* `test()` metodunda alan > 12 koşulunu yazıyor
* Sonra filtrelenmişleri yazdırıyor

---

### Blok 10 (Lambda – açık türle yazılmış hali)

```java
(GeometricShape gS) -> gS.calculateArea() > 12
```

Amaç:

* Lambda’da parametre türünü **açıkça yazabileceğini** göstermek.

---

### Blok 11 (Lambda – tür çıkarımı ile kısa hali)

```java
(gS) -> gS.calculateArea() > 12
```

Amaç:

* Java’nın türü çıkarabildiğini (type inference) göstermek.

---

### Blok 12 (Lambda – en kısa kullanım + çıktı)

```java
filterShapes(elements, (gS) -> gS.calculateArea()>12)
```

Amaç:

* Predicate’i inline verip filtreleme + yazdırma.

---

## 4) Sıralama (Sorting) yorum bloğu

### Blok 13 (Comparable ve Comparator ile sıralama)

Bu blok şunları gösteriyor:

1. **Comparable ile sıralama (Natural ordering / Doğal sıralama)**

```java
Collections.sort(elements);
```

`GeometricShape.compareTo()` alan farkına göre çalışıyor → alanına göre sıralar.

2. **Comparator ile alana göre sıralama**

```java
Collections.sort(elements, new GeometricShapeAreaComparator());
```

Bu comparator içeride `o1.compareTo(o2)` çağırıyor; yani yine alan.

3. **Comparator ile çevreye göre sıralama**

```java
Collections.sort(elements, new GeometricShapePerimeterComparator());
```

Burada çevre farkına göre sıralama.

✅ Sınavda: “Comparable vs Comparator farkı nedir?” klasik soru.

---

## 5) Validator örneği yorum bloğu

### Blok 14 (Utility.Validator kullanımı)

Amaç:

* Muhtemelen `Utility.Validator` içinde:

    * `isValidEmail(...)`
    * `isValidPhoneNumber(...)`
      gibi **static method** ve **instance method** kullanımını göstermek.
* Hem `Utility.Validator.isValidEmail(...)` (static çağrı)
* Hem de `new Utility.Validator()` ile nesne oluşturup çağırma örneği var.

Bu dosyalar yüklenmediği için burada sadece niyeti anlayabiliyoruz.

---

## 6) Metotların içindeki // yorumlar (filterShapes & applyToShapes)

### `// this method may appear anywhere in your code`

Türkçesi:
“Bu metot sınıf içinde istediğin yerde durabilir (Java’da metotların yeri mantıksal olarak fark etmez).”

### `// A method that applies a transformation to each GeometricShape`

Türkçesi:
“Her şekle bir dönüşüm/işlem uygulayan metot.”

### `// Apply the transformation and capture the result`

Türkçesi:
“Dönüşümü uygula ve sonucu al (result değişkenine koy).”

### `// Store the result`

Türkçesi:
“Bu sonucu listeye ekle.”

### `// Return the list of results`

Türkçesi:
“Sonuç listesini döndür.”

---

## 7) Sınavda bu projeden ne sorarlar? (Hızlı hazırlık)

### En muhtemel soru başlıkları

* **Abstract class (Soyut sınıf)** nedir, neden `calculateArea()` abstract?
* **Override (Ezme)**: `Circle/Rectangle/Triangle` nasıl override ediyor?
* **Polymorphism (Çok biçimlilik)**: `List<GeometricShape>` içinde farklı nesneler nasıl çalışıyor?
* **Comparable vs Comparator**

    * Comparable: sınıfın “doğal sırası”
    * Comparator: dışarıdan farklı sıralama stratejileri
* **Predicate/Function (Fonksiyonel arayüzler)**

    * Predicate: `boolean test(T t)` → filtreleme
    * Function: `R apply(T t)` → dönüştürme
* **Anonymous class vs Lambda**

    * İkisi de “interface implement etme” yolları, lambda daha kısa.
* **Generics**

    * `applyToShapes(List<T extends GeometricShape>, Function<T,R>)` ne demek?
    * Neden `T extends GeometricShape` yazıldı?

### Bu projede göze çarpan hatalar/puanlık detaylar

Bunlar da sınavda “hata bul” diye gelebilir:

* `Triangle.toString()` satırında **Java string birleştirme bozulmuş** görünüyor:

  ```java
  " side2 = "... getSide2()
  ```

  Bu haliyle derlenmez. Doğrusu şu tarz olmalı:

  ```java
  return "Triangle side1 = " + getSide1() + " side2 = " + getSide2() + " side3 = " + getSide3() + " " + super.toString();
  ```

* `GeometricShapePerimeterComparator`:

  ```java
  return (int)(o1.calculatePerimeter() - o2.calculatePerimeter());
  ```

  `double` farkını `int`’e çevirmek hassasiyeti bozar. Daha doğru yaklaşım:
  `Double.compare(o1.calculatePerimeter(), o2.calculatePerimeter())`

* `Rectangle.setWidth` içinde hata mesajı “Height must be positive.” yazıyor; width kontrolünde “Width must be positive.” olmalı.

---

## 8) Mini ezber / kısa özet (Sınavda cümle kurmalık)

* **Abstraction/Soyutlama:** “Üst sınıf ortak davranışı tanımlar, alt sınıflar detayı doldurur.”
* **Inheritance/Kalıtım:** “Alt sınıf üst sınıfın özelliklerini alır; kod tekrarını azaltır.”
* **Polymorphism/Çok biçimlilik:** “Üst tip referans, alt tip nesne; aynı çağrı farklı davranış.”
* **Comparable vs Comparator:** “Comparable sınıfın içinden; Comparator dışarıdan strateji.”
* **Predicate:** “Filtreleme şartı (boolean döner).”
* **Function:** “Dönüştürme (bir şeyi başka bir şeye çevirir).”
* **Anonymous class:** “Tek seferlik interface implementasyonu.”
* **Lambda:** “Functional interface için kısa yazım.”

---

İstersen bir sonraki adımda seni **sınav formatında** çalıştırayım: Bu projeden 10-15 tane klasik soru sorup (cevabını bekleyip) yanlışlarını düzeltebilirim.
