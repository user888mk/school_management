package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(int id) {
        findAll().removeIf(teacher -> teacher.getId() == id);
    }

    public void createTeacher(Teacher teacher) {
        findAll().add(teacher);
        teacher.setId(findAll().size());
    }
}
