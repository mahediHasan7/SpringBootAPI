package com.mahedihasan.store.controllers;

import com.mahedihasan.store.dtos.CreateOrUpdateProductRequest;
import com.mahedihasan.store.dtos.ProductDto;
import com.mahedihasan.store.entities.Category;
import com.mahedihasan.store.entities.Product;
import com.mahedihasan.store.mappers.ProductMapper;
import com.mahedihasan.store.repositories.CategoryRepository;
import com.mahedihasan.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, name = "categoryId") Byte categoryId,
            @RequestHeader(name = "x-auth-token", required = false) String authToken) {

        System.out.println(authToken);
        List<Product> products = categoryId != null ?
                productRepository.findByCategoryId(categoryId) : productRepository.findAllWithCategory();
        return products
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @PostMapping
    ResponseEntity<ProductDto> createProduct(@RequestBody CreateOrUpdateProductRequest request, UriComponentsBuilder uriBuilder) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Product product = productMapper.toEntity(request);
        product.setCategory(category);
        productRepository.save(product);

        var uri = uriBuilder.path("users/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(productMapper.toDto(product));
    }

    @PutMapping("/{id}")
    ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody CreateOrUpdateProductRequest request) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productMapper.update(request, product);
        product.setCategory(category);
        productRepository.save(product);

        return ResponseEntity.ok(productMapper.toDto(product));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
