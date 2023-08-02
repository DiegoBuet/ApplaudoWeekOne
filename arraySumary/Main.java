package arraySumary;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int length = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println("Enter the length of the array: ");
            String inputString = input.nextLine();
            try {
                length = Integer.parseInt(inputString);
                if (length <= 0) {
                    System.out.println("Invalid input. Please enter a positive number greater than 0.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        CustomArrayOperations customOperations = new CustomArrayOperations();
        int[] array = RandomArray.getRandomArray(length);

        ArraySummary arraySummary = new ArraySummary(array, customOperations);
        SummaryResult result = arraySummary.calculateSummary();

        System.out.println(Arrays.toString(array));
        System.out.println("Minimum: " + result.min());
        System.out.println("Maximum: " + result.max());
        System.out.println("Average: " + result.average());
    }


}
