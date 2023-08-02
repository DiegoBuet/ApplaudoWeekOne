package arraySumary;

public class CustomArrayOperations implements ArrayOperations{
    @Override
    public int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array cannot be null or empty.");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array cannot be null or empty.");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public double calculateAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array cannot be null or empty.");
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }




}
