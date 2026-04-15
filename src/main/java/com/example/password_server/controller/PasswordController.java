package com.example.password_server.controller;

import com.example.password_server.model.Password;
import com.example.password_server.model.User;
import com.example.password_server.repository.PasswordRepository;
import com.example.password_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passwords")
public class PasswordController {

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Void> storePassword(@RequestBody Password password) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        password.setUser(user);
        passwordRepository.save(password);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Password>> getPasswords() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        List<Password> passwords = passwordRepository.findByUser(user);
        return ResponseEntity.ok(passwords);
    }
}
