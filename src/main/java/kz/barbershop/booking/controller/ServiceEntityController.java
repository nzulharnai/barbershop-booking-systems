package kz.barbershop.booking.controller;

import jakarta.validation.Valid;
import kz.barbershop.booking.dto.CreateRequest.ServiceCreateRequest;
import kz.barbershop.booking.dto.Response.ServiceResponse;
import kz.barbershop.booking.dto.UpdateRequest.ServiceUpdateRequest;
import kz.barbershop.booking.service.ServiceEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceEntityController {

    private final ServiceEntityService serviceEntityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceResponse create(@RequestBody @Valid ServiceCreateRequest request){
        return  serviceEntityService.create(request);
    }

    @GetMapping
    public List<ServiceResponse> getAll(){
        return serviceEntityService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceResponse getById(@PathVariable Long id){
        return serviceEntityService.getById(id);
    }

    @PutMapping("/{id}")
    public ServiceResponse update(@PathVariable Long id, @RequestBody @Valid ServiceUpdateRequest request){
        return serviceEntityService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        serviceEntityService.delete(id);
    }
}
