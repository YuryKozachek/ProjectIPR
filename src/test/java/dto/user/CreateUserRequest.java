package dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("secondName")
    @Expose
    private String secondName;

    @SerializedName("age")
    @Expose
    private int age;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("money")
    @Expose
    private int money;
}