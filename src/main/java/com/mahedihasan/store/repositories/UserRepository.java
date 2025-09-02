package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
}
