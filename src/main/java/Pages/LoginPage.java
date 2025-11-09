package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "login-email")
    WebElement loginEmail_id;
    @FindBy(id = "login-password")
    WebElement loginPassword_id;
    @FindBy(id = "login-submit")
    WebElement loginSubmit_id;
    @FindBy(id = "login-heading")
    WebElement verifyLoginPage_id;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterLoginEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginEmail_id));
        loginEmail_id.sendKeys(email);
    }

    public void enterPasswordId(String password) {
        loginPassword_id.sendKeys(password);
    }

    public void clickLogin() {
        loginSubmit_id.click();
    }

    public void verifyLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(verifyLoginPage_id));
        verifyLoginPage_id.isDisplayed();}

    public void verifyInvalidLoginCredentialsMessage(String popMessage) {
        // Switch to alert
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = popMessage;
        Assert.assertEquals(actualMessage, expectedMessage, popMessage);
        System.out.println("Alert Message :" + actualMessage);
        // Close the alert
        alert.accept();

    }

    public void clearEmailInput(){
        loginEmail_id.clear();
    }
}


