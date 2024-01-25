package com.example.demobooking.application.controller;
import com.example.demobooking.application.service.BookingService;
import com.example.demobooking.application.service.BookingSqlService;
import com.example.demobooking.domain.dto.BookingDto;
import com.example.demobooking.domain.entity.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public record BookingController(
        BookingService<BookingDto> bookingService
) {

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody BookingDto bookingDto) {
        bookingService.save(bookingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<?> searchAll() {
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") Long id){
        bookingService.delete(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> searchBooking(@PathVariable ("id") Long id) throws Exception {
        bookingService.findById(id.toString());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
