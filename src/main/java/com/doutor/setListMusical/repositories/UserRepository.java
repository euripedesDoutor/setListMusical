package com.doutor.setListMusical.repositories;

import com.doutor.setListMusical.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
