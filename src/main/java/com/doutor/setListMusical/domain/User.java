package com.doutor.setListMusical.domain;

import com.doutor.setListMusical.dtos.UserDTO;
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


    public User(UserDTO userDto) {
        this.name = userDto.name();
        this.phone = userDto.phone();
        this.email = userDto.email();
        this.administrator = userDto.administrator();
    }
}
