package moodtracker.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import moodtracker.entity.UserEntity;
import moodtracker.exception.UserNameAlreadyTakenException;
import moodtracker.exception.UserNotFoundException;
import moodtracker.model.*;
import moodtracker.repository.UserRepository;
import moodtracker.security.JwtUtil;
import moodtracker.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {

    JwtUtil jwtUtil;
    UserRepository userRepository;

    AuthenticationManager authManager;
    PasswordEncoder encoder;

    @Override
    public AuthResponse register(AuthRequest request) {
        validateUsername(request.getUsername());
        validateEmail(request.getEmail());

        UserEntity newUser = new UserEntity();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(encoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());

        userRepository.save(newUser);

        return new AuthResponse(request.getUsername());
    }

    private void validateUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new UserNameAlreadyTakenException("Username already in use");
        }
    }

    private void validateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new UserNameAlreadyTakenException("Email already in use");
        }
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User does not exist"));

        if (user.isBlocked())
            throw new RuntimeException("Account is blocked");

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String jwtToken = jwtUtil.generateToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);
        return new LoginResponse(jwtToken, refreshToken);
    }



    @Override
    public TokenResponse refreshToken(String refreshToken) {
        String username = jwtUtil.extractUsername(refreshToken);

        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!jwtUtil.validateToken(refreshToken, user)) {
            throw new RuntimeException("Invalid refresh token");
        }

        String newAccessToken = jwtUtil.generateToken(user);

        return new TokenResponse(newAccessToken);
    }
}
