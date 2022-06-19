package com.shinmj.userservice.controller;

import com.shinmj.userservice.domain.UserDetailsImpl;
import com.shinmj.userservice.domain.UserDto;
import com.shinmj.userservice.domain.UserJoinRequestDto;
import com.shinmj.userservice.domain.jwt.JwtRequestDto;
import com.shinmj.userservice.domain.repository.UserRepository;
import com.shinmj.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(UserController.URL_PREFIX)
public class UserController {
    final static String URL_PREFIX = "/user";
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    @RequestMapping(
            path = "/join",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE

    )
    public UserDto join(@RequestBody UserDto request) throws Exception {

        if (userRepository.findById(request.getId()).isPresent()) {
            throw new Exception();
        }

        return userRepository.save(request);

    }

    @RequestMapping(
            path = "/login",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login(@RequestBody JwtRequestDto request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getId(), request.getPw())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return principal.getUsername();
    }


}
