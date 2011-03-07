package de.uka.ipd.sdq.sensorframework.adapter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**Provides an adapter that allows to convert StateSensors to Pies.
 * @author Henning Groenda
 */
public class StateSensorToPieAdapter extends DataAdapter {

	/** Factor to display values in percent. */
	private static final int FACTOR_PERCENT = 100;
	
	/** Information about the StateSensor and the measurements. */
	private SensorAndMeasurements samInformation;

	/**Initializes the adapter with the given StateSensor measurements. 
	 * @param samInformation Information about the StateSensor and the 
	 * measurements.
	 */
	public StateSensorToPieAdapter(final SensorAndMeasurements samInformation) {
		super();
		this.samInformation = samInformation;
	}

	/** Creates a map of states associated to the time the respective state was active in the complete set of 
	 * state measurements
	 * @param timeSums The hashmap to fill with data
	 * @return The total sum of all the time spend in all states
	 */
	private double calculateTimeSums(final HashMap<String, Double> timeSums) {
		for (State state : (
				(StateSensor) samInformation.getSensor()).getSensorStates()) {
			timeSums.put(state.getStateLiteral(), 0.0);
		}
		double lastChangeTime = 0.0; 
		State lastState = 
			((StateSensor) samInformation.getSensor()).getInitialState();
		double sum = 0;
		for (Measurement m : samInformation.getMeasurements()) {
			StateMeasurement sm = (StateMeasurement) m;
			Double oldValue = timeSums.get(lastState.getStateLiteral());
			double diff = sm.getEventTime() - lastChangeTime;
			double newValue = oldValue + diff;
			sum += diff;
			timeSums.put(lastState.getStateLiteral(), newValue);

			lastChangeTime = sm.getEventTime();
			lastState = sm.getSensorState();
		}
		return sum;
	}
	
	/** Takes sum of the time in which all states were active and creates a Pie from it 
	 * @param timeSums A map which associates to each state the sum of the time this state has been active
	 * @param sum Total sum of times 
	 * @return A pie representation of the data
	 */
	private Pie createPie(final HashMap<String, Double> timeSums, 
			final double sum) {
		Pie p = new Pie((
				(StateSensor) samInformation.getSensor()).getSensorName());
		DecimalFormat df = 
			new DecimalFormat("#0.0", new DecimalFormatSymbols(Locale.US));
		for (Entry < String, Double > e : timeSums.entrySet()) {
			if (e.getValue() > 0.0) {
				p.addEntity(new PieEntity(e.getValue(), e.getKey() 
					+ " (" + df.format(e.getValue() * FACTOR_PERCENT / sum) 
					+ "%)"));
			}
		}
		return p;
	}

	/** {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		HashMap<String, Double> newPie = new HashMap<String, Double>(); 
		double sum = calculateTimeSums(newPie);
		
		return createPie(newPie, sum);
	}
}
