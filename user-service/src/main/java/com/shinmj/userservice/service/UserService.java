package com.shinmj.userservice.service;

import com.shinmj.userservice.domain.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    public UserDto createUser(UserDto userDto);

}
