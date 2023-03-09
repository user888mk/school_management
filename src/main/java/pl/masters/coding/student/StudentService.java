package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.TeacherRepository;
import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        findAll().removeIf(student -> student.getId() == id);
    }

    public void createStudent(Student student) {
        findAll().add(student);
        student.setId(findAll().size());
    }
}
