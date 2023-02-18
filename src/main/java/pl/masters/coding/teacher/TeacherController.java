package pl.masters.coding.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public String getTeacherList(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teacher/list";
    }

//    @GetMapping("/create")
//
//    @PostMapping("/create")
}
