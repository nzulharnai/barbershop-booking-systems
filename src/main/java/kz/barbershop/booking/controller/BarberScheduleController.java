package kz.barbershop.booking.controller;

import jakarta.validation.Valid;
import kz.barbershop.booking.dto.CreateRequest.BarberScheduleCreateRequest;
import kz.barbershop.booking.dto.Response.BarberScheduleResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberScheduleUpdateRequest;
import kz.barbershop.booking.service.BarberScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class BarberScheduleController {

    private final BarberScheduleService barberScheduleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BarberScheduleResponse create(@RequestBody @Valid BarberScheduleCreateRequest request) {
        return barberScheduleService.create(request);
    }

    @GetMapping
    public List<BarberScheduleResponse> getAll() {
        return barberScheduleService.getAll();
    }

    @GetMapping("/{id}")
    public BarberScheduleResponse getById(@PathVariable Long id) {
        return barberScheduleService.getById(id);
    }

    @PutMapping("/{id}")
    public BarberScheduleResponse update(@PathVariable Long id,
                                         @RequestBody @Valid BarberScheduleUpdateRequest request) {
        return barberScheduleService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        barberScheduleService.delete(id);
    }
}