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
//        model.getAttribute("teachers");
        return "student/list";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
//        for (Student studentFromDb : studentService.findAll()) {
//            if (studentFromDb.getFirstName() == null){
//                System.out.println("niee");
//            }
//        }
        if (student.getFirstName().isEmpty() || student.getLastName().isEmpty()){
            throw new RuntimeException("First name or last name cannot be empty!");
        } else {
            studentService.createStudent(student);
        }
        return "redirect:/students";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
