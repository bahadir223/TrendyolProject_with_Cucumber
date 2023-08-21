package proje.pages.trendyol;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class Urun_Sayfasi {
    public Urun_Sayfasi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@class='add-to-basket-button-text']")
    public WebElement sepeteEkleButton;

    @FindBy(xpath = "//*[@class='product-preview-status-text']")
    public WebElement urunSepeteEklendiYazisi;

    @FindBy(xpath = "//*[@class='complete-order-button']")
    public WebElement siparisiTamamlaButton;




}
