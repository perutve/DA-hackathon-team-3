package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MyAccountPage extends MainPage{

    @FindBy(xpath = "//button[@id = 'user_info_acc']/span")
    protected WebElement userButton;

    @FindBy(xpath = "//ul[@aria-labelledby = 'user_info_acc']//li[3]/a")
    protected WebElement logOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public SignInPage signOut() {
        userButton.click();
        logOutButton.click();
        return new SignInPage(getDriver());
    }

    public Boolean isUserSigned(){
        return userButton.isDisplayed();
    }
}
