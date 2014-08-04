package de.uka.ipd.sdq.simulation.abstractsimengine.example;

public class Duration {

    public enum TimeUnit {
        HOURS, MINUTES, SECONDS;
    }

    private double value;

    private TimeUnit unit;

    public Duration(double value, TimeUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Duration toHours() {
        double factor;
        switch (unit) {
        case HOURS: // hr -> hr
            factor = 1;
            break;
        case MINUTES: // min -> hr
            factor = 1.0 / 60;
            break;
        case SECONDS: // sec -> hr
            factor = 1.0 / (60 * 60);
            break;
        default:
            throw new RuntimeException("Unexpected time unit: " + unit);
        }

        return new Duration(value * factor, TimeUnit.HOURS);
    }

    public Duration toMinutes() {
        double factor;
        switch (unit) {
        case HOURS: // hr -> min
            factor = 60.0;
            break;
        case MINUTES: // min -> min
            factor = 1.0;
            break;
        case SECONDS: // sec -> min
            factor = 1.0 / 60;
            break;
        default:
            throw new RuntimeException("Unexpected time unit: " + unit);
        }

        return new Duration(value * factor, TimeUnit.MINUTES);
    }

    public Duration toSeconds() {
        double factor;
        switch (unit) {
        case HOURS: // hr -> sec
            factor = 60.0 * 60;
            break;
        case MINUTES: // min -> sec
            factor = 1.0 * 60;
            break;
        case SECONDS: // sec -> sec
            factor = 1.0;
            break;
        default:
            throw new RuntimeException("Unexpected time unit: " + unit);
        }

        return new Duration(value * factor, TimeUnit.SECONDS);
    }

    public static Duration hours(double value) {
        return new Duration(value, TimeUnit.HOURS);
    }

    public static Duration minutes(double value) {
        return new Duration(value, TimeUnit.MINUTES);
    }

    public static Duration seconds(double value) {
        return new Duration(value, TimeUnit.SECONDS);
    }

    public double value() {
        return value;
    }

    public TimeUnit getUnit() {
        return unit;
    }

}
