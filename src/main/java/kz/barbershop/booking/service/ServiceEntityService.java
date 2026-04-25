package kz.barbershop.booking.service;

import kz.barbershop.booking.dto.CreateRequest.ServiceCreateRequest;
import kz.barbershop.booking.dto.Response.ServiceResponse;
import kz.barbershop.booking.dto.UpdateRequest.ServiceUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceEntityService {

    ServiceResponse create(ServiceCreateRequest request);
    List<ServiceResponse> getAll();
    ServiceResponse getById(Long id);
    ServiceResponse update(Long id, ServiceUpdateRequest request);
    void delete(Long id);
}
