package dto.user;

import lombok.Data;

@Data
public class GetUserResponse {

    private int id;
    private String firstName;
    private String secondName;
    private int age;
    private String sex;
    private double money;
}