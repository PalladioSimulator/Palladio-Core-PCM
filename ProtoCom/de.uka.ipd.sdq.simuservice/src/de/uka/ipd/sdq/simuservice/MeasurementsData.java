package de.uka.ipd.sdq.simuservice;

import java.util.ArrayList;

/**
 * This class represents interpreted data of a measurements sensor.
 * 
 * @author brosch
 * 
 */
public class MeasurementsData {

    /**
     * The list of measurements values.
     */
    private ArrayList<Double> values = new ArrayList<Double>();

    /**
     * Retrieves the list of measurements values.
     * 
     * @return the list of measurements values
     */
    public ArrayList<Double> getValues() {
        return values;
    }

    /**
     * The list of measurements event times.
     */
    private ArrayList<Double> eventTimes = new ArrayList<Double>();

    /**
     * Retrieves the list of measurements event times.
     * 
     * @return the list of measurements event times
     */
    public ArrayList<Double> getEventTimes() {
        return eventTimes;
    }

    /**
     * Indicates if this data contains actual measurements.
     * 
     * @return TRUE if measurements are contained
     */
    public boolean hasMeasurements() {
        return values.size() > 0;
    }
}
