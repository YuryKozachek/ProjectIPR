package tests.api;

import adapters.UserAdapter;
import dto.user.GetUserRequest;
import dto.user.GetUserResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.ui.BaseTest;

public class GetUserTest extends BaseTest {

    UserAdapter userAdapter = new UserAdapter();

    @Description("Проверка получения пользователя")
    @Test
    public void getUser() {

        GetUserRequest getUserRequest = GetUserRequest
                .builder()
                .userId("8018")
                .build();
        GetUserResponse response = userAdapter.getUser(getUserRequest);

        softAssert.assertEquals(response.getId(), 8018, "Не сошлось");
        softAssert.assertEquals(response.getFirstName(), "qwerty1112", "Не сошлось");
        softAssert.assertEquals(response.getSecondName(), "qwerty1112", "Не сошлось");
        softAssert.assertEquals(response.getAge(), 121, "Не сошлось");
        softAssert.assertEquals(response.getSex(), "MALE", "Не сошлось");
        softAssert.assertEquals(response.getMoney(), 126262.0, "Не сошлось");
        softAssert.assertAll();
    }
}