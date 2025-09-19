package tests.ui;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    String text = "iPhone 17";

    @Description("Поиск по слову")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .setSearchText(text);
        Assert.assertTrue(searchPage.getFirstLinkWithText().contains(text), "Не сошлось");
    }
}