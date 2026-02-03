package com.lifeflow.lifeflow.core.user.service;

import com.lifeflow.lifeflow.core.user.domain.dto.request.UserRegisterFormDTO;
import com.lifeflow.lifeflow.core.user.domain.dto.response.UserDTO;
import com.lifeflow.lifeflow.core.user.domain.entity.User;
import com.lifeflow.lifeflow.core.user.mapper.UserCreateMapper;
import com.lifeflow.lifeflow.core.user.mapper.UserDTOMapper;
import com.lifeflow.lifeflow.core.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreateMapper userCreateMapper;
    private final UserDTOMapper userDTOMapper;

    public User save(User user){
        return userRepository.save(user);
    }

    public User generateUser(UserRegisterFormDTO userRegisterFormDTO){
        return userCreateMapper.convert(userRegisterFormDTO);
    }

    public UserDTO generateUserDTO(User user, String token){
        return userDTOMapper.convert(user, token);
    }

    public void delete (User user){
        userRepository.delete(user);
    }

    public User findUserByEmailOrThrow(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
