package kz.barbershop.booking.dto.CreateRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BarberScheduleCreateRequest {

    @NotNull(message = "Barber id is required")
    private Long barberId;

    @NotNull(message = "Work date is required")
    private LocalDate workDate;

    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @NotNull(message = "Working day flag is required")
    private Boolean isWorkingDay;

}