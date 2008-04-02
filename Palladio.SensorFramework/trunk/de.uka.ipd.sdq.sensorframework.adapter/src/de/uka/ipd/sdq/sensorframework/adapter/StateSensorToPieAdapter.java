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
 * @author groenda
 */
public class StateSensorToPieAdapter extends DataAdapter {

	/** Factor to display values in percent. */
	private static final int PERCENT_FACTOR = 100;
	
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

	/** {@inheritDoc}
	 */
	public Object getAdaptedObject() {
		Pie p = new Pie(((StateSensor) 
				samInformation.getSensor()).getSensorName());
		HashMap<String, Double> newPie = new HashMap<String, Double>(); 
		for (State state : ((StateSensor) 
				samInformation.getSensor()).getSensorStates()) {
			newPie.put(state.getStateLiteral(), 0.0);
		}
		double lastChangeTime = 0.0; State lastState = ((StateSensor) 
				samInformation.getSensor()).getInitialState();
		double sum = 0;
		for (Measurement m : samInformation.getMeasurements()) {
			StateMeasurement sm = (StateMeasurement) m;
			Double oldValue = newPie.get(lastState.getStateLiteral());
			double diff = sm.getEventTime() - lastChangeTime;
			double newValue = oldValue + diff;
			sum += diff;
			newPie.put(lastState.getStateLiteral(), newValue);

			lastChangeTime = sm.getEventTime();
			lastState = sm.getSensorState();
		}
		DecimalFormat df = new DecimalFormat("#0.0", 
				new DecimalFormatSymbols(Locale.US));
		for (Entry < String, Double > e : newPie.entrySet()) {
			p.addEntity(new PieEntity(e.getValue(), e.getKey() + " (" 
					+ df.format(e.getValue() * PERCENT_FACTOR / sum) + "%)"));
		}
		return p;
	}
}
