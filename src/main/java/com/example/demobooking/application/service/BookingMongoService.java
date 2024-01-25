package com.example.demobooking.application.service;

import com.example.demobooking.application.mapper.BookingMapperMongo;
import com.example.demobooking.domain.dto.BookingDto;
import com.example.demobooking.domain.entity.BookingMongo;
import com.example.demobooking.domain.repository.BookingMongoRepository;

import java.util.List;

public class BookingMongoService implements BookingService<BookingDto> {

    private final BookingMongoRepository bookingMongoRepository;
    private final BookingMapperMongo mapper;

    public BookingMongoService(BookingMongoRepository bookingMongoRepository, BookingMapperMongo mapper) {
        this.bookingMongoRepository = bookingMongoRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(BookingDto dto) {
        BookingMongo booking = mapper.toEntity(dto);
        bookingMongoRepository.save(booking);
    }

    @Override
    public BookingDto findById(Object id) throws Exception {
        BookingMongo booking = bookingMongoRepository.findById(id.toString())
                .orElseThrow(() -> new Exception("No found booking: " + id));
        return mapper.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        List<BookingMongo> bookings = bookingMongoRepository.findAll();
        return mapper.toDtoList(bookings);
    }

    @Override
    public void delete(Object id) {
        bookingMongoRepository.deleteById(id.toString());
    }
}
