package com.doutor.setListMusical.service;

import com.doutor.setListMusical.dto.request.UserRequestDTO;
import com.doutor.setListMusical.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO findById(Long id);

    UserResponseDTO findByEmail(String email);

    List<UserResponseDTO> findAll();

    UserResponseDTO register(UserRequestDTO userDTO);

    UserResponseDTO update(UserRequestDTO userRequestDTO, Long id);
    String delete(Long id);
    String changePass(Long id, String pass);
    Boolean validatePass(String email, String pass);
}