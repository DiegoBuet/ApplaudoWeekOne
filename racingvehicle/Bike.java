package racingvehicle;

public class Bike implements RacingVehicle{
    private static final double BIKE_SPEED_KMH = 6.0;

    @Override
    public double calculateTimeToTravelDistance(double distance) {
        return distance / BIKE_SPEED_KMH;
    }
}
