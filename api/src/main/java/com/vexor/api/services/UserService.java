package com.vexor.api.services;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.vexor.api.domain.user.User;
import com.vexor.api.dtos.AuthDtos;
import com.vexor.api.repositories.UserRepository;
import com.vexor.api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthDtos.AuthResponse firebaseLogin(String firebaseToken) throws Exception {
        FirebaseToken decoded = FirebaseAuth.getInstance().verifyIdToken(firebaseToken);

        String uid = decoded.getUid();
        String email = decoded.getEmail();
        String name = decoded.getName() != null ? decoded.getName() : email;

        boolean isNewUser = !userRepository.findByFirebaseUid(uid).isPresent();

        User user = userRepository.findByFirebaseUid(uid).orElseGet(() -> {
            User newUser = new User();
            newUser.setFirebaseUid(uid);
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setCreatedAt(LocalDateTime.now());
            return userRepository.save(newUser);
        });

        String token = jwtService.generateToken(user.getId().toString());

        return AuthDtos.AuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn(86400000L)
                .userId(user.getId().toString())
                .email(user.getEmail())
                .name(user.getName())
                .username(user.getUsername())
                .isNewUser(isNewUser)
                .build();
    }

    public AuthDtos.AuthResponse setUsername(String userId, String username) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already taken.");
        }
        User user = userRepository.findById(java.util.UUID.fromString(userId))
                .orElseThrow(() -> new IllegalArgumentException("User not found."));
        user.setUsername(username);
        userRepository.save(user);

        String token = jwtService.generateToken(user.getId().toString());
        return AuthDtos.AuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn(86400000L)
                .userId(user.getId().toString())
                .email(user.getEmail())
                .name(user.getName())
                .username(user.getUsername())
                .isNewUser(false)
                .build();
    }

    public boolean validateToken(String token) {
        return jwtService.isValid(token);
    }
}
