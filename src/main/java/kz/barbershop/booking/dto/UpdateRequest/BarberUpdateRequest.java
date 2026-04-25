package kz.barbershop.booking.dto.UpdateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarberUpdateRequest {

    private String fullName;

    private String phone;

    private String specialization;

    private Boolean active;

}
