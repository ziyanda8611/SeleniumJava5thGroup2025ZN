package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebAutomationAdvancePage {

    WebDriver driver;

    @FindBy(id = "inventory-title")
    WebElement inventoryHeader_id;

    @FindBy(id = "tab-btn-web")
    WebElement web_automation_tab;

    @FindBy(id = "storage-64GB")
    WebElement storage_radio_btn;

    @FindBy(id = "shipping-standard")
    WebElement shipping_method_radio_btn;

    @FindBy(id = "warranty-1yr")
    WebElement one_year_warranty_radio_btn;

    @FindBy(id = "discount-code")
    WebElement discount_code_input;

    @FindBy(id = "apply-discount-btn")
    WebElement apply_btn;

    @FindBy(id = "inventory-next-btn")
    WebElement next_btn;

    @FindBy(id = "discount-feedback")
    WebElement discount_messgae;



    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "address")
    WebElement email_id;

    public WebAutomationAdvancePage(WebDriver driver){
        this.driver=driver;
    }

    public void selectDropDown(WebDriver driver,By locator,String dropDownValue){

        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(dropDownValue);

    }

    public void verifyInventoryHeaderIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(inventoryHeader_id));
        inventoryHeader_id.isDisplayed();
    }

    public void clickWebAutomationAdvanceTab() {
        web_automation_tab.click();

    }

    public void selectDeviceType(String deviceType){

        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        dropdown.selectByVisibleText(deviceType);


    }

    public void selectTabletBrand(String deviceBrand){

        Select dropdown = new Select(driver.findElement(By.id("brand")));
        dropdown.selectByVisibleText(deviceBrand);
    }

    public void selectColor(String color){

        Select dropdown = new Select(driver.findElement(By.id("color")));
        dropdown.selectByVisibleText(color);
    }

    public void addQuantity(String quantity) {

        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public void addressInput(String address) {

        email_id.sendKeys(address);
    }

    public void clickStoragebtn() {

        storage_radio_btn.click();
    }

    public void clickNextBtn() {
        next_btn.click();
    }

    public void clickRemoveBtn() {

        WebElement element = driver.findElement(By.xpath("//button[normalize-space()='Remove']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickAddToCart() {

        WebElement element = driver.findElement(By.id("add-to-cart-btn"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void clickShippingMethod(){
        shipping_method_radio_btn.click();
    }

    public void clickWarrantyDuration(){
        one_year_warranty_radio_btn.click();
    }

    public void enterDiscountCode(String discountCode){
        discount_code_input.sendKeys(discountCode);
    }

    public void clearDiscountCode(){
        discount_code_input.clear();
    }

    public void clickApplyBtn(){
        apply_btn.click();
    }

    public void isDiscountMessageDisplayed(){
        discount_messgae.isDisplayed();
    }

}
