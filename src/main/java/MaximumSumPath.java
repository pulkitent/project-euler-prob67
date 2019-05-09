import java.io.IOException;
import java.util.List;

public class MaximumSumPath {
    public static void main(String arg[]) throws IOException {
        long startTime = System.nanoTime();
        String filePath = "/Users/pulkit.gupta/Desktop/euler/src/main/resources/p067_triangle.txt";

        List<List<Cell>> triangularMatrix = Reader.readTextFile(filePath);

        triangularMatrix.forEach(System.out::println);

        int maxPathSum = Calculator.calculateMaxSumPath(triangularMatrix);
        System.out.println("Maximum path sum " + maxPathSum);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Execution time in nano seconds " + totalTime);

        triangularMatrix.forEach(System.out::println);
    }
}