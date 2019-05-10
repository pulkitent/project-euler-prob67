import java.io.IOException;
import java.util.List;

public class MaximumSumPath {
    public static void main(String arg[]) throws IOException {
        long startTime = System.nanoTime();

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + "/src/main/resources/p067_triangle.txt";

        List<List<Cell>> triangularMatrix = Reader.readTextFile(filePath);
        //triangularMatrix.forEach(System.out::println);

        Calculator calculator = new Calculator(triangularMatrix);
        int maxPathSum = calculator.calculateMaxSumPath();
        System.out.println("Maximum path sum " + maxPathSum);
        //triangularMatrix.forEach(System.out::println);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Execution time in nano seconds " + totalTime);
    }
}