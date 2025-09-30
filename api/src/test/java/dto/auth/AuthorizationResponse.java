package dto.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorizationResponse {

    @SerializedName("access_token")
    private String accessToken;
}