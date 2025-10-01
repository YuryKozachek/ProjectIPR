package dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorizationRequest {

    private String password;
    private String username;
}