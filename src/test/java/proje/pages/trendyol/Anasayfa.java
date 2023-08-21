package proje.pages.trendyol;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class Anasayfa {
    public Anasayfa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@class='link-text'])[1]")
    public WebElement girisYap;

    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement ePosta;

    @FindBy(xpath = "//*[@class='q-primary q-fluid q-button-medium q-button submit']")
    public WebElement girisYapButton;
}
