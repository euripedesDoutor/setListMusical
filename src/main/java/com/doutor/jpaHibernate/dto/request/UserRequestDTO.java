package com.doutor.jpaHibernate.dto.request;

import com.doutor.jpaHibernate.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    private String name;
    private String email;
    private String phone;
    private Boolean administrator;

    @Builder

    public UserRequestDTO(String name, String email, String phone, Boolean administrator) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.administrator = administrator;
    }
}
