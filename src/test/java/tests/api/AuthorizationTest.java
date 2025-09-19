package tests.api;

import adapters.AuthorizationAdapter;
import dto.auth.AuthorizationRequest;
import dto.auth.AuthorizationResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.ui.BaseTest;


@Test
public class AuthorizationTest extends BaseTest {

    AuthorizationAdapter authorizationAdapter = new AuthorizationAdapter();

    @Description("Проверка получения токена для авторизации")
    @Test
    public void authorization() {
        AuthorizationRequest authorizationRequest = AuthorizationRequest.builder()
                .password(password)
                .username(user)
                .build();

        AuthorizationResponse rs = authorizationAdapter.authorization(authorizationRequest);

        softAssert.assertNotNull(rs.getAccessToken(), "Токен не должен быть null");
        softAssert.assertFalse(rs.getAccessToken().isEmpty(), "Токен не должен быть пустым");
        softAssert.assertAll();
    }
}