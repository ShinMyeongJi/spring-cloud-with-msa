package com.shinmj.bookservice.api.controller;

import com.shinmj.bookservice.api.RestControllerBase;
import com.shinmj.bookservice.api.dto.BookDTO;
import com.shinmj.bookservice.api.dto.BookInfoDTO;
import com.shinmj.bookservice.domain.Book;
import com.shinmj.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BookController.URL_PREFIX)
@RequiredArgsConstructor
public class BookController extends RestControllerBase {

    public static final String URL_PREFIX = API_URL_PREFIX + "/books";

    private final BookService bookService;

    @GetMapping("/bookInfo/{bookId}")
    public ResponseEntity<BookInfoDTO> findBookInfo(@PathVariable("bookId") Long bookId) {
        Book book = bookService.findBookInfo(bookId);
        BookInfoDTO bookInfoDTO = new BookInfoDTO(book.getId(), book.getBookTitle());

        return ResponseEntity.ok(bookInfoDTO);
    }
}
