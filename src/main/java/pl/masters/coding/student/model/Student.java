package pl.masters.coding.student.model;

import lombok.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.lesson.model.Lesson;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private Language language;
    private List<Lesson> lessonList;
}