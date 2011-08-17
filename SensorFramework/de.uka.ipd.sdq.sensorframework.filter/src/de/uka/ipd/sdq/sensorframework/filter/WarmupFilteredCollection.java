package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

public class WarmupFilteredCollection extends
		AbstractMeasurementsCollection {

	private long parameter;
	
	/**
	 * Initializes a new WarmupFilteredCollection with the given measurements and filter parameter.
	 * 
	 * @param originalMeasurements
	 *            The associated measurements.
	 * @param parameter The associated parameter
	 */
	public WarmupFilteredCollection(
			Collection<Measurement> originalMeasurements, long parameter) {
		super(originalMeasurements);
		this.parameter = parameter;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		Iterator<Measurement> it = originalMeasurements.iterator();

		for (int i = 0; i < originalMeasurements.size()
				&& i < parameter; i++) {
			Measurement m = it.next();
			filteredItemsList.add(m);
		}
	}
}
