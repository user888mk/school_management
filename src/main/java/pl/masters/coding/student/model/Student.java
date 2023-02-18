package pl.masters.coding.student.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String language;

}