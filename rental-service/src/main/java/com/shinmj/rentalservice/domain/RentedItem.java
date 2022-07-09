package com.shinmj.rentalservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class RentedItem implements Serializable {

    // 대출 아이템 일련 번호
    private Long id;

    // 도서 일련 번호
    private Long bookId;

    // 대출 날짜
    private LocalDate rentedDate;

    // 반납 예정일
    private LocalDate dueDate;

    // 책 이름
    private String bookTitle;

    // 연관 Rental
    @ManyToOne
    @JsonIgnoreProperties("rentedItems")
    private Rental rental;

    // 대출 아이템 생성 메서
    public static RentedItem createRentedItem(Long bookId, String bookTitle, LocalDate rentedDate) {
        RentedItem rentedItem = new RentedItem();

        rentedItem.setBookId(bookId);
        rentedItem.setBookTitle(bookTitle);
        rentedItem.setRentedDate(rentedDate);
        rentedItem.setDueDate(rentedDate.plusWeeks(2));

        return rentedItem;
    }
}
