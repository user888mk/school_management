package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl  {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Long id) {
        List<Teacher> teacherList = teacherRepository.findAll();
        teacherList.removeIf(teacher -> teacher.getId().equals(id));
    }

    public void createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
