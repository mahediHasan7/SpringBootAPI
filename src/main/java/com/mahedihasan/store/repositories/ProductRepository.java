package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}