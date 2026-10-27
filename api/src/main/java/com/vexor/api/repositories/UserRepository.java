package com.vexor.api.repositories;

import com.vexor.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Optional<User> findByFirebaseUid(String firebaseUid);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
