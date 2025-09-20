package tests.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.RegistrationPage;
import pages.SearchPage;
import utils.PropertyReader;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected SearchPage searchPage;
    protected ProjectsPage projectsPage;
    protected SoftAssert softAssert;
    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @BeforeMethod()
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        searchPage = new SearchPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    @AfterMethod()
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}