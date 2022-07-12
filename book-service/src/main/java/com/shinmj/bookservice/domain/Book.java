package com.shinmj.bookservice.domain;

import com.shinmj.bookservice.domain.enumeration.BookStatus;
import com.shinmj.bookservice.domain.enumeration.Classification;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String bookTitle;

    private String description;

    private String publisher;

    private Long isbn;

    private LocalDate publicationDate;

    private Classification classification;

    private BookStatus bookStatus;


}
