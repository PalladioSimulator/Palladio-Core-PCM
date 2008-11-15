package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsCollection;

public class OutlierFilteredCollection extends AbstractMeasurementsCollection {

	/** The configurations parameter. */
	private double parameter;

	/**
	 * Initializes a new OutlierFilteredCollection with the given measurements and filter parameter.
	 * 
	 * @param originalMeasurements
	 *            The associated measurements.
	 * @param parameter The associated parameter
	 */
	public OutlierFilteredCollection(
			Collection<Measurement> originalMeasurements, double parameter) {
		super(originalMeasurements);
		this.parameter = parameter;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		int outlierNumber = 0;
		outlierNumber = (int) (parameter * originalMeasurements.size());
		ArrayList<TimeSpanMeasurement> sortedMeasurements = (ArrayList<TimeSpanMeasurement>) new ArrayList<TimeSpanMeasurement>();
		for (Iterator<?> it = originalMeasurements.iterator(); it.hasNext();)
			sortedMeasurements.add((TimeSpanMeasurement) it.next());
		Collections.sort(sortedMeasurements,
				new Comparator<TimeSpanMeasurement>() {

					public int compare(TimeSpanMeasurement o1,
							TimeSpanMeasurement o2) {
						return Double.compare(o1.getTimeSpan(), o2
								.getTimeSpan());
					}

				});
		for (int i = sortedMeasurements.size() - 1; i >= sortedMeasurements
				.size()
				- outlierNumber; i--) {
			filteredItemsList.add(sortedMeasurements.get(i));
		}
	}
}
