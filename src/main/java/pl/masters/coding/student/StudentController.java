package pl.masters.coding.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.TeacherService;

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
        // tu by pasowalo podac liste nauczycieli i w html w opitonie ja zaciągnąć
        return "student/list";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {

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
