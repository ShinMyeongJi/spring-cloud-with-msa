package com.shinmj.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserJoinRequestDto {
    String id;
    String pw;
    String name;
}
