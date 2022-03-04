import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Set<Lesson> lessons = CreateLessonObjects.getLessonsAsObjects();
        SetCoRequisites.setCoRequisites(lessons);
        SetPreRequisites.setPreRequisites(lessons);
        System.out.println("salam");
        SetIndirectPreRequisites.setIndirectPreRequisites(lessons);
        PrintResult.print(lessons);
    }
}
