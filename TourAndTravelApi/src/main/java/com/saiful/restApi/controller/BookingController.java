package com.saiful.restApi.controller;

import com.saiful.restApi.dtos.BookingDTO;
import com.saiful.restApi.entity.Booking;
import com.saiful.restApi.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class BookingController {
    @Autowired
    BookingService bookingService;



//    @GetMapping
//    public List<Booking> getBookingsByPackageId(@PathVariable Long Id) {
//        return bookingService.getBookingsByPackageId(packageId);
//    }
    @PostMapping("/booking")
    public void save(@RequestBody BookingDTO bookingDTO){
        if (bookingDTO != null){
            Booking booking = new Booking();
            BeanUtils.copyProperties(bookingDTO, booking);
            bookingService.save(booking);
        }
    }
    @PutMapping("/booking")
    public void update( @RequestBody BookingDTO bookingDTO){
        if (bookingDTO != null){
            Booking booking = new Booking();
            BeanUtils.copyProperties(bookingDTO, booking);
            bookingService.save(booking);
        }
    }
    @GetMapping("/booking")
    List<BookingDTO> all() {
        List<Booking> bookings = bookingService.findAll();
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        for (Booking booking : bookings
        ) {
            BookingDTO bookingDTO = new BookingDTO();

            booking.getCustomer().setBooking(null);                        //booking.getCustomer().setBooking(null);  for relation  write by sir
            booking.getHajjPackage().setBooking(null);                         //booking.getCustomer().setBooking(null);  for relation  write by sir
            BeanUtils.copyProperties(booking, bookingDTO);
            bookingDTOList.add(bookingDTO);
        }
        return bookingDTOList;
    }
    @DeleteMapping("/booking/{id}")
    public void delete(@PathVariable("id") Long id){
        bookingService.delete(id);
    }


    @GetMapping("/booking/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        Booking booking;
        booking = bookingService.getById(id);
        if (booking.getId() != null){

            booking.getCustomer().setBooking(null);                        //booking.getCustomer().setBooking(null);  for relation  write by sir
            booking.getHajjPackage().setBooking(null);                       //booking.getCustomer().setBooking(null);  for relation  write by sir
            BookingDTO bookingDTO = new BookingDTO();
            BeanUtils.copyProperties(booking, bookingDTO);
            return ResponseEntity.status(HttpStatus.OK).body(bookingDTO);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data Not Found!!");
//        return new ResponseEntity("Hello World", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
