package kz.barbershop.booking.service.impl;

import kz.barbershop.booking.dto.CreateRequest.BarberScheduleCreateRequest;
import kz.barbershop.booking.dto.Response.BarberScheduleResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberScheduleUpdateRequest;
import kz.barbershop.booking.entity.Barber;
import kz.barbershop.booking.entity.BarberSchedule;
import kz.barbershop.booking.exception.ResourceNotFoundException;
import kz.barbershop.booking.repository.BarberRepository;
import kz.barbershop.booking.repository.BarberScheduleRepository;
import kz.barbershop.booking.service.BarberScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarberScheduleImpl implements BarberScheduleService {

    private final BarberScheduleRepository barberScheduleRepository;
    private final BarberRepository barberRepository;

    public BarberScheduleResponse create(BarberScheduleCreateRequest request){
        Barber barber = barberRepository.findById(request.getBarberId())
                .orElseThrow(() -> new ResourceNotFoundException("Barber not found with id: " + request.getBarberId()));

        BarberSchedule barberSchedule = BarberSchedule.builder()
                .barber(barber)
                .workDate(request.getWorkDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .isWorkingDay(request.getIsWorkingDay())
                .build();

        return mapToResponse(barberScheduleRepository.save(barberSchedule));
    }

    public List<BarberScheduleResponse> getAll(){
        return barberScheduleRepository.findAll().
                stream().map(this::mapToResponse).toList();
    }

    public BarberScheduleResponse getById(Long id){
        BarberSchedule barberSchedule = barberScheduleRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Schedule not found with id: " + id));

        return mapToResponse(barberSchedule);
    }

    public BarberScheduleResponse update(Long id ,BarberScheduleUpdateRequest request){

        BarberSchedule barberSchedule = barberScheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));

        Barber barber = barberRepository.findById(request.getBarberId())
                .orElseThrow(() -> new ResourceNotFoundException("Barber not found with id: " + request.getBarberId()));

        barberSchedule.setBarber(barber);
        barberSchedule.setWorkDate(request.getWorkDate());
        barberSchedule.setStartTime(request.getStartTime());
        barberSchedule.setEndTime(request.getEndTime());
        barberSchedule.setIsWorkingDay(request.getIsWorkingDay());

        return mapToResponse(barberScheduleRepository.save(barberSchedule));

    }

    public void delete(Long id){
        BarberSchedule barberSchedule = barberScheduleRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Schedule not found with id: " + id));

        barberScheduleRepository.delete(barberSchedule);
    }

    private BarberScheduleResponse mapToResponse(BarberSchedule barberSchedule){
        return BarberScheduleResponse.builder()
                .id(barberSchedule.getId())
                .barberId(barberSchedule.getBarber().getId())
                .barberName(barberSchedule.getBarber().getFullName())
                .workDate(barberSchedule.getWorkDate())
                .startTime(barberSchedule.getStartTime())
                .endTime(barberSchedule.getEndTime())
                .isWorkingDay(barberSchedule.getIsWorkingDay())
                .build();
    }
}
