package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
