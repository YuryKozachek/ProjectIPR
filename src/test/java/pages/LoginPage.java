package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    static By iframeLocator = By.xpath("//iframe[@class='ag-popup__frame__layout__iframe']");
    static By iframeLocatorSearch = By.xpath("//iframe[@class='search-arrow__frame kadekle__cs3gds']");
    protected final By BUTTON_LOGIN = By.xpath("//button[text()='Войти']");
    protected final By INPUT_NAME_BOX = By.xpath("//input[@id='email']");
    protected final By BUTTON_LOGIN_MENU = By.xpath("//button[@data-test-id='continue-button']");
    protected final By TEXT_ERROR_LOGIN = By.xpath("//span[text()='Вы ввели несуществующее имя аккаунта [100]']");
    protected final By BUTTON_REGISTRATION = By.xpath("//*[text()='Регистрация']");
    protected final By INPUT_SEARCH = By.xpath("//input[@name='text']");
    protected final By FIRST_LINK_SEARCH = By.xpath("//*[@data-index='0']");
    protected final By BUTTON_SETTINGS = By.xpath("//div[@class='ph-settings-container ph-project-margin svelte-ttryjx']");
    protected final By BUTTON_DARK_BACKGROUND = By.xpath("//div[text()='Тёмная тема']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(BASE_URI);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN));
        return this;
    }

    public LoginPage setLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_LOGIN));
        driver.findElement(BUTTON_LOGIN).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_NAME_BOX));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_NAME_BOX)).sendKeys(login);
        driver.findElement(BUTTON_LOGIN_MENU).click();
        driver.switchTo().defaultContent();
        return this;
    }

    public String getTextWithError() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
        wait.until(ExpectedConditions.textToBe(TEXT_ERROR_LOGIN, "Вы ввели несуществующее имя аккаунта [100]"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_ERROR_LOGIN));
        String text = driver.findElement(TEXT_ERROR_LOGIN).getText().trim();
        driver.switchTo().defaultContent();
        return text;
    }

    public RegistrationPage clickButtonRegistration() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_REGISTRATION));
        driver.findElement(BUTTON_REGISTRATION).click();
        return new RegistrationPage(driver);
    }

    public SearchPage setSearchText(String text) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocatorSearch));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_SEARCH));
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_SEARCH)).sendKeys(text);
        wait.until(ExpectedConditions.elementToBeClickable(FIRST_LINK_SEARCH));
        driver.findElement(FIRST_LINK_SEARCH).click();
        driver.switchTo().defaultContent();
        return new SearchPage(driver);
    }

    public LoginPage setDarkBackground() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SETTINGS));
        driver.findElement(BUTTON_SETTINGS).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_DARK_BACKGROUND));
        driver.findElement(BUTTON_DARK_BACKGROUND).click();
        return this;
    }

    public String checkBackground() {
        WebElement BACKGROUND_COLOR = driver.findElement(By.xpath("//body[@class='utilityfocus']"));
        return BACKGROUND_COLOR.getCssValue("background-color");
    }
}