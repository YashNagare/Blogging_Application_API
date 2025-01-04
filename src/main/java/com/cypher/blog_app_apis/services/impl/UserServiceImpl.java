package com.cypher.blog_app_apis.services.impl;

import com.cypher.blog_app_apis.config.AppConstants;
import com.cypher.blog_app_apis.entities.Role;
import com.cypher.blog_app_apis.entities.User;
import com.cypher.blog_app_apis.exceptions.ResourceNotFoundException;
import com.cypher.blog_app_apis.payloads.Dtos.UserDto;
import com.cypher.blog_app_apis.repositories.RoleRepository;
import com.cypher.blog_app_apis.repositories.UserRepository;
import com.cypher.blog_app_apis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        Role role = this.roleRepository.findById(AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);
        User savedUser = this.userRepository.save(user);

        return this.modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer uid) {
        User user = this.userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","id",uid));
        user.setName(userDto.getName());
        user.setAbout(userDto.getAbout());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User updatedUser = this.userRepository.save(user);
        UserDto userDto1 = this.userToDto(user);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer uid) {
        User user = this.userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","id",uid));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer uid) {
        User user = this.userRepository.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","id",uid));
        this.userRepository.delete(user);
    }


    private User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        return user;
    }
    private UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

//    private User dtoToUser(UserDto userDto){
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
//        return user;
//    }


//    private UserDto userToDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
//        return userDto;
//    }
}
