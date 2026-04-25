package kz.barbershop.booking.service.impl;

import kz.barbershop.booking.dto.CreateRequest.ServiceCreateRequest;
import kz.barbershop.booking.dto.Response.ServiceResponse;
import kz.barbershop.booking.dto.UpdateRequest.ServiceUpdateRequest;
import kz.barbershop.booking.entity.ServiceEntity;
import kz.barbershop.booking.exception.ResourceNotFoundException;
import kz.barbershop.booking.repository.ServiceEntityRepository;
import kz.barbershop.booking.service.ServiceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceEntityServiceImpl implements ServiceEntityService {

    private final ServiceEntityRepository serviceEntityRepository;

    @Override
    public ServiceResponse create(ServiceCreateRequest request) {
        ServiceEntity serviceEntity = ServiceEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .durationMinutes(request.getDurationMinutes())
                .build();
        return mapToResponce(serviceEntityRepository.save(serviceEntity));
    }

    @Override
    public List<ServiceResponse> getAll() {
        return serviceEntityRepository.findAll().stream().map(this::mapToResponce).toList();
    }

    @Override
    public ServiceResponse getById(Long id) {
        ServiceEntity service = serviceEntityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Service not found with id" + id)
        );
        return mapToResponce(service);
    }

    @Override
    public ServiceResponse update(Long id, ServiceUpdateRequest request) {
        ServiceEntity service = serviceEntityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Service not found with id" + id)
        );
        service.setName(request.getName());
        service.setPrice(request.getPrice());
        service.setActive(request.getActive());
        service.setDescription(request.getDescription());
        service.setDurationMinutes(request.getDurationMinutes());

        return mapToResponce(serviceEntityRepository.save(service));
    }

    @Override
    public void delete(Long id) {
        ServiceEntity service =  serviceEntityRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Service not found with id: " + id)
        );
        serviceEntityRepository.delete(service);
    }

    private ServiceResponse mapToResponce(ServiceEntity service){
        return ServiceResponse.builder()
                .id(service.getId())
                .name(service.getName())
                .durationMinutes(service.getDurationMinutes())
                .price(service.getPrice())
                .description(service.getDescription())
                .active(service.getActive())
                .build();
    }
}
