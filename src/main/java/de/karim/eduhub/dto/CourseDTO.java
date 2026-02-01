package de.karim.eduhub.dto;

import lombok.*;

/**
 * Data Transfer Object for Course entity.
 * This is what the client (Frontend) will see.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Integer durationHours;
}
