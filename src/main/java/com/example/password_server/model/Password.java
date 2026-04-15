package com.example.password_server.model;

import jakarta.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String label;
    public String password;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
