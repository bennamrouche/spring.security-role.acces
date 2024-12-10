package alphaben.jwtauth.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String token;

    private long expiresIn;

//    public String getToken() {
//        return token;
//    }


}