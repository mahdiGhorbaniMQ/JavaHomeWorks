import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapLessons {
    public static Map<String,Lesson> getLessonsAsMap(Set<Lesson> lessons){
        return lessons.stream()
                .collect(Collectors.toMap(Lesson::getName, lesson -> lesson));
    }
}
