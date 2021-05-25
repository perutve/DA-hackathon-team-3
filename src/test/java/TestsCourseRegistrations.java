import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import pageobject.*;

public class TestsCourseRegistrations {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test // Test 1 - Sign In
    public void registeredUserShouldBeAbleToSignIn() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInPage();
        MyAccountPage usersAccount = signInPage.signInRegisteredUser();

        Assertions.assertTrue(usersAccount.isUserSigned());
    }

    @Test // Test 2 - Sign out
    public void registeredUserShouldBeAbleToSignInAndThenSignOut() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInPage();
        MyAccountPage usersAccount = signInPage.signInRegisteredUser();

        Assertions.assertTrue(usersAccount.isUserSigned());

        signInPage = usersAccount.signOut();

        Assertions.assertTrue(signInPage.isUserSignedOut());
    }

    @Test // Test 3 - Password reset
    public void registeredUserShouldBeAbleToResetPassword() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInPage();
        ResetPassword resetPassword = signInPage.retrievePassword();
        resetPassword.sendForgottenPasswordToEmail();

        Assertions.assertTrue(resetPassword.isEmailSend());
    }

    @Test // Test 4 - Empty mail field
    public void userShouldNotBeAbleToRetrievePasswordWithEmptyEMailField() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInPage();
        ResetPassword resetPassword = signInPage.retrievePassword();
        resetPassword.fillInEmptyEmail();

        Assertions.assertTrue(resetPassword.isEmailRequired());
    }

    @Test // Test 5 - Invalid Password
    public void userShouldNotBeAbleToRetrievePasswordWithInvalidEMailField() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        SignInPage signInPage = mainpage.goToSignInPage();
        ResetPassword resetPassword = signInPage.retrievePassword();
        resetPassword.fillInInvalidEmail();

        Assertions.assertTrue(resetPassword.isEmailInvalid());
    }

    @Test // Test 6 - Budget Cabin Room reservation
    public void userShouldBeAbleToReserveBudgetCabinRoomFromMainPage() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        ReservationPage roomReservation = mainpage.goToReserveBudgetCabin();
        roomReservation.bookRoom();

        Assertions.assertTrue(roomReservation.addedToCart());
    }

    @Test // Test 7 - Deluxe Apartments Room reservation
    public void userShouldBeAbleToReserveDeluxeApartmentsRoomFromMainPage() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        ReservationPage roomReservation = mainpage.goToReserveDeluxeApartments();
        roomReservation.bookRoom();

        Assertions.assertTrue(roomReservation.addedToCart());
    }

    @Test // Test 8 - Full Nature Experience Room reservation
    public void userShouldBeAbleToReserveFullNatureExperienceRoomFromMainPage() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        ReservationPage roomReservation = mainpage.goToReserveFullNatureExperience();
        roomReservation.bookRoom();

        Assertions.assertTrue(roomReservation.addedToCart());
    }

    @Test // Test 9 - Luxury In Woods Room reservation
    public void userShouldBeAbleToReserveLuxuryInWoodsRoomFromMainPage() {
        MainPage mainpage = new MainPage(browser);
        mainpage.goToMainPage();

        ReservationPage roomReservation = mainpage.goToReserveLuxuryInTheWoods();
        roomReservation.bookRoom();

        Assertions.assertTrue(roomReservation.addedToCart());
    }

    @AfterEach
    public void tearDown() {
        browser.close();
    }

}
