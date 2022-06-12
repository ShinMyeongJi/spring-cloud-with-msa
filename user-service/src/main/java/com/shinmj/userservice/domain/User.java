package com.shinmj.userservice.domain;

import lombok.Builder;

@Builder
public class User {
    private String id;
    private String pw;
}
