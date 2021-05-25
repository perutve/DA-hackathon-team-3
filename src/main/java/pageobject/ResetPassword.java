package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ResetPassword extends SignInPage {

    private String emailStringValueForResetPassword = "user001@seznam.cz";   //basovapeta@gmail.com
    private String invalidEmail = "invalid@email.com";

    @FindBy(xpath = "//form[@id='form_forgotpassword']//span")
    protected WebElement retrievePasswordButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    protected WebElement resetPasswordConfirmation;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    protected WebElement alertEmailInvalid;

    public ResetPassword(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void sendForgottenPasswordToEmail(){
        fillInEmail(emailStringValueForResetPassword);
        retrievePasswordButton.click();
    }

    public ResetPassword fillInInvalidEmail(){
        fillInEmail(invalidEmail);
        retrievePasswordButton.click();
        return new ResetPassword(getDriver());
    }

    public ResetPassword fillInEmptyEmail(){
        retrievePasswordButton.click();
        return new ResetPassword(getDriver());
    }

    public Boolean isEmailSend(){
        return resetPasswordConfirmation.getText().contains("confirmation email has been sent");  //////////////////
    }

    public Boolean isEmailInvalid(){
        return alertEmailInvalid.getText().contains("no account");
    }

    public Boolean isEmailRequired(){
        return alertEmailInvalid.getText().contains("Invalid");
    }
}
