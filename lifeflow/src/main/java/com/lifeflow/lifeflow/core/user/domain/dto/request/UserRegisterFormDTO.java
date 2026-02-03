package com.lifeflow.lifeflow.core.user.domain.dto.request;

public record UserRegisterFormDTO(
        String name,
        String email,
        String password
) {
}
