package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsPage extends BasePage {

    private final By BUTTON_EN = By.xpath("//button[@aria-label='English']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage open() {
        driver.get("https://vk.company/ru/projects/");
        return this;
    }

    public ProjectsPage clickButtonEn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_EN));
        driver.findElement(BUTTON_EN).click();
        return this;
    }

    public String getCurrentUrlProjectsPage() {
        return driver.getCurrentUrl();
    }
}