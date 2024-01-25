package com.example.demobooking.application.service;
import com.example.demobooking.application.mapper.BookingMapperPostgres;
import com.example.demobooking.domain.dto.BookingDto;
import com.example.demobooking.domain.entity.Booking;
import com.example.demobooking.domain.repository.BookingSqlRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookingSqlService implements BookingService<BookingDto> {

    private  final  BookingSqlRepository bookingSqlRepository;
    private final BookingMapperPostgres mapper;

    public BookingSqlService(BookingSqlRepository bookingSqlRepository, BookingMapperPostgres mapper) {
        this.bookingSqlRepository = bookingSqlRepository;
        this.mapper = mapper;
    }


    @Override
    public void save(BookingDto dto) {
        Booking booking = mapper.toEntity(dto);
        bookingSqlRepository.save(booking);
    }

    @Override
    public BookingDto findById(Object id) throws Exception {
        Booking booking = bookingSqlRepository.findById(Long.valueOf(id.toString()))
                .orElseThrow(() -> new Exception("No found booking: " + id));
        return mapper.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingSqlRepository.findAll();
        return mapper.toDtoList(bookings);
    }

    @Override
    public void delete(Object id) {
        bookingSqlRepository.deleteById(Long.valueOf(id.toString()));
    }
}
