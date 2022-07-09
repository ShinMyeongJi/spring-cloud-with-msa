package com.shinmj.rentalservice.domain;


import com.shinmj.rentalservice.exception.RentUnavailableException;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Rental 에그리거트 루트, 엔티티 클래스
 * 도서 대출 및 반납의 책임은 Rental 클래스에 있다.
 */
@Data
@Entity
@Table(name = "rental")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Rental implements Serializable {

    // Rental 일련 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 일련 번호(사용자가 생성될 때 마다 부여되는 고유 id)
    @Column(name = "user_id")
    private Long userId;

    // 연체료
    @Column(name = "late_fee")
    private Long lateFee;

    // 대출 가능 여부
    @Column(name = "rental_status")
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;

    // 대출 아이템
    // orphanRemoval : Rental에서 리스트 객체가 삭제될 때 마다 해당 리스트의 엔티티가 삭제 되야하기 때문에 ㅇ
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<RentedItem> rentedItems = new HashSet<>();

    // 연체 아이템
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OverdueItem> overdueItems = new HashSet<>();

    // 반납 아이템
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReturnedItem> returnedItems = new HashSet<>();

    // Rental 엔티티 생성
    public static Rental createRental(Long userId) {
        Rental rental = new Rental();

        rental.setId(userId);
        rental.setRentalStatus(RentalStatus.RENTAL_AVALIABLE);
        rental.setLateFee(0l);

        return rental;
    }

    // 대출 가능 여부 체크
    public boolean checkRentalAvailable() {
        if (this.rentalStatus.equals(RentalStatus.RENTAL_UNAVALIABLE) || this.getLateFee() != 0) {
            throw new RentUnavailableException("연체 상태 입니다. 연체료를 정산 후, 도서를 대출하실 수 있습니다.");
        }

        if (this.getRentedItems().size() >= 5) {
            throw new RentUnavailableException("대출 가능한 도서 수는 " + (5-this.getRentedItems().size()) + "입니다.");
        }

        return true;
    }

    public Rental addRentalItem(RentedItem rentedItem) {
        this.rentedItems.add(rentedItem);
        rentedItem.setRental(this); // <- 굳이 왜..?

        return this;
    }


    // 대출 처리 메서드
    public Rental rentBook(Long bookId, String title) {
        this.addRentalItem(RentedItem.createRentedItem(bookId, title, LocalDate.now()));
        return this;
    }


}
