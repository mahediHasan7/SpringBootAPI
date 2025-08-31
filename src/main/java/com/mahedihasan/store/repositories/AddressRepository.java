package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}