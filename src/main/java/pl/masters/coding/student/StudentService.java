package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.masters.coding.student.model.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(int id) {
        findAll().removeIf(student -> student.getId() == id);
    }

    public void createStudent(Student student) {
        findAll().add(student);
        student.setId(findAll().size());
    }

    public Student findById(int id) {
        return findAll().stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
