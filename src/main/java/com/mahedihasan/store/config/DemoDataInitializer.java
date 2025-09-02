package com.mahedihasan.store.config;

import com.mahedihasan.store.entities.Category;
import com.mahedihasan.store.entities.Product;
import com.mahedihasan.store.entities.User;
import com.mahedihasan.store.repositories.CategoryRepository;
import com.mahedihasan.store.repositories.ProductRepository;
import com.mahedihasan.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@AllArgsConstructor
public class DemoDataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0 && categoryRepository.count() == 0) {
            Category electronics = categoryRepository.save(new Category("electronics"));
            Category books = categoryRepository.save(new Category("books"));

            productRepository.saveAll(List.of(
                    new Product(null, "Apple Laptop", "Demo Apple", new BigDecimal("1399.99"), electronics),
                    new Product(null, "Dell Laptop", "Demo dell laptop", new BigDecimal("1299.00"), electronics),
                    new Product(null, "Clean Code", "Programming book", new BigDecimal("29.99"), books)
            ));
        }

        if (userRepository.count() == 0) {
            userRepository.saveAll(List.of(
                    new User("John Doe", "john@example.com", "123123"),
                    new User("Jane Smith", "jane@example.com", "123123"),
                    new User("Christina Darren", "christina@example.com", "0011")
            ));
        }
    }
}
