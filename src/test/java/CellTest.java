import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class CellTest {
    @Test
    @DisplayName("Should expect string representation fo a cell")
    public void expectsStringRepresentation() {
        Cell cell = new Cell(1, 1);

        String cellStringRepresentation = "{value=1, maxSumSoFar=1}";

        Assertions.assertEquals(cellStringRepresentation, cell.toString());
    }
}
