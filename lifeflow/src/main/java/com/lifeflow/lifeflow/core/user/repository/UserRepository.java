package com.lifeflow.lifeflow.core.user.repository;

import com.lifeflow.lifeflow.core.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
