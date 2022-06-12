package com.shinmj.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(FirstServiceController.URL_PREFIX)
public class FirstServiceController {
    public static final String URL_PREFIX = "/first-service";


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String welcome() {return "Welcome to the First service.";}
}
