import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

import java.util.*;

public class SetIndirectPreRequisites {
    public static Set<Lesson> setIndirectPreRequisites(Set<Lesson> lessons){
        lessons.forEach(lesson -> {
            Set<Lesson> preRequisites = new HashSet<>();
            Queue<Lesson> lessonQueue = new LinkedList<>(lesson.getPreRequisites());
            while (!lessonQueue.isEmpty()){
                Lesson removedLesson = lessonQueue.remove();
                preRequisites.add(removedLesson);
                lessonQueue.addAll(removedLesson.getPreRequisites());
//                lessonQueue.addAll(removedLesson.getCoRequisites());
            }
            lesson.addAllPreRequisite(preRequisites);
        });
        return lessons;
    }
}
