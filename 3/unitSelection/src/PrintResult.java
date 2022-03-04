import java.util.Set;
import java.util.stream.Collectors;

public class PrintResult {
    public static void print(Set<Lesson> lessons){
        lessons.forEach(lesson -> {
            System.out.println(lesson.getName());
            System.out.println();
            System.out.println("هم نیاز ها: ");
            System.out.println(
                    String.join("  -  ",
                            lesson.getCoRequisites()
                                    .stream().map(Lesson::getName)
                                    .collect(Collectors.toSet())
                    )
            );
            System.out.println();

            System.out.println("پیش نیاز ها: ");
            System.out.println(
                    String.join("  -  ",
                            lesson.getPreRequisites()
                                    .stream().map(Lesson::getName)
                                    .collect(Collectors.toSet())
                    )
            );
            System.out.println("_________________________________");
        });
    }
}
