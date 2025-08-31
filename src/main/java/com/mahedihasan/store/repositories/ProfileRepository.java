package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}