package pl.masters.coding.student;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.masters.coding.student.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static final List<Student> dummyStudentDb = new ArrayList<>();

    public List<Student> findAll() {
        return dummyStudentDb;
    }

    @PostConstruct
    private static void init() {
        Student studentOne = Student.builder()
                .id(1L)
                .firstName("Piotr")
                .language("Żyła")
                .language("ang")
                .build();

        Student studentTwo = Student.builder()
                .id(1L)
                .firstName("Adam")
                .language("Małysz")
                .language("ang")
                .build();

        dummyStudentDb.add(studentOne);
        dummyStudentDb.add(studentTwo);

    }
}
