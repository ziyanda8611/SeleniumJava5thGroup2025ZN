package Tests;//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;


import org.testng.annotations.*;

public class LoginToLearningMaterial {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void startBrowser() throws InterruptedException {
        driver.get("https://www.ndosiautomation.co.za/");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void verifyHomePageIsDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"overview-hero\"]/h2")).isDisplayed();
    }

    @Test(priority = 2)
    public void clickLearningMaterials() throws InterruptedException {
        driver.findElement(By.id("nav-btn-practice")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void enterEmail(){
          driver.findElement(By.id("login-email")).sendKeys("ziyandan@gmail.com");
    }

    @Test(priority = 4)
    public void enterPassword(){
        driver.findElement(By.id("login-password")).sendKeys("12345678");
    }

    @Test(priority = 5)
    public void clickLoginButton() throws InterruptedException {
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void verifyWelcomePageIsDisplayed() {
        driver.findElement(By.xpath("//*[@id=\"practice-header\"]")).isDisplayed();
    }

    @Test(priority = 7)
    public void clickWebAutomationBasicForm() throws InterruptedException {
        driver.findElement(By.id("tab-btn-password")).click();
        Thread.sleep(2000);
        }

    @Test(priority = 8)
    public void enterFullName() {
        driver.findElement(By.id("name")).sendKeys("Ziyanda Ngcelwane");
    }

    @Test(priority = 9)
    public void enterEmailAddress(){
        driver.findElement(By.id("email")).sendKeys("ziyandan@gmail.com");
    }

    @Test(priority = 10)
    public void enterAge(){
        driver.findElement(By.id("age")).sendKeys("20");
    }

    @Test(priority = 11)
    public void SelectGender(){
        Select gender = new Select(driver.findElement(By.id("gender")));
        gender.selectByVisibleText("Female");
    }

    @Test(priority = 12)
    public void SelectCountry(){
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("Canada");
    }

    @Test(priority = 13)
    public void SelectExperienceLevel(){
        Select experience = new Select(driver.findElement(By.id("experience")));
        experience.selectByVisibleText("Beginner (0-1 years)");
    }

    @Test(priority = 14)
    public void clickSkillsCheckBox(){
        driver.findElement(By.id("skill-testing")).click();
    }

    @Test(priority = 15)
    public void enterComment(){
        driver.findElement(By.id("comments")).sendKeys("Hellow Junior Tester");
    }

    @Test(priority = 16)
    public void clickAcceptTermsCheckBox() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("terms")).click();
    }

    @Test(priority = 17)
    public void clickSubmitFormButton() throws InterruptedException {
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(3000);
    }

   //@AfterTest
   //public void closeBrowser() {
    //    if (driver != null) {
      //      driver.quit();
        //    }
       // }

    }




