package racingvehicle;

public class TimeFormatter {
    public static String formatTime(double hours) {
        long milliseconds = (long) (hours * 60 * 60 * 1000);
        int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
        milliseconds = milliseconds % (24 * 60 * 60 * 1000);
        int hoursOfDay = (int) (milliseconds / (60 * 60 * 1000));
        milliseconds = milliseconds % (60 * 60 * 1000);
        int minutes = (int) (milliseconds / (60 * 1000));
        milliseconds = milliseconds % (60 * 1000);

        StringBuilder formattedTime = new StringBuilder();
        if (days > 0) {
            formattedTime.append(days).append(days == 1 ? " day" : " days").append(", ");
        }
        if (hoursOfDay > 0) {
            formattedTime.append(hoursOfDay).append(hoursOfDay == 1 ? " hour" : " hours").append(", ");
        }
        if (minutes > 0) {
            formattedTime.append(minutes).append(minutes == 1 ? " minute" : " minutes").append(", ");
        }
        formattedTime.append(milliseconds).append(" milliseconds");

        return formattedTime.toString();
    }
}
