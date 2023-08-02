package arraySumary;

public class ArraySummary {
    private int[] array;
    private ArrayOperations arrayOperations;

    public ArraySummary(int[] array, ArrayOperations arrayOperations) {
        this.array = array;
        this.arrayOperations = arrayOperations;
    }

    public SummaryResult calculateSummary() {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array cannot be null or empty.");
        }

        int min = arrayOperations.findMin(array);
        int max = arrayOperations.findMax(array);
        double average = arrayOperations.calculateAverage(array);

        return new SummaryResult(min, max, average);
    }
}
