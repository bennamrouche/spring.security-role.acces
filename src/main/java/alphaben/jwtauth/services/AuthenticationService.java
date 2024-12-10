package alphaben.jwtauth.services;


import alphaben.jwtauth.dtos.LoginUserDto;
import alphaben.jwtauth.dtos.RegisterUserDto;
import alphaben.jwtauth.entities.Role;
import alphaben.jwtauth.entities.RoleEnum;
import alphaben.jwtauth.entities.User;
import alphaben.jwtauth.repositories.RoleRepository;
import alphaben.jwtauth.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
   private final  RoleRepository roleRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User signup(RegisterUserDto input) {


        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

            if (optionalRole.isEmpty()) {
                return null;
            }

            var user = new User();
        user.setFullName(input.getFullName());
        user        .setEmail(input.getEmail());
        user        .setPassword(passwordEncoder.encode(input.getPassword()));
        user        .setRole(optionalRole.get());

            return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}