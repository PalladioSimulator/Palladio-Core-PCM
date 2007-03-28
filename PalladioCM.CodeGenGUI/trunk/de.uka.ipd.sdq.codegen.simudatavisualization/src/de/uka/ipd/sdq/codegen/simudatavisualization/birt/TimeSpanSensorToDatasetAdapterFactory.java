/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

import java.util.Collection;


import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;

/**
 * @author admin
 * 
 */
public class TimeSpanSensorToDatasetAdapterFactory implements IAdapterFactory {

	public static final int HISTOGRAM_CLASS_WIDTH = 1;

	private RunEntry runEntry;

	/**
	 * @param runEntry
	 */
	public TimeSpanSensorToDatasetAdapterFactory(RunEntry runEntry) {
		this.runEntry = runEntry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory#canAdapt(java.lang.Class,
	 *      java.lang.Class)
	 */
	@Override
	public boolean canAdapt(Class fromClass, Class targetClass) {
		if (TimeSpanSensor.class.isAssignableFrom(fromClass)
				&& targetClass == Histogram.class)
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory#getAdapter(java.lang.Object,
	 *      java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptee, Class targetClass) {

		TimeSpanSensor s = (TimeSpanSensor) adaptee;
		Histogram histogram = new Histogram();
		Collection<Measurement> mesurements = runEntry.getExperimentRun()
				.getMeasurementsOfSensor(s);

		for (Measurement m : mesurements) {
			TimeSpanMeasurement tm = (TimeSpanMeasurement) m;

			/*
			 * TODO
			 */
		}

		return histogram;
	}
}
