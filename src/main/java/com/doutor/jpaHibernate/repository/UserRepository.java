package com.doutor.jpaHibernate.repository;

import com.doutor.jpaHibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
