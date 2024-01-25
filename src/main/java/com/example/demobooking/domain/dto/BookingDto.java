package com.example.demobooking.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL) //Para que no acepte nulos o los excluya en el procesamiento de Json.
public record BookingDto(
            Object id, //id diferente tipo de variable en Postgresql y mongo
            String name,
            String email,
            String origin,
            String destination,
            LocalDate departureDate,
            LocalTime departureTime,
            Duration duration

) {
}
