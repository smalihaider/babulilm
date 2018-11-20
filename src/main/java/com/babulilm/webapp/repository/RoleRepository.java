package com.babulilm.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babulilm.webapp.dao.RoleDao;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleDao, Integer> {
	RoleDao findByRole(String role);
}
