package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signup_id;

    @FindBy(id = "register-firstName")
    WebElement first_name;

    @FindBy(id = "register-lastName")
    WebElement last_name;

    @FindBy(id = "register-email")
    WebElement email_input;

    @FindBy(id = "register-password")
    WebElement password_input;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPassword_input;

    @FindBy(id = "register-submit")
    WebElement submit_btn;


    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignUpBtn(){
        signup_id.click();
    }

    public void enterFirstName(String firstname){
        first_name.sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        last_name.sendKeys(lastname);
    }

    public void enterEmail(String email){
        email_input.sendKeys(email);
    }

    public void enterPassword(String password){
        password_input.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmemail){
        confirmPassword_input.sendKeys(confirmemail);
    }

    public void submitButton(){
        submit_btn.click();
    }

    public void clearPasswordInputs(){
        password_input.clear();
        confirmPassword_input.clear();
    }

    public void clearInputFields(){

        first_name.clear();
        last_name.clear();
        email_input.clear();
        password_input.clear();
        confirmPassword_input.clear();

    }

    public void verifyPopUpMessage(String popMessage) {
        // Switch to alert
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        String expectedMessage = popMessage;
        Assert.assertEquals(actualMessage, expectedMessage, popMessage);
        System.out.println("Alert Message :" + actualMessage);
        // Close the alert
        alert.accept();

    }




}
