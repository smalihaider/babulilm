package com.babulilm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babulilm.webapp.dao.UserDao;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserDao, Long> {
	UserDao findByEmail(String email);
}