package com.lifeflow.lifeflow.core.user.controller;

import com.lifeflow.lifeflow.core.user.domain.dto.request.UserLoginFormDTO;
import com.lifeflow.lifeflow.core.user.domain.dto.request.UserRegisterFormDTO;
import com.lifeflow.lifeflow.core.user.domain.dto.response.UserDTO;
import com.lifeflow.lifeflow.core.user.domain.entity.User;
import com.lifeflow.lifeflow.core.user.service.UserService;
import com.lifeflow.lifeflow.infra.security.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login (@RequestBody UserLoginFormDTO userLoginFormDTO){
        User user = userService.findUserByEmailOrThrow(userLoginFormDTO.email());
        if (passwordEncoder.matches(userLoginFormDTO.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);

            UserDTO userDTO = userService.generateUserDTO(user, token);

            return ResponseEntity.ok().body(userDTO);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register (@RequestBody UserRegisterFormDTO userRegisterFormDTO){
        User user = userService.generateUser(userRegisterFormDTO);
        userService.save(user);

        String token = tokenService.generateToken(user);
        UserDTO userDTO = userService.generateUserDTO(user, token);

        return ResponseEntity.ok().body(userDTO);
    }

}
