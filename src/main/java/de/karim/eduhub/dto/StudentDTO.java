package de.karim.eduhub.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    private List<String> enrolledCourseTitles;
}
