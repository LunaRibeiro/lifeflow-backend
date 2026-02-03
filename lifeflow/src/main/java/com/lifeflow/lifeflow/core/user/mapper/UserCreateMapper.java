package com.lifeflow.lifeflow.core.user.mapper;

import com.lifeflow.lifeflow.core.user.domain.dto.request.UserRegisterFormDTO;
import com.lifeflow.lifeflow.core.user.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCreateMapper {

    private final PasswordEncoder passwordEncoder;

    public User convert(UserRegisterFormDTO userRegisterFormDTO) {

        User user = new User();
        user.setName(userRegisterFormDTO.name());
        user.setEmail(userRegisterFormDTO.email());
        user.setPassword(passwordEncoder.encode(userRegisterFormDTO.password()));

        return user;
    }

}
