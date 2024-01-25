package com.example.demobooking.application.service;
import java.util.List;

public interface BookingService<T> {
 //T objeto tipo genérico
    void save(T dto);
    T findById(Object id) throws Exception;
    List<T> findAll();
    void delete(Object id);
}
