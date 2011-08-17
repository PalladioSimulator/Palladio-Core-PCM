package de.uka.ipd.sdq.simuservice;

import java.util.ArrayList;
import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class MeasurementsHelper {

    /**
     * A singleton pattern ensures the existence of only one measurements helper.
     */
    private static MeasurementsHelper singletonInstance = new MeasurementsHelper();

    /**
     * Retrieves the singleton instance.
     * 
     * @return the singleton instance
     */
    public static MeasurementsHelper getHelper() {
        return singletonInstance;
    }

    /**
     * The constructor is made private according to the singleton pattern.
     */
    private MeasurementsHelper() {
    }

    /**
     * Collects the actual measurement values of a given sensor within the given simulation results.
     * 
     * @param dataSource
     *            the data source that holds the simulation results
     * @param sensorName
     *            the name of the sensor to examine
     * @param measurementClass
     *            the type of measurements performed by the sensor
     * @return the list of values measured by the sensor
     * @throws ResultEvaluationException
     *             if the sensor could not be found or no experiment run exists
     */
    public MeasurementsData getMeasurements(final FileDAOFactory dataSource, final String sensorName,
            final Class<? extends Measurement> measurementClass) {

        // Create the result object:
        MeasurementsData data = new MeasurementsData();

        // Retrieve the list of sensors within the simulation results:
        Iterator<Sensor> sensors = dataSource.createSensorDAO().getSensors().iterator();

        // Search through the list of sensors:
        Sensor sensor = null;
        while (sensors.hasNext()) {
            Sensor sNext = sensors.next();
            if (sNext.getSensorName().equals(sensorName)) {
                sensor = sNext;
                break;
            }
        }
        if (sensor == null) {
            return data;
        }

        // Retrieve the first experiment run:
        ExperimentRun run = dataSource.createExperimentRunDAO().getExperimentRuns().iterator().next();
        if (run == null) {
            return data;
        }

        // Retrieve the values of the sensor for the experiment run:
        Iterator<Measurement> measurements = run.getMeasurementsOfSensor(sensor).getMeasurements().iterator();
        while (measurements.hasNext()) {

            // Retrieve the next measurement:
            Measurement mNext = measurements.next();

            // Assure that the measurement has correct type:
            if (!mNext.getClass().equals(measurementClass)) {
                return data;
            }

            // Depending on the measurement type, extract the measurement data:
            if (measurementClass.equals(TimeSpanMeasurementImpl.class)) {
                data.getValues().add(((TimeSpanMeasurement) mNext).getTimeSpan());
                data.getEventTimes().add(((TimeSpanMeasurement) mNext).getEventTime());
            }
        }

        // Return the result:
        return data;
    }

    /**
     * Gets the mean value of given measurements data.
     * 
     * @param data
     *            the measurements data
     * @return the mean value
     */
    public Double getMeanValue(final MeasurementsData data) {

        // Create a probability density function (PDF) from the measurements data:
        ManagedPDF pdf = createPDF(data.getValues());

        // The mean value can be directly retrieved from the pdf:
        return pdf.getMeanValue();
    }

    /**
     * Gets a percentile of given measurements data.
     * 
     * @param data
     *            the measurements data
     * @param specification
     *            the percentile specification
     * @return the percentile
     */
    public Double getPercentile(final MeasurementsData data, final double specification) {

        // Declare the result:
        Double percentile = 0.0;

        // Create a probability density function (PDF) from the measurements data:
        ManagedPDF pdf = createPDF(data.getValues());

        // Get the percentile:
        try {
            percentile = (Double) pdf.getSamplePdfTimeDomain().getPercentile((int) (specification * 100.0));
        }
        catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (UnorderedDomainException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Return the result:
        return percentile;
    }

    /**
     * Retrieves the throughput of given response time measurement data.
     * 
     * @param data
     *            the measurements data
     * @return the throughput in requests per minute
     */
    public Double getThroughput(final MeasurementsData data) {

        // Retrieve the measurements count:
        int measurementsCount = data.getValues().size();

        // Retrieve the simulation time [ms] of the last measurement event (that is, the time when the last call was
        // completed):
        double lastMeasurementTimeMS = data.getEventTimes().get(data.getEventTimes().size() - 1);

        // Return the throughput, normalized from milliseconds to minutes:
        return ((double) measurementsCount / lastMeasurementTimeMS) * 60000.0;
    }

    /**
     * Creates a probability density function (PDF) from a list of values.
     * 
     * @param values
     *            the values list
     * @return the resulting PDF
     */
    private ManagedPDF createPDF(final ArrayList<Double> values) {
    	
    	// Find the right precision factor for the PDF to create:
    	double maxValue = values.size() > 0 ? values.get(0) : 0.0;
    	double minValue = values.size() > 0 ? values.get(0) : 0.0;
    	for(double value : values) {
    		if(value > maxValue) {
    			maxValue = value;
    		} else if (value < minValue) {
    			minValue = value;
    		}
    	}
    	double distance = (maxValue - minValue > 0)? ((maxValue - minValue)/100.0) : 1.0;

        // Create the PDF:
        return new ManagedPDF(distance, values, IProbabilityFunctionFactory.eINSTANCE.createUnit("ms"), false);
    }
}
