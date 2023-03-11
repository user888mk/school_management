package pl.masters.coding.student;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static final List<Student> dummyStudentDb = new ArrayList<>();

    public List<Student> findAll() {
        return dummyStudentDb;
    }

    public void save(Student student) {
        dummyStudentDb.add(student);
        student.setId((long) dummyStudentDb.size());
    }

    @PostConstruct
    private static void init() {
        Student studentOne = Student.builder()
                .id(1)
                .firstName("Piotr")
                .lastName("Żyła")
                .language(Language.ITALIAN)
                .build();

        Student studentTwo = Student.builder()
                .id(2)
                .firstName("Adam")
                .lastName("Małysz")
                .language(Language.ARABIC)
                .build();

        dummyStudentDb.add(studentOne);
        dummyStudentDb.add(studentTwo);
    }
}