package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.request.ApiResponse;
import com.springboot.backend.dto.request.UserCreation;
import com.springboot.backend.dto.request.UserUpdate;
import com.springboot.backend.dto.response.UserResponse;
import com.springboot.backend.model.User;
import com.springboot.backend.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/auth")

public class UserController {

        @Autowired
        private UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @GetMapping("/users")
        ApiResponse<List<User>> userList() {
                ApiResponse<List<User>> apiResponse = new ApiResponse<>();
                List<User> users = userService.getUsers();
                apiResponse.setResult(users);
                return apiResponse;
        }

        @PostMapping("/create")
        ApiResponse<User> createUser(@RequestBody @Valid UserCreation request) {
                ApiResponse<User> apiResponse = new ApiResponse<>();
                apiResponse.setResult(userService.createUser(request));
                return apiResponse;
        }

        @GetMapping("/profile/{id}")
        UserResponse profile(@PathVariable("id") String id) {
                return userService.getUser(id);
        }

        @PutMapping("/update/{id}")
        UserResponse updateUser(@PathVariable("id") String id, @RequestBody UserUpdate request) {
                return userService.updateUser(id, request);
        }

        @DeleteMapping("/delete/{id}")
        ApiResponse<User> deleteUser(@PathVariable("id") String id) {
                ApiResponse<User> apiResponse = new ApiResponse<>();
                userService.deleteUser(id);
                apiResponse.setMessage("User has been deleted");
                return apiResponse;
        }
}
