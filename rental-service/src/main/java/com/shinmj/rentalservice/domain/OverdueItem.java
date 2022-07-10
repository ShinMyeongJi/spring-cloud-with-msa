package com.shinmj.rentalservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class OverdueItem {

    // 연체 아이템 일련번호
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    private Long id;

    // 도서 일련 번호
    private Long bookId;

    // 도서 제목
    private String bookTitle;

    // 반납 예정일
    private LocalDate dueDate;

    // 연관 Rental
    @ManyToOne
    @JsonIgnoreProperties
    private Rental rental;


    // 연체 아이템 생성
    public static OverdueItem createOverdueItem(Long bookId, String bookTitle, LocalDate dueDate) {
        OverdueItem overdueItem = new OverdueItem();
        overdueItem.setBookId(bookId);
        overdueItem.setBookTitle(bookTitle);
        overdueItem.setDueDate(dueDate);

        return overdueItem;
    }
}
