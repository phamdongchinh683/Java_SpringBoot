package com.springboot.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.backend.dto.request.UserCreation;
import com.springboot.backend.dto.request.UserUpdate;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.exception.AppException;
import com.springboot.backend.exception.ErrorCode;
import com.springboot.backend.mapper.UserMapper;
import com.springboot.backend.model.User;
import com.springboot.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreation request) {
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper
                .toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String id, UserUpdate request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.update(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
