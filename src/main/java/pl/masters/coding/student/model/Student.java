package pl.masters.coding.student.model;

import lombok.*;
import pl.masters.coding.common.Language;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Language language;

}