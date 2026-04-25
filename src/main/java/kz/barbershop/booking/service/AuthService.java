package kz.barbershop.booking.service;

import kz.barbershop.booking.dto.LoginRequest;
import kz.barbershop.booking.dto.RegisterRequest;
import kz.barbershop.booking.dto.Response.AuthResponse;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
