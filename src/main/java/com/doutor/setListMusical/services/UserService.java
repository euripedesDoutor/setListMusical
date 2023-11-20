package com.doutor.setListMusical.services;

import com.doutor.setListMusical.dtos.UserDTO;
import com.doutor.setListMusical.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByEmail(String email);

    List<User> findAll();

    User register(UserDTO userDTO);

    User update(UserDTO userDTO, Long id);
    String delete(Long id);
    String changePass(Long id, String pass);
    Boolean validatePass(String email, String pass);
}
