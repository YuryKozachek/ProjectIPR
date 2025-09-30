package dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserRequest {

    @SerializedName("userId")
    @Expose
    private String userId;
}