package steps;

import adapters.UserAdapter;
import dto.user.CreateUserRequest;
import dto.user.CreateUserResponse;
import io.qameta.allure.Step;
import tests.ui.BaseUITest;

public class CreateUserStep extends BaseUITest {

    AuthorizationStep authorizationStep = new AuthorizationStep();
    UserAdapter userAdapter = new UserAdapter();

    @Step("Создание пользавателя API")
    public CreateUserResponse createUserGetID() {
        CreateUserRequest createUserRequest = CreateUserRequest
                .builder()
                .age(56)
                .firstName("Moisha")
                .money(777888)
                .secondName("Zadnaja")
                .sex("MALE")
                .build();
        CreateUserResponse response = userAdapter.createUser(createUserRequest, authorizationStep.authorisationApi());
        return response;
    }
}