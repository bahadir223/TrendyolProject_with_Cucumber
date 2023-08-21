package proje.pages.trendyol;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class GirisYapildiktanSonraki_Anasayfa {
    public GirisYapildiktanSonraki_Anasayfa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='link-text'])[1]")
    public WebElement hesabim;

    @FindBy(xpath = "//*[@class='V8wbcUhU']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//*[@class='prdct-desc-cntnr-ttl-w two-line-text'])[1]")
    public WebElement listelenenIlkUrun;

    @FindBy(xpath = "//*[@src='https://cdn.dsmcdn.com/web/master/ty-web.svg']")
    public WebElement trendyolLogo;

    @FindBy(xpath = "//*[@src='https://cdn.dsmcdn.com/web/logo/ty-web.svg']")
    public WebElement siparislerimdekiLogo;

    @FindBy(xpath = "//*[text()='Çıkış Yap']")
    public WebElement cikisYap;


}
