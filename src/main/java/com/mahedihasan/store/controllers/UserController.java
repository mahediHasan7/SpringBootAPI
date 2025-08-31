package com.mahedihasan.store.controllers;

import com.mahedihasan.store.dtos.UserDto;
import com.mahedihasan.store.entities.User;
import com.mahedihasan.store.mappers.UserMapper;
import com.mahedihasan.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers(@RequestParam(required = false, defaultValue = "", name = "sort") String sortField) {
        if (!Set.of("name", "email").contains(sortField)) sortField = "name";
        Sort sort = Sort.by(sortField);

        return userRepository.findAll(sort)
                .stream()
                .map(user -> userMapper.toDto(user))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
