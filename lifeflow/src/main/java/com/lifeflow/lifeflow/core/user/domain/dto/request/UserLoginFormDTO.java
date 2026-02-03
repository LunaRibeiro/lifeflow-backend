package com.lifeflow.lifeflow.core.user.domain.dto.request;

public record UserLoginFormDTO(
        String email,
        String password
) {
}
