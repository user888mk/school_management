package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.teacher.model.Teacher;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherServiceImpl teacherService;

    @GetMapping
    //model - przekazuje do templatki atrybuty - przyjmuje klucz:wartosc
    public String getTeacherList(Model model) {
        List<Teacher> allTeachers = teacherService.findAll();
        model.addAttribute("teachers", allTeachers);
        return "teacher/list";
    }

    //zdanie - i u studenta lista i w lekcji lista
    //dodac do projektu jezyk student jeden jezyk - nauczyciel wiele
    //formularz html - zeby tworzyc nowy obiekt - strona na której bedzie chciała uzyskac dane


    @GetMapping("/create")
    public String getTeacher(Model model) {
        model.addAttribute("newTeacher", new Teacher());
        return "redirect:/teachers";
    }

    @PostMapping("/create")
    //elementy z formularza - przekazane do metody (widok) - modelAttribute
    public String createTeacher(@ModelAttribute Teacher teacher) {
        teacherService.createTeacher(teacher);
        System.out.println(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam Integer id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }


}
