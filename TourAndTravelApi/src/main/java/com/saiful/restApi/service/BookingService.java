package com.saiful.restApi.service;


import com.saiful.restApi.entity.Booking;
import com.saiful.restApi.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

//    public List<Booking> getBookingsByPackageId(Long packageId) {
//        return bookingRepo.findByPackageId(Id); // package id
//    }
    public List<Booking> findAll() {

        return bookingRepo.findAll();
    }

    public void save(Booking bookingNew) {
        if (bookingNew.getId()!= null){
            bookingRepo.findById(bookingNew.getId())
                    .map(old -> {
//  private String Date;
//    private String details;
//    private String bookedBy;
//    private String billing;
//    private String status;

                        old.setDate(bookingNew.getDate());
                        old.setDetails(bookingNew.getDetails());
                        old.setBookedBy(bookingNew.getBookedBy());
                        old.setBilling(bookingNew.getBilling());
                        old.setStatus(bookingNew.getStatus());

                        return bookingRepo.save(old);
                    })
                    .orElseGet(() -> {
                        return bookingRepo.save(bookingNew);
                    });
        }else {
            bookingRepo.save(bookingNew);
        }
    }

    public Booking getById(Long id) {
       return bookingRepo.findById(id).orElse(new Booking());
    }

    public void delete(Long id) {
         bookingRepo.deleteById(id);
    }

}
