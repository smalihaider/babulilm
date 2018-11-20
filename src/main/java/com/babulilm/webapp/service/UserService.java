package com.babulilm.webapp.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.babulilm.webapp.dao.RoleDao;
import com.babulilm.webapp.dao.UserDao;
import com.babulilm.webapp.repository.RoleRepository;
import com.babulilm.webapp.repository.UserRepository;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDao findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(UserDao user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        RoleDao userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<RoleDao>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
