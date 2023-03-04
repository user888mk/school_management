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
    //model - przekazuje do templatki atrybuty - przyjmuje klucz:wartosc
    public String getStudentList(Model model) {
        List<Student> allStudents = studentService.findAll();
        model.addAttribute("students", allStudents);
        model.addAttribute("languages", Language.values());
        return "student/list";
    }

    //zdanie - i u studenta lista i w lekcji lista
    //dodac do projektu jezyk student jeden jezyk - nauczyciel wiele
    //formularz html - zeby tworzyc nowy obiekt - strona na której bedzie chciała uzyskac dane


    @PostMapping("/create")
    //elementy z formularza - przekazane do metody (widok) - modelAttribute
    public String createStudent(@ModelAttribute Student student) {
        studentService.createStudent(student);
        System.out.println(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
