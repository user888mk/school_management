package pl.masters.coding.lesson;

import pl.masters.coding.lesson.model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonRepository {

    private static final List<Lesson> dummyLessonsDb = new ArrayList<>();

    public List<Lesson> findAll() {
        return dummyLessonsDb;
    }


}
