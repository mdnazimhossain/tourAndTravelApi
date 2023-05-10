package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {

//    List<Booking> findByPackageId(Long Id);    // Package id name
}
