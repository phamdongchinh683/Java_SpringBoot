package com.springboot.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.backend.dto.request.AuthenticationRequest;
import com.springboot.backend.exception.AppException;
import com.springboot.backend.exception.ErrorCode;
import com.springboot.backend.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
        UserRepository userRepository;

        public boolean authenticate(AuthenticationRequest request) {
                var user = userRepository.findByUsername(request.getUsername())
                                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
                return passwordEncoder.matches(request.getPassword(), user.getPassword());
        }
}
