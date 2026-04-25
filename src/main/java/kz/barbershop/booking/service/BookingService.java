package kz.barbershop.booking.service;

import kz.barbershop.booking.dto.CreateRequest.BookingCreateRequest;
import kz.barbershop.booking.dto.Response.BookingResponse;

import java.util.List;

public interface BookingService {
    BookingResponse create(BookingCreateRequest request);
    List<BookingResponse> getAll();
    BookingResponse getById(Long id);
    void delete(Long id);
}