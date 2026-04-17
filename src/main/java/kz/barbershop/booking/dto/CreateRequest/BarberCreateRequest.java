package kz.barbershop.booking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarberCreateRequest {

    private String fullName;

    private String phone;

    private String specialization;

    public Boolean active;
}
