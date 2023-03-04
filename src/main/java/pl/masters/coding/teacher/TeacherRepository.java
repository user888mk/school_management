package pl.masters.coding.teacher;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.masters.coding.common.Language;
import pl.masters.coding.teacher.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Repository //adnotacja do usunięcia w momencie przejścia na interface z JPA
public class TeacherRepository {

    private static final List<Teacher> dummyTeacherDb = new ArrayList<>();

    public List<Teacher> findAll() {
        return dummyTeacherDb;
    }

    public void save(Teacher teacher) {
        dummyTeacherDb.add(teacher);
        teacher.setId((long) dummyTeacherDb.size());
    }

    @PostConstruct
    private static void init() {
        Teacher teacher1 = Teacher.builder()
                .id(1L)
                .firstName("Jan")
                .lastName("Kowalski")
                .languages(List.of(Language.ARABIC, Language.FRENCH, Language.SPANISH))
                .build();
        Teacher teacher2 = Teacher.builder()
                .id(2L)
                .firstName("Janek")
                .lastName("Kowal")
                .languages(List.of(Language.ENGLISH, Language.JAPANESE))
                .build();
        dummyTeacherDb.add(teacher1);
        dummyTeacherDb.add(teacher2);
    }

}
