package com.avg.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
public class Rating {

    private Long id;
    private int rating;
    private String feedback;
    private Long userId;
    private Long hotelId;

}
