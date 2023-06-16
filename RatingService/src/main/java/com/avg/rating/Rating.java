package com.avg.rating;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document("user_ratings")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    private String id;

    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedback;

}
