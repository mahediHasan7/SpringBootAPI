package com.mahedihasan.store.repositories;

import com.mahedihasan.store.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // also eager loading category because Hibernate calls extra query
    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte id);

    // to avoid n+1 problem while loading products with categories
    @EntityGraph(attributePaths = "category")
    @Query(value = "select p from Product p")
    List<Product> findAllWithCategory();
}