package com.doutor.setListMusical.services;

import com.doutor.setListMusical.dtos.UserDTO;
import com.doutor.setListMusical.domain.User;
import com.doutor.setListMusical.repositories.UserRepository;
import com.doutor.setListMusical.util.UtilMethods;
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
    public User findById(Long id) {
        return returnUser(id);
    }

    @Override
    public User findByEmail(String email) {
        return returnUser(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User register(UserDTO userDTO) {
        User user = new User(userDTO);
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User update(UserDTO userDTO, Long id) {
        User user = returnUser(id);
        user = loadData(user, userDTO);
        return userRepository.save(user);
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
        userRepository.save(user);
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

    private User loadData(User user, UserDTO userDTO){
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPhone(userDTO.phone());
        user.setAdministrator(userDTO.administrator());
        return user;
    }
}
