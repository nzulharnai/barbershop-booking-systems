package kz.barbershop.booking.service;


import kz.barbershop.booking.dto.CreateRequest.BarberScheduleCreateRequest;
import kz.barbershop.booking.dto.Response.BarberScheduleResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberScheduleUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BarberScheduleService {
    BarberScheduleResponse create(BarberScheduleCreateRequest request);
    List<BarberScheduleResponse> getAll();
    BarberScheduleResponse getById(Long id);
    BarberScheduleResponse update(Long id, BarberScheduleUpdateRequest request);
    void delete(Long id);
}
