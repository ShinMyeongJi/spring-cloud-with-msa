package com.shinmj.rentalservice.repository;


import com.shinmj.rentalservice.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}
