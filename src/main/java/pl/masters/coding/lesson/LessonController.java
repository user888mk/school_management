package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.lesson.model.Lesson;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public String getLessonList(Model model) {
        List<Lesson> allLessons = lessonService.findAll();
        model.addAttribute("lessons", allLessons);
        return "lesson/list";
    }

    @PostMapping("/create")
    public String createLesson(@ModelAttribute Lesson lesson) {
        lessonService.createLesson(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/delete")
    public String deleteLesson(@RequestParam Long id) {
        lessonService.deleteLesson(id);
        return "redirect:/lessons";
    }

}
