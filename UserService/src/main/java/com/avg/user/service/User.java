package com.avg.user.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "micro_users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20)
    @NonNull
    private String name;
    @NonNull
    @Email
    private String email;
    @Column(length = 100)
    private String about;

}
