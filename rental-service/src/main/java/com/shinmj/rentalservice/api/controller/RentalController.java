package com.shinmj.rentalservice.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shinmj.rentalservice.adaptor.BookClient;
import com.shinmj.rentalservice.api.RestControllerBase;
import com.shinmj.rentalservice.api.dto.BookInfoDTO;
import com.shinmj.rentalservice.api.dto.RentalDTO;
import com.shinmj.rentalservice.domain.Rental;
import com.shinmj.rentalservice.exception.RentUnavailableException;
import com.shinmj.rentalservice.service.RentalService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(RentalController.URL_PREFIX)
@RequiredArgsConstructor
public class RentalController extends RestControllerBase {
    public static final String URL_PREFIX = API_URL_PREFIX + "/rentals";

    private final BookClient bookClient;
    private final RentalService rentalService;


    /**
     *
     * @param userId
     * @param bookId
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws JsonProcessingException
     * @throws RentUnavailableException
     */
    @PostMapping("/{userId}/RentedItem/{book}")
    public ResponseEntity<RentalDTO> rentBooks(@PathVariable("userId") Long userId, @PathVariable("book") Long bookId)
            throws InterruptedException, ExecutionException, JsonProcessingException, RentUnavailableException {
        // 도서 서비스를 호출해 도서 정보 가져오기

        ResponseEntity<BookInfoDTO> bookInfoResult = bookClient.findBookInfo(bookId); // feign - 책 정보 가져오기
        BookInfoDTO bookInfoDTO = bookInfoResult.getBody();

        Rental rental = rentalService.rentBook(userId, bookInfoDTO.getId(), bookInfoDTO.getTitle());
        //RentalDTO rentalDTO = rentalMapper.toDto(rental);
        return ResponseEntity.ok().body(rentalDTO);
    }


    

}
