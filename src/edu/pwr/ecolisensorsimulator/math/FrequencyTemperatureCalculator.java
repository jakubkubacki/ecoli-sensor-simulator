package edu.pwr.ecolisensorsimulator.math;

public class FrequencyTemperatureCalculator {

    public static double normalizeTemperature(double freq, double temp) {
        return freq / (0.002305 * temp + 0.9538);
    }

}
