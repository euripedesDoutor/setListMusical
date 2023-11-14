package com.doutor.setListMusical.repository;

import com.doutor.setListMusical.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
