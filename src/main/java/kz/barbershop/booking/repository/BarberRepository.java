package kz.barbershop.booking.repository;

import kz.barbershop.booking.entity.Barber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends JpaRepository<Barber,Long> {
}
