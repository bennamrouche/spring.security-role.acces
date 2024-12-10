package alphaben.jwtauth.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;

    private String password;
}