import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CellTest {
    @Test
    @DisplayName("Should expect string representation fo a cell")
    void expectsStringRepresentation() {
        Cell cell = new Cell(1, 1);

        String cellStringRepresentation = "{value=1, maxSumSoFar=1}";

        Assertions.assertEquals(cellStringRepresentation, cell.toString());
    }
}
