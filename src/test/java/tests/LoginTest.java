package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @DisplayName("Вход на почту с невалидным названием ящика")
    @Test
    public void checkLogin() {

        loginPage.open()
                .setLogin("Hello!!Hello11");
        Assertions.assertEquals("Вы ввели несуществующее имя аккаунта [100]", loginPage.getTextWithError());
    }

    @DisplayName("Установка темной темы")
    @Test
    public void checkDarkBackground() {

        loginPage.open()
                .setDarkBackground();
        Assertions.assertEquals("rgba(25, 25, 26, 1)", loginPage.checkBackground());
    }
}