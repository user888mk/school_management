package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.masters.coding.lesson.model.Lesson;
import pl.masters.coding.student.StudentController;
import pl.masters.coding.student.StudentRepository;
import pl.masters.coding.student.StudentService;
import pl.masters.coding.student.model.Student;
import pl.masters.coding.teacher.TeacherService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {
    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping
    public String getLessonList(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "lesson/list";
    }

    @PostMapping("/create")
    public String createLesson(@ModelAttribute Lesson lesson, Model model) {
        if (lesson.getDate().isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("Cannot create lesson in the past!");
        } else {
            lessonService.createLesson(lesson);
        }
        return "redirect:/lessons";
    }

    @GetMapping("/delete")
    public String deleteLesson(@RequestParam int id) {
        Lesson lesson = lessonService.findLessonById(id);
        if (lesson.getDate().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot delete lesson which already started!");
        } else {
            lessonService.deleteLesson(id);
        }
        return "redirect:/lessons";
    }
}
