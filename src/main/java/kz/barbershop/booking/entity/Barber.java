package kz.barbershop.booking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "barbers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;

    private String phone;

    private String specialization;

    private Boolean active;

    @OneToMany(mappedBy = "barber")
    private List<Booking> bookings;

}
