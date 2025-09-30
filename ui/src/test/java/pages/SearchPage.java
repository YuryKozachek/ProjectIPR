package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    static By iframeLocatorSearchPage = By.xpath("//iframe[@class='yandex-frame']");
    protected final By FIRST_LINK_WITH_TEXT = By.xpath("//*[@accesskey='1']");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstLinkWithText() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocatorSearchPage));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_LINK_WITH_TEXT));
        return driver.findElement(FIRST_LINK_WITH_TEXT).getAttribute("textContent").trim();
    }
}