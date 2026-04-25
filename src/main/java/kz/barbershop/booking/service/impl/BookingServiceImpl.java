package kz.barbershop.booking.service.impl;

import kz.barbershop.booking.dto.CreateRequest.BookingCreateRequest;
import kz.barbershop.booking.dto.Response.BookingResponse;
import kz.barbershop.booking.entity.*;
import kz.barbershop.booking.entity.Enum.BookingStatus;
import kz.barbershop.booking.exception.ResourceNotFoundException;
import kz.barbershop.booking.repository.*;
import kz.barbershop.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final BarberRepository barberRepository;
    private final ServiceEntityRepository serviceEntityRepository;
    private final BarberScheduleRepository barberScheduleRepository;


    public BookingResponse create(BookingCreateRequest request) {

        User user = userRepository.findById(request.getUserId()).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id:" + request.getUserId()));

        Barber barber = barberRepository.findById(request.getBarberId()).orElseThrow(
                () -> new ResourceNotFoundException("Barber not found with id:" + request.getBarberId())
        );

        ServiceEntity serviceEntity = serviceEntityRepository.findById(request.getServiceId()).orElseThrow(
                () -> new ResourceNotFoundException("Service not found with id:" + request.getServiceId())
        );

        BarberSchedule barberSchedule = barberScheduleRepository.findByBarberIdAndWorkDate(
                request.getBarberId(),
                request.getBookingDate()
        ).orElseThrow(() -> new ResourceNotFoundException("Barber schedule not found for this date"));

        if (!barberSchedule.getIsWorkingDay()) {
            throw new IllegalArgumentException("Barber is not working on this date");
        }

        LocalTime startTime = request.getStartTime();
        LocalTime endTime = startTime.plusMinutes(serviceEntity.getDurationMinutes());

        if (startTime.isBefore(barberSchedule.getStartTime()) || endTime.isAfter(barberSchedule.getEndTime())) {
            throw new IllegalArgumentException("Selected time is outside barber working hours");
        }

        List<Booking> existingBookings = bookingRepository.findAllByBarberIdAndBookingDate(
                barber.getId(),
                request.getBookingDate()
        );

        for (Booking existingBooking : existingBookings) {
            if (existingBooking.getStatus() == BookingStatus.CANCELED) {
                continue;
            }

            boolean overlaps = startTime.isBefore(existingBooking.getEndTime()) &&
                    endTime.isAfter(existingBooking.getStartTime());


            if (overlaps) {
                throw new IllegalArgumentException("Selected time slot is already booked");
            }
        }

            Booking booking = Booking.builder()
                    .user(user)
                    .barber(barber)
                    .service(serviceEntity)
                    .bookingDate(request.getBookingDate())
                    .startTime(startTime)
                    .endTime(endTime)
                    .status(BookingStatus.PENDING)
                    .comment(request.getComment())
                    .createdAt(LocalDateTime.now())
                    .build();

        return mapToResponse(bookingRepository.save(booking));
    }

    public List<BookingResponse> getAll(){
        return bookingRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public BookingResponse getById(Long id){
        Booking booking = bookingRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Booking is not found with this id: " + id));

        return mapToResponse(booking);
    }

    @Override
    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Booking is not found with this id: " + id)
        );
        bookingRepository.delete(booking);
    }

    private BookingResponse mapToResponse(Booking booking) {
        return BookingResponse.builder()
                .id(booking.getId())
                .userId(booking.getUser().getId())
                .userName(booking.getUser().getFullName())
                .barberId(booking.getBarber().getId())
                .barberName(booking.getBarber().getFullName())
                .serviceId(booking.getService().getId())
                .serviceName(booking.getService().getName())
                .bookingDate(booking.getBookingDate())
                .startTime(booking.getStartTime())
                .endTime(booking.getEndTime())
                .status(booking.getStatus())
                .comment(booking.getComment())
                .build();
    }
}
