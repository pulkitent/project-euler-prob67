import java.util.List;

class Calculator {
    private final List<List<Cell>> triangularMatrix;
    private final static Integer one = 1;

    Calculator(List<List<Cell>> triangularMatrix) {
        this.triangularMatrix = triangularMatrix;
    }

    Integer calculateMaxSumPath() {
        int maxValue = Integer.MIN_VALUE;
        int totalRows = triangularMatrix.size();
        int lastRowIndex = triangularMatrix.size() - 1;

        try {
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                findMaxSumSoFarForEachCellInRow(rowIndex);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        List<Cell> lastRow = triangularMatrix.get(lastRowIndex);

        for (Cell cell : lastRow) {
            maxValue = Math.max(maxValue, cell.maxSumSoFar);
        }

        return maxValue;
    }

    private void findMaxSumSoFarForEachCellInRow(int rowIndex) {
        for (int columnIndex = 0; columnIndex < triangularMatrix.get(rowIndex).size(); columnIndex++) {
            calculateMaxSumSoFarForChildren(rowIndex, columnIndex);
        }
    }

    private void calculateMaxSumSoFarForChildren(int rowIndex, int columnIndex) {
        int totalRows = triangularMatrix.size();
        int ithRowSize = triangularMatrix.get(rowIndex).size();

        if (rowIndex + one < totalRows && columnIndex + one <= ithRowSize) {
            int maxSumSoFarParentCell = triangularMatrix.get(rowIndex).get(columnIndex).maxSumSoFar;

            int leftChildMaxSumSoFar = calculateMaxSumSoFarForCell(rowIndex + one, columnIndex, maxSumSoFarParentCell);
            triangularMatrix.get(rowIndex + one).get(columnIndex).maxSumSoFar = leftChildMaxSumSoFar;

            int rightChildMaxSumSoFar = calculateMaxSumSoFarForCell(rowIndex + one, columnIndex + one, maxSumSoFarParentCell);
            triangularMatrix.get(rowIndex + one).get(columnIndex + one).maxSumSoFar = rightChildMaxSumSoFar;
        }
    }

    private Integer calculateMaxSumSoFarForCell(int rowIndex, int columnIndex, int maxSumSoFarParentCell) {
        int childCellValue = triangularMatrix.get(rowIndex).get(columnIndex).value;
        int maxSumSoFarChildCell = triangularMatrix.get(rowIndex).get(columnIndex).maxSumSoFar;

        maxSumSoFarChildCell = Math.max(maxSumSoFarChildCell, maxSumSoFarParentCell + childCellValue);
        return maxSumSoFarChildCell;
    }
}