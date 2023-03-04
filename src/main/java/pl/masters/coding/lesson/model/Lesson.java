package pl.masters.coding.lesson.model;

import lombok.*;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.model.Teacher;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Lesson {

    private Long id;

    private Student student;

    private Teacher teacher;

    private LocalDate date;


}
