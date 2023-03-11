package pl.masters.coding.teacher.model;

import lombok.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private List<Language> languages;

    private List<Student> students;
}
