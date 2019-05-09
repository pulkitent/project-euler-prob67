import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

class Reader {
    static List<List<Cell>> readTextFile(String filePath) throws IOException {
        List<List<Cell>> matrix = new LinkedList<>();

        try {
            String line = "";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while ((line = reader.readLine()) != null) {
                List<Cell> row = createTriangularRow(line);
                matrix.add(row);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return matrix;
    }

    private static List<Cell> createTriangularRow(String line) {
        List<Cell> row = new LinkedList<>();
        String[] values = line.split(" ");
        for (String value : values) {
            Integer maxSoFar = values.length == 1 ? Integer.parseInt(value) : 0;
            Cell cell = new Cell(Integer.parseInt(value), maxSoFar);
            row.add(cell);
        }
        return row;
    }
}
