package proje.pages.trendyol;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class Odeme_Sayfasi {
    public Odeme_Sayfasi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//*[@class='ty-primary-btn ty-btn-large'])[1]")
    public WebElement kaydetVeDevamEt;

    @FindBy(xpath = "//*[@name='name']")
    public WebElement adresAd;


    @FindBy(xpath = "//*[@name='cityId']")
    public WebElement ilSeciniz;

    @FindBy(xpath = "(//*[@class='ty-select-option'])[53]")
    public WebElement ilKonya;


    @FindBy(xpath = "//*[@name='districtId']")
    public WebElement ilceSeciniz;

    @FindBy(xpath = "(//*[@class='ty-select-option'])[86]")
    public WebElement ilceBeysehir;

    @FindBy(xpath = "//*[@name='neighborhoodId']")
    public WebElement mahalleSeciniz;

    @FindBy(xpath = "(//*[@class='ty-select-option'])[176]")
    public WebElement yeniMahalle;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement kaydetButton;

    @FindBy(xpath = "//*[text()='İKİ ADIMLI DOĞRULAMA']")
    public WebElement ikiAdimliDogrulama;

    @FindBy(xpath = "(//*[@transform='translate(612.000000, 248.000000)'])[2]")
    public WebElement carpidanKapatma;

    @FindBy(xpath = "//*[@transform='translate(612.000000, 248.000000)']")
    public WebElement distakiCarpidanKapatma;












}
