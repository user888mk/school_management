package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.masters.coding.lesson.model.Lesson;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private static final Logger logger = LoggerFactory.getLogger(LessonController.class);

   private final LessonServiceImpl lessonService;

    @GetMapping
    public String getLessonList(Model model) {
        List<Lesson> allLessons = lessonService.findAll();
        model.addAttribute("lessons", allLessons);

        return "lesson/list";
    }
}