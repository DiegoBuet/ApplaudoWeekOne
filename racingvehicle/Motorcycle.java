package racingvehicle;

public class Motorcycle implements RacingVehicle {
    private static final double MOTORCYCLE_SPEED_KMH = 80.0;

    @Override
    public double calculateTimeToTravelDistance(double distance) {
        return distance / MOTORCYCLE_SPEED_KMH;
    }
}
