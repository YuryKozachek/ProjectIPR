package dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {

    private String firstName;
    private String secondName;
    private int age;
    private String sex;
    private int money;
}