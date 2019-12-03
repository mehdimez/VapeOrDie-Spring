package com.vapeordie.vapeordie.security;

import com.vapeordie.vapeordie.model.User;
import com.vapeordie.vapeordie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private AccountService accountService ;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("load loula");
        User user = accountService.loadUserByEmail(email);
        if(user==null)throw new UsernameNotFoundException("email not exist");
        Collection<GrantedAuthority> authorities = new ArrayList<>() ;
        user.getRoles().forEach(role ->  authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
