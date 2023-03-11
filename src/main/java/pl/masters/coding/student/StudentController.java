package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.TeacherService;
import pl.masters.coding.teacher.model.Teacher;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final TeacherService teacherService;

    @GetMapping
    public String getStudentList(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("languages", Language.values());
        model.addAttribute("teachers", teacherService.findAll());
        return "student/list";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, @RequestParam("teacherId") int teacherId, @RequestParam("language") Language language) {
        Teacher teacher = teacherService.findById(teacherId);
        if (teacher.getLanguages().contains(language)) {
            student.setTeacher(teacher);
            studentService.createStudent(student);
            //teacher.getStudents().add(student);
        } else {
            throw new IllegalArgumentException("This teacher doesn't teach this language!");
        }
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
