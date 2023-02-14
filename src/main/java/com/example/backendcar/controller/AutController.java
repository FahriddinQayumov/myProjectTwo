package com.example.backendcar.controller;

import com.example.backendcar.config.JwtTokenUtil;
import com.example.backendcar.dto.user.AuthorizationDto;
import com.example.backendcar.dto.user.UserDetailedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AutController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationDto request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

            UserDetails user = (UserDetails) authenticate.getPrincipal();

            String jwtToken = jwtTokenUtil.generateAccessToken(user);

            UserDetailedDto dto = new UserDetailedDto();
            dto.setUsername(user.getUsername());
            dto.setToken(jwtToken);

            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .body(dto);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
