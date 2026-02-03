package com.lifeflow.lifeflow.core.user.mapper;

import com.lifeflow.lifeflow.core.user.domain.dto.response.UserDTO;
import com.lifeflow.lifeflow.core.user.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDTOMapper {

    public UserDTO convert(User user) {
        return new UserDTO(
                user.getName(),
                user.getPassword()
        );
    }

}
