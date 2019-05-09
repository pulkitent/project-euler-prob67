import java.util.List;

class Calculator {
    static Integer calculateMaxSumPath(List<List<Cell>> triangularMatrix) {
        int lastRowIndex = triangularMatrix.size() - 1;
        int max = Integer.MIN_VALUE;

        try {
            for (int i = 0; i < triangularMatrix.size(); i++) {
                CalculateMaxSofarForEachChild(triangularMatrix, i);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        for (Cell cell : triangularMatrix.get(lastRowIndex)) {
            max = Math.max(max, cell.maxSumSoFar);
        }

        return max;
    }

    private static void CalculateMaxSofarForEachChild(List<List<Cell>> triangularMatrix, int i) {
        for (int j = 0; j < triangularMatrix.get(i).size(); j++) {
            CalculateMaxSoFarForTwoChildNode(triangularMatrix, i, j);
        }
    }

    private static void CalculateMaxSoFarForTwoChildNode(List<List<Cell>> triangularMatrix, int i, int j) {
        if (i + 1 < triangularMatrix.size() && j + 1 <= triangularMatrix.get(i).size()) {
            Integer ithAndJThCellMaxSoFar = triangularMatrix.get(i).get(j).maxSumSoFar;

            Integer ithPlus1AndJThCellMaxSum = triangularMatrix.get(i + 1).get(j).maxSumSoFar;
            Integer ithPlus1AndJThCellValue = triangularMatrix.get(i + 1).get(j).value;

            ithPlus1AndJThCellMaxSum = Math.max(ithPlus1AndJThCellMaxSum, ithAndJThCellMaxSoFar + ithPlus1AndJThCellValue);
            triangularMatrix.get(i + 1).get(j).maxSumSoFar = ithPlus1AndJThCellMaxSum;

            Integer ithPlus1AndJThPlus1CellMaxSum = triangularMatrix.get(i + 1).get(j + 1).maxSumSoFar;
            Integer ithPlus1AndJThPlus1CellValue = triangularMatrix.get(i + 1).get(j + 1).value;

            ithPlus1AndJThPlus1CellMaxSum = Math.max(ithPlus1AndJThPlus1CellMaxSum, ithAndJThCellMaxSoFar + ithPlus1AndJThPlus1CellValue);
            triangularMatrix.get(i + 1).get(j + 1).maxSumSoFar = ithPlus1AndJThPlus1CellMaxSum;
        }
    }
}