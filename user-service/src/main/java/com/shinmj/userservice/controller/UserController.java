package com.shinmj.userservice.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(UserController.URL_PREFIX)
public class UserController {
    final static String URL_PREFIX = "/auth";



    /*private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    @RequestMapping(
            path = "/join",
            method = RequestMethod.POST,
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
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String login(@RequestBody JwtRequestDto request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getId(), request.getPw())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDto principal = (UserDto) authentication.getPrincipal();
        return principal.getUsername();
    }*/


}
