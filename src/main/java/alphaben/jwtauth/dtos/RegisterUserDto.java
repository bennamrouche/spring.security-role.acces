package alphaben.jwtauth.dtos;


import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto
{
    @Email @NotNull @NotEmpty
    private String email;

    @Size(min = 6,max = 20)
    private String password;

    @NotEmpty  @NotNull @Size(min = 6,max = 20)
    private String fullName;


}