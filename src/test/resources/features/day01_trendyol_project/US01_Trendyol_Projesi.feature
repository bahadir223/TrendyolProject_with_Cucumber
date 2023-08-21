  #NAME: tum kullanici bilgileri ile giris yapılıp ürün işlemleri yapılabilmeli
  #AC
    #Given kullanici "trendyol" sayfasina gider
    #Then kullanici girisYap bolumune tiklar
    #Then kullanici bilgilerini girer "<email>","<password>"
    #Then kullanici giris yap butonuna basar
    #Then login islemi gerceklesir
    #Then kullanici giris yapildigini dogrular
    #Then kullanici arama bolumune "urun1" aratir
    #Then kullanici listelenen ilk urune tiklar
    #Then sepete ekle butonuna tiklar
    #Then Ürün Sepete Eklendi! yazisinin gorunurlugunu dogrular
    #Then siparisi tamamla butonuna tiklar
    #Then exceldeki "Sayfa1" sayfasindaki ad,soyad,telefon,adres,adres basligi bilgilerini doldur
    #Then adres ekle bolumundeki il,ilçe,mahalle bilgilerini doldurur
    #Then İKİ ADIMLI DOĞRULAMA yazisinin görünürlüğünü doğrular
    #Then sayfadan x ile cikis yap
    #Then sayfadan x ile cikis yap
    #Then trendyol logosuna tikla ve anasayfaya gec
    #Then hesabıma tikla
    #Then cikis yap bas
    #And Test sonlandi.

          #| email                      | password  |
          #| deneme00111111@outlook.com | Deneme.123 |
          #| deneme00222222@hotmail.com | Deneme.1234  |


  Feature: US001 Trendyol Sayfasi Testi

    Scenario Outline:kullanici tum login bilgileri ile giris yapip urun islemleri yapabilmeli
      Given kullanici "trendyolUrl" sayfasina gider
      Then kullanici 2 saniye bekler
      Then kullanici girisYap bolumune tiklar
      Then kullanici 2 saniye bekler
      Then kullanici bilgilerini girer "<email>","<password>"
      Then kullanici 2 saniye bekler
      Then kullanici giris yap butonuna tiklar
      Then kullanici 4 saniye bekler
      Then kullanici giris yapildigini dogrular
      Then kullanici arama bolumunde "urun1" aratir
      Then kullanici 2 saniye bekler
      Then kullanici listelenen ilk urune tiklar
      Then kullanici yeni acilan sekmedeki sepete ekle butonuna tiklar
      Then kullanici 2 saniye bekler
      Then Ürün Sepete Eklendi! yazisinin gorunurlugunu dogrular
      Then kullanici 2 saniye bekler
      Then siparisi tamamla butonuna tiklar
      Then kullanici 2 saniye bekler
      Then kaydet ve devam et butonuna tiklar
      Then kullanici 3 saniye bekler
      #Then exceldeki "Sayfa1" sayfasindaki ad,soyad,telefon,adres,adres basligi bilgilerini doldur
      #Then kullanici gerekli alanlari doldurur
       #| Isim    |  | Soyisim   |  | Telefon    |  | Adres                        |  | Adres Basligi |
       #| Bahadir |  | Gunuvar   |  | 5428348400 |  | yenimahalle beysehir / konya |  | Ev Adresi     |
       #| sarp    |  | nicholson |  | 5511235422 |  | umut sokak ankara            |  | Is adresi     |
      Then kullanici ilgili alanlari doldurur
      Then kullanici 2 saniye bekler
      Then kullanici 2 saniye bekler
      Then trendyol logosuna tikla ve anasayfaya gec
      Then hesabimin uzerine mouse ile gel ve cikis yapa tikla

      Examples:
        | email                      | password    |
        | deneme00111111@outlook.com | Deneme.123  |
        | deneme00222222@hotmail.com | Deneme.1234 |
