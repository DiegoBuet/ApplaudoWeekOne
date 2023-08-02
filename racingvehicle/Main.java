package racingvehicle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distanceInMeters = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the distance in meters: ");
                distanceInMeters = scanner.nextDouble();

                if (distanceInMeters < 0) {
                    System.out.println("Distance cannot be negative. Try again.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }
        }


        double distanceInKilometers = distanceInMeters / 1000.0;

        RacingVehicle bike = new Bike();
        RacingVehicle car = new Car();
        RacingVehicle motorcycle = new Motorcycle();

        double bikeTime = bike.calculateTimeToTravelDistance(distanceInKilometers);
        double carTime = car.calculateTimeToTravelDistance(distanceInKilometers);
        double motorcycleTime = motorcycle.calculateTimeToTravelDistance(distanceInKilometers);

        System.out.println();
        System.out.println("Bike time: " + TimeFormatter.formatTime(bikeTime));
        System.out.println("Car time: " + TimeFormatter.formatTime(carTime));
        System.out.println("Motorcycle time: " + TimeFormatter.formatTime(motorcycleTime));

        scanner.close();
    }

}
