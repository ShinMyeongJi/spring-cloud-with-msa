package com.shinmj.bookservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookInfoDTO {
    private Long id;
    private String title;
}
