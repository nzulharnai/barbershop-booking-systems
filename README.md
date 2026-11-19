# 💈 Barbershop Booking System

REST API for online barbershop booking: clients choose a barber, a service, a date and a time slot, and the system checks that the slot is really free.

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_4-6DB33F?style=flat&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat&logo=springsecurity&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=flat&logo=flyway&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white)

## Features

- **Booking rules** — checks the barber's working schedule, calculates the end time from the service duration and rejects overlapping appointments (canceled bookings are ignored)
- **Data model** — `User`, `Barber`, `ServiceEntity`, `BarberSchedule`, `Booking` with JPA relations
- **Layered architecture** — Controller → Service (interfaces + implementations) → Repository, request/response DTOs, Bean Validation
- **Error handling** — global exception handler with clear `404` responses
- **Auth** — registration and login with BCrypt password hashing; JWT authentication with Spring Security *(in progress)*
- **Migrations** — database schema managed with Flyway

## API

| Resource | Endpoints |
|---|---|
| Auth | `/api/authorization/register`, `/api/authorization/login` |
| Barbers | `POST/GET /barber`, `GET/PUT/DELETE /barber/{id}` |
| Services | `POST/GET /service`, `GET/PUT/DELETE /service/{id}` |
| Schedules | `POST/GET /api/schedules`, `GET/PUT/DELETE /api/schedules/{id}` |
| Bookings | `POST/GET /api/bookings`, `GET/DELETE /api/bookings/{id}` |

## Run locally

Requirements: JDK 17+, PostgreSQL.

1. Create a database named `BookingForBarberShop`.
2. Set your database credentials in `src/main/resources/application.properties`.
3. Start the app:

```bash
./gradlew bootRun
```

The API runs on `http://localhost:8080`.

## Project structure

```
src/main/java/kz/barbershop/booking
├── controller   # REST controllers
├── dto          # request / response DTOs
├── entity       # JPA entities and enums
├── exception    # global exception handling
├── repository   # Spring Data JPA repositories
├── security     # JWT service, security config
└── service      # business logic (interfaces + impl)
```

## Author

**Nurasyl Zulkharnaev** — [GitHub](https://github.com/nzulharnai) · [LinkedIn](https://linkedin.com/in/nurasyl-zulkharnaev) · [Telegram](https://t.me/nzulharnai)
