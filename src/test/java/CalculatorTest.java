import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class CalculatorTest {
    @Test
    @DisplayName("Should calculate maximum sum path for a given triangle")
    void expectsMaxSumPathToBeCalculated() {
        List<List<Cell>> triangularMatrix = createTriangularMatrix();
        Calculator calculator = new Calculator(triangularMatrix);

        Assertions.assertEquals(23, calculator.calculateMaxSumPath());
    }

    @Test
    @DisplayName("Should calculate maximum sum path for a triangle with single node only")
    void expectsMaxSumToBeCalculatedForBaseCase() {
        List<List<Cell>> triangularMatrix = new LinkedList<>();
        List<Cell> row = new LinkedList();
        row.add(new Cell(5, 5));
        triangularMatrix.add(row);
        Calculator calculator = new Calculator(triangularMatrix);

        Assertions.assertEquals(5, calculator.calculateMaxSumPath());
    }

    @Test
    @DisplayName("Should calculate maximum sum path for a triangle with single node only")
    void expectsExceptionWhenMaxSumPathIsCalculated() {
        List<List<Cell>> triangularMatrix = new LinkedList<>();
        Calculator calculator = new Calculator(triangularMatrix);

        Assertions.assertThrows(RuntimeException.class, () ->
                calculator.calculateMaxSumPath());
    }

    private List<List<Cell>> createTriangularMatrix() {
        List<List<Cell>> triangularMatrix = new LinkedList<>();

        Cell cell1 = new Cell(3, 3);
        List<Cell> row1 = new LinkedList<>();
        row1.add(cell1);
        triangularMatrix.add(row1);

        Cell cell2 = new Cell(7, 0);
        Cell cell3 = new Cell(4, 0);
        List<Cell> row2 = new LinkedList<>();
        row2.add(cell2);
        row2.add(cell3);
        triangularMatrix.add(row2);

        Cell cell4 = new Cell(2, 0);
        Cell cell5 = new Cell(4, 0);
        Cell cell6 = new Cell(6, 0);
        List<Cell> row3 = new LinkedList<>();
        row3.add(cell4);
        row3.add(cell5);
        row3.add(cell6);
        triangularMatrix.add(row3);

        Cell cell7 = new Cell(8, 0);
        Cell cell8 = new Cell(5, 0);
        Cell cell9 = new Cell(9, 0);
        Cell cell10 = new Cell(3, 0);
        List<Cell> row4 = new LinkedList<>();
        row4.add(cell7);
        row4.add(cell8);
        row4.add(cell9);
        row4.add(cell10);
        triangularMatrix.add(row4);

        return triangularMatrix;
    }
}