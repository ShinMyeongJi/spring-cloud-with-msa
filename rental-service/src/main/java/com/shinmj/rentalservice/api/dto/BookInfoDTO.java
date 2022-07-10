package com.shinmj.rentalservice.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Book과의 동기 통신을 위한 DTO 객체
 * 수신용 객체기 때문에 생성자가 선언되면 안된다.
 */
@Getter
@Setter
public class BookInfoDTO implements Serializable {
    private Long id;
    private String title;
}
