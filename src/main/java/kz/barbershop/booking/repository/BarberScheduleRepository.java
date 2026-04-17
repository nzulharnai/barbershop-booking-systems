package kz.barbershop.booking.repository;

import jakarta.persistence.Id;
import kz.barbershop.booking.entity.BarberShedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberSheduleRepository extends JpaRepository<BarberShedule,Long> {
}
