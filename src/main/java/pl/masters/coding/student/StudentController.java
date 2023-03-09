package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getStudentList(Model model) {
        List<Student> allStudents = studentService.findAll();
        model.addAttribute("students", allStudents);
        model.addAttribute("languages", Language.values());
        return "student/list";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
