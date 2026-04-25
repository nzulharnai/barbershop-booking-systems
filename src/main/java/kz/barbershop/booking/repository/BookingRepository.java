package kz.barbershop.booking.repository;

import kz.barbershop.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAllByBarberIdAndBookingDate(Long barberId, LocalDate bookingDate);
}
