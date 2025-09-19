package tests.ui;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Description("Регистрация по невалидному номеру телефона")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .clickButtonRegistration();
        registrationPage
                .setNumberPhone("9099099099")
                .setSMSCode("5555");
        Assert.assertEquals("Вы ввели неверный код [1110]", registrationPage.getTextWithError(), "Не сошлось");
    }
}