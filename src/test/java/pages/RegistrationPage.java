package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    protected final By INPUT_PHONE = By.xpath("//input[@name='phone']");
    protected final By BUTTON_CONTINUE = By.xpath("//button[@type='submit']");
    protected final By INPUT_SMS_CODE = By.xpath("//input[@name='otp']");
    protected final By TEXT_ERROR_SMS_CODE = By.xpath("//div[text()='Вы ввели неверный код [1110]']");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setNumberPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_PHONE));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_PHONE)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CONTINUE));
        driver.findElement(BUTTON_CONTINUE).click();
        return this;
    }

    public RegistrationPage setSMSCode(String code) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_SMS_CODE));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_SMS_CODE)).sendKeys(code);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_CONTINUE));
        driver.findElement(BUTTON_CONTINUE).click();
        return this;
    }

    public String getTextWithError() {
        wait.until(ExpectedConditions.textToBe(TEXT_ERROR_SMS_CODE, "Вы ввели неверный код [1110]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ERROR_SMS_CODE));
        String text = driver.findElement(TEXT_ERROR_SMS_CODE).getText().trim();
        driver.switchTo().defaultContent();
        return text;
    }
}