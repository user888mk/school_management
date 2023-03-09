package pl.masters.coding.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.masters.coding.lesson.model.Lesson;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public void deleteLesson(Long id) {
        List<Lesson> lessonList = lessonRepository.findAll();
        lessonList.removeIf(lesson -> lesson.getId() == id);
    }

    public void createLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }
}
