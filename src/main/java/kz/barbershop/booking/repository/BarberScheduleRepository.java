package kz.barbershop.booking.repository;

import kz.barbershop.booking.entity.BarberSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BarberScheduleRepository extends JpaRepository<BarberSchedule,Long> {

    Optional<BarberSchedule> findByBarberIdAndWorkDate(Long barberId, LocalDate workDate);

}
