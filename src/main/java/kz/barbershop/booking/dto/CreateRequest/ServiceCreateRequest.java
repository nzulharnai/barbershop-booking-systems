package kz.barbershop.booking.dto.CreateRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ServiceCreateRequest {

    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0" , inclusive = false,message = "price must greater than 0")
    private BigDecimal price;

    @NotNull(message = "duration is required")
    @Min(value = 1,message = "Duration must at least 1 minute")
    private Integer durationMinutes;
}
