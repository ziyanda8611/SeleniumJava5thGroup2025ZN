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

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
