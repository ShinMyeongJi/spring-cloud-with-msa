package com.shinmj.rentalservice.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class ReturnedItem implements Serializable {

    private Long id;

    private Long bookId;

    private String title;

    private LocalDate returnedDate;

    public static ReturnedItem createReturnedItem(Long bookId, String title, LocalDate now){
        ReturnedItem returnedItem = new ReturnedItem();

        returnedItem.setBookId(bookId);
        returnedItem.setTitle(title);
        returnedItem.setReturnedDate(now);

        return returnedItem;
    }
}
