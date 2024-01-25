package com.example.demobooking.application.mapper;


import com.example.demobooking.domain.dto.BookingDto;
import com.example.demobooking.domain.entity.BookingMongo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapperMongo extends IBaseMapper{

    @Mapping(source = "id", target = "id", qualifiedByName = "objectToString")
    BookingMongo toEntity(BookingDto bookingDtodto);

    BookingDto toDto(BookingMongo bookingEntity);

    List<BookingMongo> toEntityList(List<BookingDto> dtoList);

    List<BookingDto> toDtoList(List<BookingMongo> entityList);
    @Named("objectToString")
    default String objectToString(Object obj) {
        return obj.toString();
    }
}
