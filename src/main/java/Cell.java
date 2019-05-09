
public class Cell {
    int value;
    int maxSumSoFar;

    Cell(int value, int maxSumSoFar) {
        this.value = value;
        this.maxSumSoFar = maxSumSoFar;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", maxSumSoFar=" + maxSumSoFar + "}";
    }
}