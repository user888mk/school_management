package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.lesson.model.Lesson;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private static final Logger logger = LoggerFactory.getLogger(LessonController.class);

    private final LessonServiceImpl lessonService;

    @GetMapping
    public String getLessonList(Model model) {
        List<Lesson> allLessons = lessonService.findAll();
        model.addAttribute("lessons", allLessons);
        return "lesson/list";
    }

    @PostMapping("/create")
    //elementy z formularza - przekazane do metody (widok) - modelAttribute
    public String createLesson(@ModelAttribute Lesson lesson) {
        lessonService.createLesson(lesson);
        System.out.println(lesson);
        return "redirect:/lessons";
    }

    @GetMapping("/delete")
    public String deleteLesson(@RequestParam Long id) {
        lessonService.deleteLesson(id);
        return "redirect:/lessons";
    }

}