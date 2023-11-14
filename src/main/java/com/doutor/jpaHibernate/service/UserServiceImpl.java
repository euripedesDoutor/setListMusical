package com.doutor.jpaHibernate.service;

import com.doutor.jpaHibernate.dto.request.UserRequestDTO;
import com.doutor.jpaHibernate.dto.response.UserResponseDTO;
import com.doutor.jpaHibernate.entity.User;
import com.doutor.jpaHibernate.repository.UserRepository;
import com.doutor.jpaHibernate.util.UserMapper;
import com.doutor.jpaHibernate.util.UtilMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO findById(Long id) {
        return UserMapper.toUserResponse(returnUser(id));
    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        return UserMapper.toUserResponse(returnUser(email));
    }

    @Override
    public List<UserResponseDTO> findAll() {
        return UserMapper.toListUserResponse(userRepository.findAll());
    }

    @Override
    public UserResponseDTO register(UserRequestDTO userDTO) {
        User user = UserMapper.toUser(userDTO);
        user = userRepository.save(user);
        return UserMapper.toUserResponse(user);
    }

    @Override
    public UserResponseDTO update(UserRequestDTO userRequestDTO, Long id) {
        User user = returnUser(id);
        UserMapper.toUpdateUser(user, userRequestDTO);
        return UserMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User ID: " + id + " deleted";
    }

    @Override
    public String changePass(Long id, String pass) {
        User user = returnUser(id);
        try {
            user.setPassword(UtilMethods.encriptar(pass));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "Error to change pass for ID: " + id + ".";
        }
        UserMapper.toUserResponse(userRepository.save(user));
        return "Pass changed for ID: " + id + ".";
    }

    @Override
    public Boolean validatePass(String email, String pass) {
        try {
            User user = returnUser(email);
            if (user.getPassword().equals(UtilMethods.encriptar(pass))) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    private User returnUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User wasn't found on database"));
    }

    private User returnUser(String email) {
        return userRepository.findByEmail(email);
    }
}
