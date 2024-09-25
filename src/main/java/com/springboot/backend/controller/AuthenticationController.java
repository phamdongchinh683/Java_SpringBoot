package com.springboot.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.request.ApiResponse;
import com.springboot.backend.dto.request.AuthenticationRequest;
import com.springboot.backend.dto.response.AuthenticationResponse;
import com.springboot.backend.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

        AuthenticationService authenticationService;

        @PostMapping("/login")
        ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
                boolean result = authenticationService.authenticate(request);
                return ApiResponse.<AuthenticationResponse>builder()
                                .result(AuthenticationResponse.builder().Authenticated(result).build()).build();
        }

}
