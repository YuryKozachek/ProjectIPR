package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    @DisplayName("Регистрация по невалидному номеру телефона")
    @Test
    public void checkLogin() {

        loginPage
                .open()
                .clickButtonRegistration();
        registrationPage
                .setNumberPhone("9099099099")
                .setSMSCode("5555");
        Assertions.assertEquals("Вы ввели неверный код [1110]", registrationPage.getTextWithError());
    }
}