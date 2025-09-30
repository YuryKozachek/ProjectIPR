package tests.ui;


import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchTest extends BaseUITest {

    String text = "iPhone 17";

    @Description("Поиск по слову")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .setSearchText(text);
        assertTrue(searchPage.getFirstLinkWithText().contains(text), "Не сошлось");
    }
}