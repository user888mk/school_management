package pl.masters.coding.lesson;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.masters.coding.lesson.model.Lesson;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.model.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LessonRepository {
    private static final List<Lesson> dummyLessonsDb = new ArrayList<>();

    public List<Lesson> findAll() {
        return dummyLessonsDb;
    }

    @PostConstruct
    private static void init() {
        Lesson l1 = Lesson.builder()
                .id(1)
                .teacher(Teacher.builder().id(9).build())
                .student(Student.builder().id(5).build())
                .date(LocalDateTime.of(2023, 3, 11, 12, 0))
                .build();
        Lesson l2 = Lesson.builder()
                .id(2)
                .teacher(Teacher.builder().id(14).build())
                .student(Student.builder().id(7).build())
                .date(LocalDateTime.of(2023, 4, 12, 13, 45))
                .build();

        dummyLessonsDb.add(l1);
        dummyLessonsDb.add(l2);
    }
}
