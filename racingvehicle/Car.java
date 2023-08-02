package racingvehicle;

public class Car implements RacingVehicle{
    private static final double CAR_SPEED_KMH = 60.0;

    @Override
    public double calculateTimeToTravelDistance(double distance) {
        return distance / CAR_SPEED_KMH;
    }
}
