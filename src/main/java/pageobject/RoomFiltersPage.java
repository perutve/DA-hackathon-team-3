package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class RoomFiltersPage extends MainPage{

    @FindBy(xpath = "//div[@id = 'category_data_cont']")
    protected WebElement filteredRooms;

    public RoomFiltersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public Boolean isFilterDisplayed(){
        return filteredRooms.isDisplayed();
    }
}
