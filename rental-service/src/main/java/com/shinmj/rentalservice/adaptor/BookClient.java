package com.shinmj.rentalservice.adaptor;

import com.shinmj.rentalservice.api.dto.BookInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book", configuration = {FeignClient.class})
public interface BookClient {

    @GetMapping("/api/books/bookInfo/{bookId}")
    ResponseEntity<BookInfoDTO> findBookInfo(@PathVariable("bookId") Long bookId);
}
