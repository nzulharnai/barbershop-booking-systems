package kz.barbershop.booking.dto.CreateRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BookingCreateRequest {

    @NotNull(message = "User id is required")
    private Long userId;

    @NotNull(message = "Barber id is required")
    private Long barberId;

    @NotNull(message = "Service id is required")
    private Long serviceId;

    @NotNull(message = "Booking date is required")
    private LocalDate bookingDate;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    private String comment;


}
