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

    public void deleteStudent(Long id) {
        List<Student> studentList = studentRepository.findAll();
        studentList.removeIf(student -> student.getId().equals(id));
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }
}
