package com.yevhenpiven.bootstrapproject.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yevhenpiven.bootstrapproject.entity.Role;
import com.yevhenpiven.bootstrapproject.entity.User;
import com.yevhenpiven.bootstrapproject.repository.RoleRepository;
import com.yevhenpiven.bootstrapproject.repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void assignRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        if (user != null && role != null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
