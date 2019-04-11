package edu.pwr.ecolisensorsimulator.math;

public class FrequencyToCompoundsCalculator {

    public static double FrequencyCompoundCoefficient = 12.406;

    public static double transform(double frequncy) {
        return FrequencyToCompoundsCalculator.FrequencyCompoundCoefficient * frequncy;
    }

}
