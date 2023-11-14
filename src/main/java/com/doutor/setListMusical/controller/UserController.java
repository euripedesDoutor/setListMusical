package com.doutor.setListMusical.controller;

import com.doutor.setListMusical.dto.request.UserRequestDTO;
import com.doutor.setListMusical.dto.response.UserResponseDTO;
import com.doutor.setListMusical.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("email") String email){
        return ResponseEntity.ok().body(userService.findByEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO userRequestDTO, UriComponentsBuilder uriBuilder){
        UserResponseDTO userResponseDTO = userService.register(userRequestDTO);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(userResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userResponseDTO);
    }

    @PostMapping("/changePass/{id}/{pass}")
    public ResponseEntity<String> changePass(@PathVariable Long id, @PathVariable String pass){
        return ResponseEntity.ok().body(userService.changePass(id, pass));
    }

    @PostMapping("/validatePass/{email}/{pass}")
    public ResponseEntity<Boolean> changePass(@PathVariable String email, @PathVariable String pass){
        return ResponseEntity.ok().body(userService.validatePass(email, pass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO userRequestDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.update(userRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(userService.delete(id));
    }
}
