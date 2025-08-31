package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}