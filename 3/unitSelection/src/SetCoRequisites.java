import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetCoRequisites {
    public static Set<Lesson> setCoRequisites(Set<Lesson> lessons){
        Map<String, Lesson> lessonMap = MapLessons.getLessonsAsMap(lessons);
        Arrays.stream(Information.coRequisites).forEach(coRequisites->{
            Arrays.stream(coRequisites).forEach(lesson->{
                lessonMap.get(lesson)
                        .addAllCoRequisite(
                                Arrays.stream(coRequisites)
                                        .map(lessonMap::get)
                                        .collect(Collectors.toSet())
                        ).removeCoRequisite(lessonMap.get(lesson));
            });
        });
        return lessons;
    }
}
