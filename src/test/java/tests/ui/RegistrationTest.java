package tests.ui;


import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationTest extends BaseUITest {

    @Description("Регистрация по невалидному номеру телефона")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .clickButtonRegistration();
        registrationPage
                .setNumberPhone("9099099099")
                .setSMSCode("5555");
        assertEquals("Вы ввели неверный код [1110]", registrationPage.getTextWithError(), "Не сошлось");
    }
}