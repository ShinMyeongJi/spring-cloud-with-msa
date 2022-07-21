package com.shinmj.auth.service;

import com.shinmj.auth.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public User createUser(User user);

}
