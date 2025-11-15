package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class ZiyandaTests extends Base{



    public void verifyHomePageIsDisplayedTests(){
        homePage.verifyHomePageIsDisplayed();
    }
    @Test(dependsOnMethods = "verifyHomePageIsDisplayedTests")
    public void clickLearningMaterialTests() {
        homePage.clickLearningMaterial();
        takeScreenshots.takesSnapShot(driver, "LearningMaterialPage");
    }

    @Test(dependsOnMethods = "clickLearningMaterialTests")
    public void enterValidLoginEmail(){
        loginPage.enterLoginEmail("ziyandan@gmail.com");
    }

    @Test(dependsOnMethods = "enterValidLoginEmail")
    public void enterValidPasswordTests() {

        loginPage.enterPasswordId("12345678");
    }

    @Test(dependsOnMethods = "enterValidPasswordTests")
    public void clickLoginTests() {
        loginPage.clickLogin();
    }

    @Test(dependsOnMethods = "clickLoginTests")
    public void verifyWelcomeHeading() {
        learningMaterialPage.verifyHeading();
    }

    @Test(dependsOnMethods = "verifyWelcomeHeading")
    public void clickWebAutomationAdvanceTab() throws InterruptedException {
        learningMaterialPage.clickWebAutomationAdvanceTab();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods="clickWebAutomationAdvanceTab")
    public void clickLogoutButton() throws InterruptedException{
        logoutPage.clickLogoutBtn();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods="clickLogoutButton")
    public void verifyLoginHomePage() {
        loginPage.verifyLoginPage();

    }

    @Test(dependsOnMethods = "verifyLoginHomePage")
    public void loginWithValidLoginEmail(){
        loginPage.enterLoginEmail("ziyandan@gmail.com");
    }

    @Test(dependsOnMethods = "loginWithValidLoginEmail")
    public void enterInvalidPasswordTests()  {
        loginPage.enterPasswordId("12245678");
    }

    @Test(dependsOnMethods = "enterInvalidPasswordTests")
    public void clickLoginBtn() throws InterruptedException {
        loginPage.clickLogin();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "clickLoginBtn")
    public void verifyInvalidCredentialsPopMessage() throws InterruptedException {
      loginPage.verifyInvalidLoginCredentialsMessage("Invalid email or password");
      Thread.sleep(4000);

    }

    @Test(dependsOnMethods = "verifyInvalidCredentialsPopMessage")
    public void clearEmailInputField() throws InterruptedException {
        loginPage.clearEmailInput();
        Thread.sleep(2000);
    }

    @Test(dependsOnMethods = "clearEmailInputField")
    public void enterLoginEmailWithSpacesTests(){
        loginPage.enterLoginEmail("      ziyandan@gmail.com");
    }

    @Test(dependsOnMethods = "enterLoginEmailWithSpacesTests")
    public void enterPasswordWithSpacesTests()  {
        loginPage.enterPasswordId("12345678      ");
    }

    @Test(dependsOnMethods = "enterPasswordWithSpacesTests")
    public void clickLogin(){
        loginPage.clickLogin();

    }

    @Test(dependsOnMethods = "clickLogin")
    public void logout() throws InterruptedException {
        logoutPage.clickLogoutBtn();
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "logout")
    public void clickOnSignUpLink() {
        signUpPage.clickSignUpBtn();
    }

    @Test(dependsOnMethods = "logout")
    public void verifyInvalidEmailFormat() throws InterruptedException {
        signUpPage.enterFirstName("Test01");
        signUpPage.enterLastName("Test02");
        signUpPage.enterEmail("tetststdl@@gmail.com");
        signUpPage.clearPasswordInputs();
        signUpPage.enterPassword("Password03");
        signUpPage.enterConfirmPassword("Password03");
        signUpPage.submitButton();
        //verify error message
        signUpPage.verifyPopUpMessage("Please enter a valid email address");
        Thread.sleep(3000);


    }

    @Test(dependsOnMethods = "verifyInvalidEmailFormat")
    public void verifyPasswordMismatch () throws InterruptedException {
        signUpPage.enterPassword("Password01");
        signUpPage.enterConfirmPassword("Password03");
        signUpPage.submitButton();
        //verify error message
        signUpPage.verifyPopUpMessage("Passwords do not match!");
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "verifyPasswordMismatch")
    public void verifyPasswordLength () throws InterruptedException {
        driver.navigate().refresh();
        signUpPage.clickSignUpBtn();
        signUpPage.enterFirstName("Peter");
        signUpPage.enterLastName("Peter01");
        signUpPage.enterEmail("Testing01@gmail.com");
        signUpPage.clearPasswordInputs();
        signUpPage.enterPassword("Pas03");
        signUpPage.enterConfirmPassword("Pas03");
        signUpPage.submitButton();
        //verify error message
        signUpPage.verifyPopUpMessage("Password must be at least 8 characters long");
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "verifyPasswordLength")
    public void verifySuccessfulRegistration () throws InterruptedException {
        driver.navigate().refresh();
        signUpPage.clickSignUpBtn();
        signUpPage.enterFirstName("John");
        signUpPage.enterLastName("Peter");
        signUpPage.enterEmail("Testing" + getRandomNumber(100,999) + "@gmail.com");
        signUpPage.clearPasswordInputs();
        signUpPage.enterPassword("Password05");
        signUpPage.enterConfirmPassword("Password05");
        signUpPage.submitButton();
        Thread.sleep(2000);
        //verify error message
        signUpPage.verifyPopUpMessage("Registration successful! You can now login with your credentials.");


    }

    @Test(dependsOnMethods = "verifySuccessfulRegistration")
    public void navigateToInventoryForm () throws InterruptedException {
        driver.navigate().refresh();
        loginPage.enterLoginEmail("ziyandan@gmail.com");
        loginPage.enterPasswordId("12345678");
        loginPage.clickLogin();
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "navigateToInventoryForm")
    public void validatePricing (){

        webAutomationAdvancePage.clickWebAutomationAdvanceTab();
        webAutomationAdvancePage.verifyInventoryHeaderIsDisplayed();
        webAutomationAdvancePage.selectDeviceType("Phone");
        webAutomationAdvancePage.selectTabletBrand("Apple");
        webAutomationAdvancePage.selectColor("Black");
        webAutomationAdvancePage.addQuantity("2");
        webAutomationAdvancePage.addressInput("21 Jackal Creek");
        webAutomationAdvancePage.clickNextBtn();

    }



    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }




}
