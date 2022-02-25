import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("insert number of lessons: ");
        n = scanner.nextInt();

        double[][] scores = new double[n][2];
        for (int i=0; i<n; i++){
            System.out.print("insert score of lessons-"+(i+1)+": ");
            scores[i][0] = scanner.nextDouble();

            System.out.print("insert weight of lessons-"+(i+1)+": ");
            scores[i][1] = scanner.nextDouble();
        }

        double scoresSum = Arrays.stream(scores)
                .map(score->  score[0]*score[1])
                .collect(Collectors.toList())
                .stream().mapToDouble(Double::doubleValue)
                .sum();
        double weightsSum = Arrays.stream(scores)
                        .map(score-> score[1])
                        .collect(Collectors.toList())
                        .stream().mapToDouble(Double::doubleValue)
                        .sum();
        System.out.println(
                "the average of scores is: " + (scoresSum/weightsSum)
        );
    }
}
