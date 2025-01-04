package com.cypher.blog_app_apis.security;

import com.cypher.blog_app_apis.entities.User;
import com.cypher.blog_app_apis.exceptions.ResourceNotFoundException;
import com.cypher.blog_app_apis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User"," email : "+username,0));
        return user;
    }
}
