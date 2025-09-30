package dto.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AddMoneyUserResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("secondName")
    private String secondName;

    @SerializedName("age")
    private int age;

    @SerializedName("sex")
    private String sex;

    @SerializedName("money")
    private double money;
}