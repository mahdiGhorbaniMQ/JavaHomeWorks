import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetPreRequisites {
    public static Set<Lesson> setPreRequisites(Set<Lesson> lessons){
        Map<String, Lesson> lessonMap = MapLessons.getLessonsAsMap(lessons);

        Information.preRequisites().forEach((lesson,preRequisites)->{
            lessonMap.get(lesson).addAllPreRequisite(
                    Arrays.stream(preRequisites)
                            .map(lessonMap::get)
                            .collect(Collectors.toSet())
            );
        });
        return lessons;
    }
}
