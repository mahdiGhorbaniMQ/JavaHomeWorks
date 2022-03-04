import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CreateLessonObjects {

    public static Set<Lesson> getLessonsAsObjects(){
        return Arrays.stream(Information.lessons).map(Lesson::new).collect(Collectors.toSet());
    }

}
