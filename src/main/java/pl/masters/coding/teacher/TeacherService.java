package pl.masters.coding.teacher;

import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    void deleteTeacher(Long id);

    void createTeacher(Teacher teacher);
}
