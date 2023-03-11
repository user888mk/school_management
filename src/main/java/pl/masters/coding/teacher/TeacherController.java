package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.common.Language;
import pl.masters.coding.teacher.model.Teacher;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public String getTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("languages", Language.values());
        return "teacher/list";
    }

    @PostMapping("/create")
    public String createTeacher(@ModelAttribute Teacher teacher) {
        //TODO: do ogarnięcia przeniesienie walidacji do serwisu lub zrobienie walidacji adnotacjami na poziomie klasy (spring-boot-starter-validation)
//        if (teacher.getFirstName().isEmpty() || teacher.getLastName().isEmpty() || teacher.getLanguages().isEmpty()) {
//            throw new IllegalArgumentException("First name or Last name or Languages cannot be empty!");
//        } else {
            teacherService.createTeacher(teacher);
//        }
        return "redirect:/teachers";
    }

    @GetMapping("/delete")
    public String deleteTeacher(@RequestParam int id) {
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }


}
