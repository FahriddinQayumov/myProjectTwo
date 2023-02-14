package com.example.backendcar.config;


import com.example.backendcar.enums.UserRoles;
import com.example.backendcar.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class CustomUserDetails implements UserDetails {
    private UUID id;
    private String userName;
    private String password;
    private boolean enabled;
    private UserRoles role;

    private List<GrantedAuthority> authorityList;

    public CustomUserDetails(User profile) {
        this.id = profile.getId();
        userName = profile.getUsername();
        password = profile.getPassword();
        enabled = profile.getEnable();
        role = profile.getRole();

        this.authorityList = Arrays.asList(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public String getPassword() {
        System.out.println("CustomUserDetails: getPassword()");
        return password;
    }

    @Override
    public String getUsername() {
        System.out.println("CustomUserDetails: getUsername()");
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role='" + role + '\'' +
                ", authorityList=" + authorityList +
                '}';
    }

    public UUID  getId() {
        return id;
    }
}
