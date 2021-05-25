package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class SignInPage extends MainPage{

    protected String emailStringValue = "mar.buga@post.cz";
    protected String passwordStringValue = "15101987";

    @FindBy(id = "email")
    protected WebElement email;

    @FindBy(id = "passwd")
    protected WebElement password;

    @FindBy(id = "SubmitLogin")
    protected WebElement signInButton;

    @FindBy(xpath = "//p[@class='lost_password form-group']/a")
    protected WebElement forgottenPassword;

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    private void signIn() {
        fillInEmail(emailStringValue);
        fillInPassword(passwordStringValue);
        signInButton.click();
    }

    public void fillInEmail(String mail){
        email.sendKeys(mail);
    }

    public void fillInPassword(String passwordValue){
        password.sendKeys(passwordValue);
    }

    public MyAccountPage signInRegisteredUser(){
        signIn();
        return new MyAccountPage(getDriver());
    }

    public ResetPassword retrievePassword(){
        forgottenPassword.click();
        return new ResetPassword(getDriver());
    }

    public Boolean isUserSignedOut(){
        return signInButton.isDisplayed();
    }
}
