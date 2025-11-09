package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LogoutPage {

    WebDriver driver;

    @FindBy(id = "logout-button")
    WebElement logout_id;


    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(logout_id));
        logout_id.click();
    }
}


