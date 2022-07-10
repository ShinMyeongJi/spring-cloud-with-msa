package com.shinmj.rentalservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class ReturnedItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "returned_date")
    private LocalDate returnedDate;

    @ManyToOne
    @JsonIgnoreProperties
    private Rental rental;

    public static ReturnedItem createReturnedItem(Long bookId, String title, LocalDate now){
        ReturnedItem returnedItem = new ReturnedItem();

        returnedItem.setBookId(bookId);
        returnedItem.setBookTitle(title);
        returnedItem.setReturnedDate(now);

        return returnedItem;
    }
}
