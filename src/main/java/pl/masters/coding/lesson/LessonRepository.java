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

    public void save(Lesson lesson) {
        dummyLessonsDb.add(lesson);
        lesson.setId((long) dummyLessonsDb.size());
    }

    @PostConstruct
    private static void init() {
        Lesson l1 = Lesson.builder()
                .id(1L)
                .teacher(Teacher.builder().id(9L).build())
                .student(Student.builder().id(5L).build())
                .date(LocalDateTime.of(2023, 3, 11, 12, 0))
                .build();
        Lesson l2 = Lesson.builder()
                .id(2L)
                .teacher(Teacher.builder().id(14L).build())
                .student(Student.builder().id(7L).build())
                .date(LocalDateTime.of(2023, 4, 12, 13, 45))
                .build();
        dummyLessonsDb.add(l1);
        dummyLessonsDb.add(l2);

    }


}
