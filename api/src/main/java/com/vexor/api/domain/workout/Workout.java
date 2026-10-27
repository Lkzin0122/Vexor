package com.vexor.api.domain.workout;

import com.vexor.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "workouts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String category;
    @Column(columnDefinition = "text")
    private String notes;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
