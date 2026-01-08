package com.Manu.SpringBoot.service;


import com.Manu.SpringBoot.dto.LoginRequest;
import com.Manu.SpringBoot.dto.SignupRequest;
import com.Manu.SpringBoot.entity.User;
import com.Manu.SpringBoot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public String signup(SignupRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "User already exists";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword()) // plain text (as requested)
                .build();

        userRepository.save(user);
        return "Signup successful";
    }

    public String login(LoginRequest request) {

        return userRepository.findByEmail(request.getEmail())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> "Login successful")
                .orElse("Invalid email or password");
    }
}
