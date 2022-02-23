package dev.cfan.rocklifterapi.security;

import dev.cfan.rocklifterapi.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class JpaUser implements UserDetails {

    private final User user;
    private String userName;
    private String password;
    private String emailAddress;

    public JpaUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
//        System.out.println("Let's debug.");
//        System.out.println("getting name");
//        System.out.println(user.getName());
//        System.out.println("Getting role.");
//        System.out.println(user.getUserRole());
//        System.out.println("Getting user");
////        System.out.println(user.toString());
//        System.out.println(user.getUserRole().getRole());
//        return List.of(new
//                SimpleGrantedAuthority(user.getUserRole().getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
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
        return true;
    }

    public User getUser() {
        return user;
    }
}
