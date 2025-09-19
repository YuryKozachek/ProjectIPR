package tests.api;

import adapters.UserAdapter;
import dto.user.AddMoneyUserResponse;
import dto.user.CreateUserResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import steps.AuthorizationStep;
import steps.CreateUserStep;
import tests.ui.BaseTest;

public class AddMoneyUserTest extends BaseTest {

    CreateUserStep createUserStep = new CreateUserStep();
    AuthorizationStep authorizationStep = new AuthorizationStep();
    UserAdapter userAdapter = new UserAdapter();

    int money = 10;

    CreateUserResponse createUserStepResponse = createUserStep.createUserGetID();

    @Description("Проверка добавление денег пользователю")
    @Test
    public void addMoneyUser() {

        AddMoneyUserResponse response = userAdapter.addMoneyUser(authorizationStep.authorisationApi(), createUserStepResponse.getId(), money);

        softAssert.assertEquals(response.getFirstName(), createUserStepResponse.getFirstName(), "Не сошлось");
        softAssert.assertEquals(response.getSecondName(), createUserStepResponse.getSecondName(), "Не сошлось");
        softAssert.assertEquals(response.getAge(), createUserStepResponse.getAge(), "Не сошлось");
        softAssert.assertEquals(response.getSex(), createUserStepResponse.getSex(), "Не сошлось");
        softAssert.assertEquals(response.getId(), createUserStepResponse.getId(), "Не сошлось");
        softAssert.assertEquals(response.getMoney(), createUserStepResponse.getMoney() + money + 0.0, "Не сошлось");
        softAssert.assertAll();
    }
}