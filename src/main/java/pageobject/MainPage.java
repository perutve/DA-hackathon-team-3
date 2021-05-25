package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class MainPage extends BasePage{

    private static final String MAIN_URL = "http://czechitas-datestovani-hackathon.cz";

    @FindBy(xpath = "//input[@id = 'check_in_time']")
    protected WebElement inputCheckInTime;

    @FindBy(xpath = "//input[@id = 'check_out_time']")
    protected WebElement inputCheckOutTime;

    @FindBy(xpath = "//button[@id = 'search_room_submit']/span")
    protected WebElement searchNowButton;

    @FindBy(xpath = "//span[@id = 'hotel_cat_name']")
    protected WebElement selectHotelButton;

    @FindBy(xpath = "//li[@data-id-hotel = '1']")
    protected WebElement selectHotelTFL;

    @FindBy(xpath = "(//a[@href = '#'])[1]")
    protected WebElement chooseFirstPossibleDate;

    @FindBy(xpath = "(//td[@data-event = 'click']/a)[10]")
    protected WebElement choosePossibleDate;

    @FindBy(xpath = "//a[@class = 'user_login navigation-link']/span")
    protected WebElement signInButton;

    @FindBy(xpath = "(//div[@id='hotelRoomsBlock']//a)[1]")
    protected WebElement bookNowBudgetCabin;

    @FindBy(xpath = "(//div[@id='hotelRoomsBlock']//a)[2]")
    protected WebElement bookNowDeluxeApartments;

    @FindBy(xpath = "(//div[@id='hotelRoomsBlock']//a)[3]")
    protected WebElement bookNowFullNatureExperience;

    @FindBy(xpath = "(//div[@id='hotelRoomsBlock']//a)[4]")
    protected WebElement bookNowLuxuryInTheWoods;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void goToMainPage() {
        getDriver().get(MAIN_URL);
    }

    public RoomFiltersPage goToFilters() {
        chooseCheckInDate();
        chooseCheckOutDate();
        selectHotel();
        searchNowButton.click();
        return new RoomFiltersPage(getDriver());
    }

    public SignInPage goToSignInPage() {
        signInButton.click();
        return new SignInPage(getDriver());
    }

    public void chooseCheckInDate(){
        inputCheckInTime.click();
        choosePossibleDate.click();
    }

    public void chooseCheckOutDate(){
        inputCheckOutTime.click();
        choosePossibleDate.click();
    }

    public void selectHotel(){
        selectHotelButton.click();
        selectHotelTFL.click();
    }

    public ReservationPage goToReserveBudgetCabin() {
        bookNowBudgetCabin.click();
        return new ReservationPage(getDriver());
    }

    public ReservationPage goToReserveDeluxeApartments() {
        bookNowDeluxeApartments.click();
        return new ReservationPage(getDriver());
    }

    public ReservationPage goToReserveFullNatureExperience() {
        bookNowFullNatureExperience.click();
        return new ReservationPage(getDriver());
    }

    public ReservationPage goToReserveLuxuryInTheWoods() {
        bookNowLuxuryInTheWoods.click();
        return new ReservationPage(getDriver());
    }
}
