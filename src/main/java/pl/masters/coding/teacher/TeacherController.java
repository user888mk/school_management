package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
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
        model.addAttribute("languages", Language.values());
        return "teacher/list";
    }

    @PostMapping("/create")
    //elementy z formularza - przekazane do metody (widok) - modelAttribute
    public String createTeacher(@ModelAttribute Teacher teacher) {
        teacherService.createTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam Long id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }

    @GetMapping("/edit")
    public String editTeacher(@RequestParam Teacher teacher) {
        teacherService.update(teacher);
        return "redirect:/teachers";
    }
}