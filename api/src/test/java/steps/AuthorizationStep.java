package steps;

import adapters.AuthorizationAdapter;
import dto.auth.AuthorizationRequest;
import dto.auth.AuthorizationResponse;
import tests.api.BaseApiTest;

public class AuthorizationStep extends BaseApiTest {

    AuthorizationAdapter authorizationAdapter = new AuthorizationAdapter();

    public String authorisationApi() {
        AuthorizationRequest authorizationRequest = AuthorizationRequest.builder()
                .password(password)
                .username(user)
                .build();
        AuthorizationResponse rs = authorizationAdapter.authorization(authorizationRequest);
        return rs.getAccessToken();
    }
}