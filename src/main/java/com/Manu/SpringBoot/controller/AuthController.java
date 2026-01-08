package com.Manu.SpringBoot.controller;

import com.Manu.SpringBoot.dto.LoginRequest;
import com.Manu.SpringBoot.dto.SignupRequest;
import com.Manu.SpringBoot.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}

