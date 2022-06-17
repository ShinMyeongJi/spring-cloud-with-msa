package com.shinmj.userservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "USER")
@Entity
public class UserDto {

    @Id
    @Column(name = "id", length=20)
    private String id;

    @Column
    private String encrypt_pw;

    @Column
    private String name;
}
