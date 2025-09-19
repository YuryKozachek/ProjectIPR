package tests.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Description("Вход на почту с невалидным названием ящика")
    @Test
    public void checkLogin() {

        loginPage.open()
                .setLogin("Hello!!Hello11");
        Assert.assertEquals("Вы ввели несуществующее имя аккаунта [100]", loginPage.getTextWithError(), "Не сошлось");
    }

    @Description("Установка темной темы")
    @Test
    public void checkDarkBackground() {

        loginPage.open()
                .setDarkBackground();
        Assert.assertEquals("rgba(25, 25, 26, 1)", loginPage.checkBackground(), "Не сошлось");
    }
}