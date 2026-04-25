package kz.barbershop.booking.controller;

import jakarta.validation.Valid;
import kz.barbershop.booking.dto.LoginRequest;
import kz.barbershop.booking.dto.RegisterRequest;
import kz.barbershop.booking.dto.Response.AuthResponse;
import kz.barbershop.booking.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authorization")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/register")
    public AuthResponse register(@RequestBody @Valid RegisterRequest request){
        return authService.register(request);
    }

    @GetMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequest request){
        return authService.login(request);
    }
}
