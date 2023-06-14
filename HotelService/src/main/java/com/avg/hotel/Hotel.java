package com.avg.hotel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "microservice_hotel", name = "hotel")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String about;
}
