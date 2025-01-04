package com.cypher.blog_app_apis.services;

import com.cypher.blog_app_apis.payloads.Dtos.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerNewUser(UserDto userDto);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer uid);
    UserDto getUserById(Integer uid);
    List<UserDto> getAllUsers();
    void deleteUser(Integer uid);
}
