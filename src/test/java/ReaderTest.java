import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.List;

public class ReaderTest {
    @Test
    @DisplayName("Expects to read static text file with a triangle pof size 100")
    public void expectsToReadTextFile() throws IOException {
        String filePath = "/Users/pulkit.gupta/Desktop/euler/src/main/resources/p067_triangle.txt";

        List<List<Cell>> triangularMatrix = Reader.readTextFile(filePath);

        Assertions.assertEquals(100, triangularMatrix.size());
    }

    @Test
    @DisplayName("Expects to throw exception while reading text file")
    public void expectsToThrowExceptionOnFileReading() throws IOException {
        String filePath = "";

        Assertions.assertThrows(RuntimeException.class, () -> Reader.readTextFile(filePath));
    }
}