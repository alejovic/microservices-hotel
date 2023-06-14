package com.avg.user;

import com.avg.validation.AdvanceInfo;
import com.avg.validation.BasicInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @NotBlank(groups = BasicInfo.class)
    private String name;
    @NotBlank(groups = BasicInfo.class)
    @Email(message = "Email is not valid.", groups = BasicInfo.class)
    private String email;
    @Column(length = 100)
    @NotBlank(groups = AdvanceInfo.class)
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
