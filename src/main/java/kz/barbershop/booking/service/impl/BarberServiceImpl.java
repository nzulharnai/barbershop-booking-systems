package kz.barbershop.booking.service.impl;

import kz.barbershop.booking.dto.CreateRequest.BarberCreateRequest;
import kz.barbershop.booking.dto.Response.BarberResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberUpdateRequest;
import kz.barbershop.booking.entity.Barber;
import kz.barbershop.booking.exception.ResourceNotFoundException;
import kz.barbershop.booking.repository.BarberRepository;
import kz.barbershop.booking.service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Override
    public BarberResponse create(BarberCreateRequest request) {
        Barber barber = Barber.builder()
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .specialization(request.getSpecialization())
                .active(true)
                .build();

        return mapToResponse(barberRepository.save(barber));
    }

    @Override
    public List<BarberResponse> getAll() {
        return barberRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public BarberResponse getByid(Long id) {
        Barber barber = barberRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Barber not found with id" + id)
        );
        return mapToResponse(barber);
    }

    @Override
    public BarberResponse update(Long id, BarberUpdateRequest request) {
        Barber barber = barberRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Barber not found with id: " + id)
        );
        barber.setFullName(request.getFullName());
        barber.setPhone(request.getPhone());
        barber.setSpecialization(request.getSpecialization());
        barber.setActive(request.getActive());
        return mapToResponse(barberRepository.save(barber));
    }

    @Override
    public void delete(Long id) {
        Barber barber = barberRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Barber not found with id: " + id)
        );
        barberRepository.delete(barber);
    }

    private BarberResponse mapToResponse(Barber barber) {
        return BarberResponse.builder()
                .id(barber.getId())
                .fullName(barber.getFullName())
                .phone(barber.getPhone())
                .specialization(barber.getSpecialization())
                .active(barber.getActive())
                .build();
    }
}
