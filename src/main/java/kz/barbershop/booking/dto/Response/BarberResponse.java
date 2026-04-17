package kz.barbershop.booking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BarberResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String specialization;
    private Boolean active;
}
