package kz.barbershop.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "barbaershedule")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BarberShedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    private LocalDate workDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private Boolean isWorkingDay;

}
