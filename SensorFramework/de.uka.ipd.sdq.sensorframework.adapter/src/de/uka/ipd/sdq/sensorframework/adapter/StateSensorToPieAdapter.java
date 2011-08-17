package de.uka.ipd.sdq.sensorframework.adapter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**
 * Provides an adapter that allows to convert StateSensors to Pies.
 * 
 * @author Henning Groenda
 */
public abstract class StateSensorToPieAdapter extends DataAdapter {

	/** Factor to display values in percent. */
	private static final int FACTOR_PERCENT = 100;

	/** Information about the StateSensor and the measurements. */
	protected SensorAndMeasurements samInformation;

	/**
	 * Initializes the adapter with the given StateSensor measurements.
	 * 
	 * @param samInformation
	 *            Information about the StateSensor and the measurements.
	 */
	protected StateSensorToPieAdapter(final SensorAndMeasurements samInformation) {
		super();
		this.samInformation = samInformation;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		HashMap<String, Double> fractions = new HashMap<String, Double>();
		double sum = calculateFractions(fractions);
		return createPie(fractions, sum);
	}

	/**
	 * Takes sum of the time in which all states were active and creates a Pie
	 * from it
	 * 
	 * @param timeSums
	 *            A map which associates to each state the sum of the time this
	 *            state has been active
	 * @param sum
	 *            Total sum of times
	 * @return A pie representation of the data
	 */
	private AbstractPie createPie(final HashMap<String, Double> timeSums,
			final double sum) {
		AbstractPie p = instantiatePie(((StateSensor) samInformation.getSensor())
				.getSensorName());
		DecimalFormat df = new DecimalFormat("#0.0", new DecimalFormatSymbols(
				Locale.US));
		for (Entry<String, Double> e : timeSums.entrySet()) {
			if (e.getValue() > 0.0) {
				p
						.addEntity(new PieEntity(e.getValue(), e.getKey()
								+ " ("
								+ df
										.format(e.getValue() * FACTOR_PERCENT
												/ sum) + "%)"));
			}
		}
		return p;
	}

	/**
	 * Calculates the fractions of the pie chart to create.
	 * 
	 * @param fractions
	 *            the fractions to calculate
	 * @return the sum of all fractions
	 */
	protected abstract double calculateFractions(
			final HashMap<String, Double> fractions);

	/**
	 * Instantiates a Pie object.
	 * 
	 * @param sensorName
	 *            the sensor name
	 * @return the Pie object
	 */
	protected abstract AbstractPie instantiatePie(String sensorName);
}
