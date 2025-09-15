package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import pages.ProjectsPage;
import pages.RegistrationPage;
import pages.SearchPage;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    static WebDriver driver;
    static LoginPage loginPage;
    static RegistrationPage registrationPage;
    static SearchPage searchPage;
    static ProjectsPage projectsPage;

    @BeforeAll()
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
//            options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
//        iTestContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        searchPage = new SearchPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    @AfterAll()
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}