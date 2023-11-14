package com.doutor.jpaHibernate.dto.response;

import com.doutor.jpaHibernate.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Boolean administrator;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.administrator = user.getAdministrator();
    }

    @Builder
    public UserResponseDTO(Long id, String name, String email, String phone, Boolean administrator) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.administrator = administrator;
    }
}
