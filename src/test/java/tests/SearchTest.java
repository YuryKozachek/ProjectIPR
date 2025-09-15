package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseTest {

    String text = "iPhone 17";

    @DisplayName("Поиск по слову")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .setSearchText(text);
        Assertions.assertTrue(searchPage.getFirstLinkWithText().contains(text));
    }
}