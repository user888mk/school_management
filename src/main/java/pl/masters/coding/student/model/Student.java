package pl.masters.coding.student.model;

import lombok.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.teacher.model.Teacher;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private Language language;

    private Teacher teacher;
}