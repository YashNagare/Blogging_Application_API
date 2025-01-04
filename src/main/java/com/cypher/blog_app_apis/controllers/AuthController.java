package com.cypher.blog_app_apis.controllers;

import com.cypher.blog_app_apis.exceptions.ApiException;
import com.cypher.blog_app_apis.payloads.JwtAuthRequest;
import com.cypher.blog_app_apis.payloads.JwtAuthResponse;
import com.cypher.blog_app_apis.payloads.Dtos.UserDto;
import com.cypher.blog_app_apis.security.JwtTokenHelper;
import com.cypher.blog_app_apis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request
    ) throws Exception {
        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        this.authenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String generatedToken = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse authResponse = new JwtAuthResponse();
        authResponse.setToken(generatedToken);
        return new ResponseEntity<JwtAuthResponse>(authResponse, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception{

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        try{
            this.authenticationManager.authenticate(token);
        }catch (BadCredentialsException e){
            System.out.println("Invalid User Details !!!");
            throw new ApiException("Invalid Username or password !!!");
        }
    }

    //register new user
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        UserDto registeredUser = this.userService.registerNewUser(userDto);
        return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
    }

}
