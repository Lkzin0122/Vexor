package com.vexor.api.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

public class AuthDtos {

    public record FirebaseLoginRequest(@NotBlank String firebaseToken) {}

    public record UsernameSetupRequest(@NotBlank String username) {}

    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    public static class AuthResponse {
        private String accessToken;
        private String tokenType = "Bearer";
        private long expiresIn;
        private String userId;
        private String email;
        private String name;
        private String username;
        private boolean isNewUser;
    }

    @Data @Builder @NoArgsConstructor @AllArgsConstructor
    public static class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;
        private String error;

        public static <T> ApiResponse<T> ok(String message, T data) {
            return ApiResponse.<T>builder().success(true).message(message).data(data).build();
        }

        public static <T> ApiResponse<T> error(String message, String error) {
            return ApiResponse.<T>builder().success(false).message(message).error(error).build();
        }
    }
}
