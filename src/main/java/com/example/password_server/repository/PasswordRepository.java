package com.example.password_server.repository;

import com.example.password_server.model.Password;
import com.example.password_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<Password, Long> {
    List<Password> findByUser(User user);
}
