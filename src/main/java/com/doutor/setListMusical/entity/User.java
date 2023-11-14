package com.doutor.setListMusical.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    private Boolean administrator;
    private String password;

    @Builder
    public User(String name, String phone, String email, Boolean administrator) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.administrator = administrator;
    }
}
