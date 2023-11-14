package com.doutor.jpaHibernate.util;

import com.doutor.jpaHibernate.dto.request.UserRequestDTO;
import com.doutor.jpaHibernate.dto.response.UserResponseDTO;
import com.doutor.jpaHibernate.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static User toUser(UserResponseDTO userResponse){
        return User.builder()
                .name(userResponse.getName())
                .email(userResponse.getEmail())
                .phone(userResponse.getPhone())
                .administrator(userResponse.getAdministrator())
                .build();
    }

    public static User toUser(UserRequestDTO userRequest){
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .administrator(userRequest.getAdministrator())
                .build();
    }

    public static UserResponseDTO toUserResponse(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .administrator(user.getAdministrator())
                .build();
    }

    public static UserRequestDTO toUserRequest(User user){
        return UserRequestDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .administrator(user.getAdministrator())
                .build();
    }

    public static List<UserResponseDTO> toListUserResponse(List<User> user){
        return user.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public static void toUpdateUser(User user, UserRequestDTO userRequestDTO){
        user.setEmail(userRequestDTO.getEmail());
        user.setName(userRequestDTO.getName());
        user.setPhone(userRequestDTO.getPhone());
        user.setAdministrator(userRequestDTO.getAdministrator());
    }

}
