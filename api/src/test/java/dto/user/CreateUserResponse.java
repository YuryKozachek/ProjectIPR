package dto.user;

import lombok.Data;

@Data
public class CreateUserResponse {

    private int id;
    private String firstName;
    private String secondName;
    private int age;
    private String sex;
    private int money;
}