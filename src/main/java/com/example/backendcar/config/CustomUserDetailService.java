package com.example.backendcar.config;


import com.example.backendcar.model.User;
import com.example.backendcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Keldi: loadUserByUsername.");
        Optional<User> usersOptional = userRepository.findByIdByUsername(s);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        User profile = usersOptional.get();

        return new CustomUserDetails(profile);
    }
}
