package com.vexor.api.controllers;

import com.vexor.api.domain.user.User;
import com.vexor.api.dtos.AuthDtos;
import com.vexor.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/firebase/login")
    public ResponseEntity<AuthDtos.ApiResponse<AuthDtos.AuthResponse>> firebaseLogin(
            @RequestBody AuthDtos.FirebaseLoginRequest request) {
        try {
            AuthDtos.AuthResponse response = userService.firebaseLogin(request.firebaseToken());
            return ResponseEntity.ok(AuthDtos.ApiResponse.ok("Login successful", response));
        } catch (Exception e) {
            return ResponseEntity.status(401)
                    .body(AuthDtos.ApiResponse.error("Authentication failed", e.getMessage()));
        }
    }

    @PostMapping("/username")
    public ResponseEntity<AuthDtos.ApiResponse<AuthDtos.AuthResponse>> setUsername(
            @AuthenticationPrincipal User user,
            @RequestBody AuthDtos.UsernameSetupRequest request) {
        try {
            AuthDtos.AuthResponse response = userService.setUsername(user.getId().toString(), request.username());
            return ResponseEntity.ok(AuthDtos.ApiResponse.ok("Username set successfully", response));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(AuthDtos.ApiResponse.error("Invalid request", e.getMessage()));
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<AuthDtos.ApiResponse<Boolean>> validate(
            @RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        boolean valid = userService.validateToken(token);
        return ResponseEntity.ok(AuthDtos.ApiResponse.ok("Token validated", valid));
    }
}
