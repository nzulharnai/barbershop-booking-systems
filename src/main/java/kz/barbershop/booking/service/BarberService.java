package kz.barbershop.booking.service;

import kz.barbershop.booking.dto.CreateRequest.BarberCreateRequest;
import kz.barbershop.booking.dto.Response.BarberResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BarberService {

    BarberResponse create(BarberCreateRequest request);

    List<BarberResponse> getAll();

    BarberResponse getByid(Long id);

    BarberResponse update(Long id, BarberUpdateRequest request);

    void delete(Long id);
}