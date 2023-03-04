package pl.masters.coding.lesson;

import jakarta.annotation.PostConstruct;
import lombok.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import pl.masters.coding.common.Language;
import pl.masters.coding.lesson.model.Lesson;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.model.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Builder
public class LessonRepository {
    private static Logger logger = LoggerFactory.getLogger(LessonRepository.class);
    private static final List<Lesson> dummyLessonsDb = new ArrayList<>();

    public List<Lesson> findAll() {
        return dummyLessonsDb;
    }

    public void save(Lesson lesson) {
        dummyLessonsDb.add(lesson);
    }

    @PostConstruct
    public static void init() {


        Lesson firstLesson = Lesson.builder()
                .student(Student.builder()
                        .firstName("Annia")
                        .lastName("Lewandowska")
                        .language(Language.ITALIAN)
                        .build())
                .teacher(Teacher.builder()
                        .firstName("Adam")
                        .lastName("Malysz")
                        .languages(List.of(Language.ARABIC, Language.CHINESE))
                        .build())
                .date(LocalDate.now())
                .build();

        Lesson secondLesson = Lesson.builder()
                .student(Student.builder()
                        .firstName("Dżoana")
                        .lastName("Krupa")
                        .language(Language.FRENCH)
                        .build())
                .teacher(Teacher.builder()
                        .firstName("Piotr")
                        .lastName("Żyła")
                        .languages(List.of(Language.ENGLISH, Language.JAPANESE, Language.SPANISH))
                        .build())
                .date(LocalDate.now())
                .build();

        dummyLessonsDb.add(firstLesson);
        dummyLessonsDb.add(secondLesson);
    }


}
