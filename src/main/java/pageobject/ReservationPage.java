package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class ReservationPage extends MainPage{

    @FindBy(xpath = "//p[@id='add_to_cart']/button")
    protected WebElement bookNowButton;

    @FindBy(xpath = "//div[@id='layer_cart']//h2")
    protected WebElement successfullyAddedRoom;

    public ReservationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void bookRoom() {
        inputCheckInTime.click();
        choosePossibleDate.click();
        inputCheckOutTime.click();
        chooseFirstPossibleDate.click();
        bookNowButton.click();
    }

    public Boolean addedToCart(){
        return successfullyAddedRoom.getText().contains("successfully");
    }

}
