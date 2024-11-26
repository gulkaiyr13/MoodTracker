package moodtracker.service;

import moodtracker.model.*;

public interface AuthService {
    AuthResponse register(AuthRequest registerRequest);

    LoginResponse login(LoginRequest request);

    TokenResponse refreshToken(String refreshToken);
}
