import java.util.List;

class Calculator {
    private final List<List<Cell>> triangularMatrix;

    private final static Integer one = 1;

    Calculator(List<List<Cell>> triangularMatrix) {
        this.triangularMatrix = triangularMatrix;
    }

    Integer calculateMaxSumPath() {
        int lastRowIndex = triangularMatrix.size() - 1;
        int maxValue = Integer.MIN_VALUE;
        int totalRows = triangularMatrix.size();

        try {
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                calculateMaxSumSoFarForARow(rowIndex);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        for (Cell cell : triangularMatrix.get(lastRowIndex)) {
            maxValue = Math.max(maxValue, cell.maxSumSoFar);
        }

        return maxValue;
    }

    private void calculateMaxSumSoFarForARow(int rowIndex) {
        for (int columnIndex = 0; columnIndex < triangularMatrix.get(rowIndex).size(); columnIndex++) {
            calculateMaxSumSoFarForChildren(rowIndex, columnIndex);
        }
    }

    private void calculateMaxSumSoFarForChildren(int rowIndex, int columnIndex) {
        int totalRows = triangularMatrix.size();
        int ithRowSize = triangularMatrix.get(rowIndex).size();

        if (rowIndex + one < totalRows && columnIndex + one <= ithRowSize) {
            int maxSoFarParentCell = triangularMatrix.get(rowIndex).get(columnIndex).maxSumSoFar;

            int leftChildMaxSumSoFar = calculateCellMaxValue(rowIndex + one, columnIndex, maxSoFarParentCell);
            triangularMatrix.get(rowIndex + one).get(columnIndex).maxSumSoFar = leftChildMaxSumSoFar;

            int rightChildMaxSumSoFar = calculateCellMaxValue(rowIndex + one, columnIndex + one, maxSoFarParentCell);
            triangularMatrix.get(rowIndex + one).get(columnIndex + one).maxSumSoFar = rightChildMaxSumSoFar;
        }
    }

    private Integer calculateCellMaxValue(int rowIndex, int columnIndex, int maxSoFarParentCell) {
        int maxSoFarChildCell = triangularMatrix.get(rowIndex).get(columnIndex).maxSumSoFar;
        int childCellValue = triangularMatrix.get(rowIndex).get(columnIndex).value;

        maxSoFarChildCell = Math.max(maxSoFarChildCell, maxSoFarParentCell + childCellValue);
        return maxSoFarChildCell;
    }
}