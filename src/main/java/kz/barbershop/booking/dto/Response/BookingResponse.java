package kz.barbershop.booking.dto.Response;

import kz.barbershop.booking.entity.Enum.BookingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class BookingResponse {

    private Long id;
    private Long userId;
    private String userName;

    private Long barberId;
    private String barberName;

    private Long serviceId;
    private String serviceName;

    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    private BookingStatus status;
    private String comment;
}