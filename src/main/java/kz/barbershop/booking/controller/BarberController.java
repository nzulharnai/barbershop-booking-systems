package kz.barbershop.booking.controller;

import jakarta.validation.Valid;
import kz.barbershop.booking.dto.CreateRequest.BarberCreateRequest;
import kz.barbershop.booking.dto.Response.BarberResponse;
import kz.barbershop.booking.dto.UpdateRequest.BarberUpdateRequest;
import kz.barbershop.booking.service.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/barber")
public class BarberController {

    private final BarberService barberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BarberResponse create(@RequestBody @Valid BarberCreateRequest request){
        return create(request);
    }

    @GetMapping
    public List<BarberResponse> getAll(){
        return barberService.getAll();
    }

    @GetMapping("/{id}")
    public BarberResponse getByid(@PathVariable Long id){
        return barberService.getByid(id);
    }

    @PutMapping("/{id}")
    public BarberResponse update(@PathVariable Long id , @RequestBody @Valid BarberUpdateRequest request){
        return barberService.update(id, request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        barberService.delete(id);
    }
}
