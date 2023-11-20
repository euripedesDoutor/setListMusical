package com.doutor.setListMusical.controllers;

import com.doutor.setListMusical.dtos.UserDTO;
import com.doutor.setListMusical.domain.User;
import com.doutor.setListMusical.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok().body(userService.findByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserDTO userDTO, UriComponentsBuilder uriBuilder){
        User user = userService.register(userDTO);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/changePass/{id}/{pass}")
    public ResponseEntity<String> changePass(@PathVariable Long id, @PathVariable String pass){
        return ResponseEntity.ok().body(userService.changePass(id, pass));
    }

    @PostMapping("/validatePass/{email}/{pass}")
    public ResponseEntity<Boolean> validatePass(@PathVariable String email, @PathVariable String pass){
        return ResponseEntity.ok().body(userService.validatePass(email, pass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.update(userDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.delete(id));
    }
}
