package com.example.demobooking.domain.repository;

import com.example.demobooking.domain.entity.BookingMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMongoRepository extends MongoRepository<BookingMongo, String> {
}
