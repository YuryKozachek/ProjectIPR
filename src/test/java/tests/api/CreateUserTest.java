package tests.api;

import adapters.UserAdapter;
import dto.user.CreateUserRequest;
import dto.user.CreateUserResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.AuthorizationStep;

public class CreateUserTest extends BaseApiTest {

    UserAdapter userAdapter = new UserAdapter();
    AuthorizationStep authorizationStep = new AuthorizationStep();

    @Description("Проверка создания пользователя")
    @Test
    public void createUser() {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .age(56)
                .firstName("Moisha")
                .money(777888)
                .secondName("Zadnaja")
                .sex("MALE")
                .build();
        CreateUserResponse response = userAdapter.createUser(createUserRequest, authorizationStep.authorisationApi());

        softAssert.assertEquals(response.getFirstName(), createUserRequest.getFirstName(), "Не сошлось");
        softAssert.assertEquals(response.getSecondName(), createUserRequest.getSecondName(), "Не сошлось");
        softAssert.assertEquals(response.getAge(), createUserRequest.getAge(), "Не сошлось");
        softAssert.assertEquals(response.getSex(), createUserRequest.getSex(), "Не сошлось");
        softAssert.assertEquals(response.getMoney(), createUserRequest.getMoney(), "Не сошлось");
        softAssert.assertNotNull(response.getId(), "Не сошлось");
        softAssert.assertAll();
    }
}