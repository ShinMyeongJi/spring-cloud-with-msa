package com.shinmj.rentalservice.service.impl;

import com.shinmj.rentalservice.domain.Rental;
import com.shinmj.rentalservice.repository.RentalRepository;
import com.shinmj.rentalservice.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {


    private final RentalRepository rentalRepository;


    @Override
    public Rental rentBook(Long userId, Long bookId, String bookTitle) {

        Rental rental = rentalRepository.findById(userId).get(); // (1) Rental 조회
        rental.checkRentalAvailable(); // (2) 대출 가능 여부 조회
        rental = rental.rentBook(userId, bookTitle); // (3) 대출 처리(Rental 에게 대출 처리 위임)
        rentalRepository.save(rental); // (4) Rental 저장

        // (5) 도서 서비스에 도서 재고 감소를 위한 도서대출 이벤트 발송
        //rentalProducer.updateBookStatus(bookId, "UNAVALIABLE");

        // (6) 도서 카탈로그 서비스에 대출된 도서로 상태를 변경하기 위한 이벤트 발송
        //rentalProducer.updateBookCatalog(bookId, "RENT_BOOK");

        // (7) 대출로 사용자 포인트 적립을 위해 사용자 서비스에 이벤트 발송
        //rentalProducer.savePoints(userId);

        /**
         * 외부 마이크로 서비스로 이벤트를 전송할 때는 의존성을 낮추기 위해 비동기로 호출하는데, 비동기 이벤트를 처리하기 위해 아웃바운드 어댑터를 호출한다.
         * 여기서 아웃바운드 어댑터 클래스를 직접 호출하지 않고 아웃바운드 어댑터의 행위가 추상화된 인터페이스 클래스에 의존한다는 점에 주목하자.
         */
        return rental;
    }
}
