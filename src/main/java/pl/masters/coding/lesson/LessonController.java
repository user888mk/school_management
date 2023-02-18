package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.masters.coding.lesson.model.Lesson;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private LessonService lessonService;

    @GetMapping
    public String getLessonList(){
        return "lesson/list";
    }

}
