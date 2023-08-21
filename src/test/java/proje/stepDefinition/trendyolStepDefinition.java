package proje.stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import proje.pages.trendyol.Anasayfa;
import proje.pages.trendyol.GirisYapildiktanSonraki_Anasayfa;
import proje.pages.trendyol.Odeme_Sayfasi;
import proje.pages.trendyol.Urun_Sayfasi;
import proje.utilities.ConfigReader;
import proje.utilities.Driver;
import proje.utilities.ExcelReader;
import proje.utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class trendyolStepDefinition {
    Anasayfa anasayfa = new Anasayfa();
    GirisYapildiktanSonraki_Anasayfa sonrakiAnasayfa = new GirisYapildiktanSonraki_Anasayfa();
    Urun_Sayfasi urunSayfasi = new Urun_Sayfasi();
    Odeme_Sayfasi odeme = new Odeme_Sayfasi();
    Actions actions = new Actions(Driver.getDriver());

    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String str) {
        Driver.getDriver().get(ConfigReader.getProperty("trendyolUrl"));
        ReusableMethods.bekle(3);
    }

    @Then("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int saniye) {
        ReusableMethods.bekle(saniye);
    }

    @Then("kullanici girisYap bolumune tiklar")
    public void kullaniciGirisYapBolumuneTiklar() {
        ReusableMethods.click(anasayfa.girisYap);
    }

    @Then("kullanici bilgilerini girer {string},{string}")
    public void kullaniciBilgileriniGirer(String email, String password) {
        anasayfa.ePosta.sendKeys(email, Keys.TAB, password);
    }

    @Then("kullanici giris yap butonuna tiklar")
    public void kullaniciGirisYapButonunaTiklar() {
        anasayfa.girisYapButton.click();
    }

    @Then("kullanici giris yapildigini dogrular")
    public void kullaniciGirisYapildiginiDogrular() {
        assertTrue(sonrakiAnasayfa.hesabim.isDisplayed());
    }

    @Then("kullanici arama bolumunde {string} aratir")
    public void kullaniciAramaBolumundeAratir(String str) {
        sonrakiAnasayfa.aramaKutusu.sendKeys(ConfigReader.getProperty(str), Keys.ENTER);
    }

    @Then("kullanici listelenen ilk urune tiklar")
    public void kullaniciListelenenIlkUruneTiklar() {
        sonrakiAnasayfa.listelenenIlkUrun.click();
    }

    @Then("kullanici yeni acilan sekmedeki sepete ekle butonuna tiklar")
    public void kullaniciYeniAcilanSekmedekiSepeteEkleButonunaTiklar() {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        //istememiz disinda yeni sekme acildigi icin bu kodu yazdik.
        urunSayfasi.sepeteEkleButton.click();
        ReusableMethods.bekle(3);
    }

    @Then("Ürün Sepete Eklendi! yazisinin gorunurlugunu dogrular")
    public void ürünSepeteEklendiYazisininGorunurlugunuDogrular() {
        assertTrue(urunSayfasi.urunSepeteEklendiYazisi.isDisplayed());
    }

    @Then("siparisi tamamla butonuna tiklar")
    public void siparisiTamamlaButonunaTiklar() {
        urunSayfasi.siparisiTamamlaButton.click();
    }

    @Then("exceldeki {string} sayfasindaki ad,soyad,telefon,adres,adres basligi bilgilerini doldur")
    public void exceldekiSayfasindakiAdSoyadTelefonAdresAdresBasligiBilgileriniDoldur(String sayfaIsmi) {
        String dosyaYolu = "src/test/resources/trendyolCalismasi.xlsx";
        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        for (int i = 1; i < excelReader.rowCount(); i++) {
            String ad = excelReader.getCellData(i, 0);
            String soyad = excelReader.getCellData(i, 1);
            String telefon = excelReader.getCellData(i, 2);
            String adres = excelReader.getCellData(i, 3);
            String adresBasligi = excelReader.getCellData(i, 4);
            //actions.moveToElement(odeme.adresAd).perform();
            odeme.adresAd.sendKeys(ad);
            ReusableMethods.bekle(3);
            ReusableMethods.click(odeme.ilSeciniz);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.ilKonya);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.ilceSeciniz);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.ilceBeysehir);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.mahalleSeciniz);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.yeniMahalle);
            ReusableMethods.bekle(2);
            ReusableMethods.click(odeme.kaydetButton);
            ReusableMethods.bekle(2);
            assertTrue(odeme.ikiAdimliDogrulama.isDisplayed());
        }
        //odeme.adresAd.sendKeys("bahadirrrr");
        //Driver.getDriver().switchTo().defaultContent();
        ReusableMethods.click(odeme.carpidanKapatma);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.distakiCarpidanKapatma);
    }

    @Then("kaydet ve devam et butonuna tiklar")
    public void kaydetVeDevamEtButonunaTiklar() {
        ReusableMethods.click(odeme.kaydetVeDevamEt);
    }

    @Then("kullanici gerekli alanlari doldurur")
    public void kullaniciGerekliAlanlariDoldurur(DataTable data) {
        odeme.adresAd.sendKeys(data.row(1).get(0), Keys.TAB,
                data.row(1).get(1), Keys.TAB,
                data.row(1).get(2), Keys.TAB, Keys.TAB,
                data.row(1).get(3), Keys.TAB,
                data.row(1).get(4));
        ReusableMethods.bekle(3);
        ReusableMethods.click(odeme.kaydetButton);
        //Driver.getDriver().navigate().back();
        //page.email.sendKeys(data.row(2).get(0), Keys.TAB, data.row(2).get(1), Keys.ENTER);
        //ReusableMethods.bekle(3);
    }

    @Then("kullanici ilgili alanlari doldurur")
    public void kullaniciIlgiliAlanlariDoldurur() {
        odeme.adresAd.sendKeys(ConfigReader.getProperty("ad"),
                Keys.TAB, ConfigReader.getProperty("soyad"),
                Keys.TAB, ConfigReader.getProperty("telefon"), Keys.TAB,
                Keys.TAB, ConfigReader.getProperty("adres"),
                Keys.TAB, ConfigReader.getProperty("adresBasligi"));
        ReusableMethods.click(odeme.ilSeciniz);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.ilKonya);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.ilceSeciniz);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.ilceBeysehir);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.mahalleSeciniz);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.yeniMahalle);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.kaydetButton);
        ReusableMethods.bekle(2);
        assertTrue(odeme.ikiAdimliDogrulama.isDisplayed());
        Driver.getDriver().navigate().refresh();
    }

    @Then("trendyol logosuna tikla ve anasayfaya gec")
    public void trendyolLogosunaTiklaVeAnasayfayaGec() {
        ReusableMethods.click(sonrakiAnasayfa.trendyolLogo);
        ReusableMethods.bekle(2);
        ReusableMethods.click(sonrakiAnasayfa.siparislerimdekiLogo);
    }

    @Then("sayfadan x ile cikis yap")
    public void sayfadanXIleCikisYap() {
        ReusableMethods.click(odeme.distakiCarpidanKapatma);
        ReusableMethods.bekle(2);
        ReusableMethods.click(odeme.carpidanKapatma);
    }

    @Then("hesabimin uzerine mouse ile gel ve cikis yapa tikla")
    public void hesabiminUzerineMouseIleGelVeCikisYapaTikla() {
        actions.moveToElement(sonrakiAnasayfa.hesabim).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.click(sonrakiAnasayfa.cikisYap);
        Driver.closeDriver();
    }
}

