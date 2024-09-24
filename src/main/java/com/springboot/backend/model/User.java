package com.springboot.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        String id;
        @Column(name = "first_name")
        String firstName;
        @Column(name = "last_name")
        String lastName;
        @Column(name = "age")
        int age;
        @Column(name = "city_name")
        String cityName;
        @Column(name = "address")
        String address;
        @Column(name = "username")
        String username;
        @Column(name = "password")
        String password;
        @Column(name = "email")
        String email;
        @Column(name = "phone_number")
        String phoneNumber;
        @Column(name = "role_id")
        String roleId;
        @Column(name = "image")
        String image;
        @Column(name = "gender")
        String gender;
        @Column(name = "birth_day")
        String birthDay;

        public String getId() {
                return this.id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getFirstName() {
                return this.firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return this.lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public int getAge() {
                return this.age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getCityName() {
                return this.cityName;
        }

        public void setCityName(String cityName) {
                this.cityName = cityName;
        }

        public String getAddress() {
                return this.address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getUsername() {
                return this.username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return this.password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return this.email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhoneNumber() {
                return this.phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getRoleId() {
                return this.roleId;
        }

        public void setRoleId(String roleId) {
                this.roleId = roleId;
        }

        public String getImage() {
                return this.image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public String getGender() {
                return this.gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getBirthDay() {
                return this.birthDay;
        }

        public void setBirthDay(String birthDay) {
                this.birthDay = birthDay;
        }

}
