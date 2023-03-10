package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.TeacherService;
import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

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
    public String createStudent(@ModelAttribute Student student) {
        for (Teacher teacher : teacherService.findAll()) {
            if (!teacher.getLanguages().contains(student.getLanguage())){
                throw new IllegalArgumentException("Teacher does not teach this language!");
            }
        }
        if (student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            throw new IllegalArgumentException("First name or last name cannot be empty!");
        } else {
            studentService.createStudent(student);
        }
        return "redirect:/students";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
