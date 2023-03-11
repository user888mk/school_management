package pl.masters.coding.teacher;

import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.masters.coding.common.Language;
import pl.masters.coding.teacher.model.Teacher;

import java.util.ArrayList;
import java.util.List;

//@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

//    private static final List<Teacher> dummyTeacherDb = new ArrayList<>();
//
//    public List<Teacher> findAll() {
//        return dummyTeacherDb;
//    }
//
//    @PostConstruct
//    private static void init() {
//        Teacher teacher1 = Teacher.builder()
//                .id(1)
//                .firstName("Jan")
//                .lastName("Kowalski")
//                .languages(List.of(Language.ARABIC, Language.FRENCH, Language.SPANISH))
//                .build();
//        Teacher teacher2 = Teacher.builder()
//                .id(2)
//                .firstName("Janek")
//                .lastName("Kowal")
//                .languages(List.of(Language.ENGLISH, Language.JAPANESE))
//                .build();
//
//        dummyTeacherDb.add(teacher1);
//        dummyTeacherDb.add(teacher2);
//    }
}
