package kz.barbershop.booking.controller;


import jakarta.validation.Valid;
import kz.barbershop.booking.dto.CreateRequest.BookingCreateRequest;
import kz.barbershop.booking.dto.Response.BookingResponse;
import kz.barbershop.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingResponse create(@RequestBody @Valid BookingCreateRequest request){
        return bookingService.create(request);
    }

    @GetMapping
    public List<BookingResponse> getAll(){
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public BookingResponse getById(@PathVariable Long id){
        return bookingService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        bookingService.delete(id);
    }
}


