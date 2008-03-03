package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;

public class OutlierFilteringCollection extends
		AbstractMeasurementsFilter {
	
	private FilterParameter<Double> parameter; 
	
	public OutlierFilteringCollection() {
		parameter = new FilterParameter<Double>(0.1, "Outlier removal");
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.internal.AbstractFilteredMeasurementsCollection#applyFilter(java.util.Collection)
	 */
	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		int outlierNumber = 0;

		outlierNumber = (int) (getParameter().getValue() * originalMeasurements.size());
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

	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.filter.AbstractFilteredMeasurementsCollection#getParameter()
	 */
	@Override
	public FilterParameter<Double> getParameter() {
		return parameter;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.filter.AbstractFilteredMeasurementsCollection#setParameter(de.uka.ipd.sdq.sensorframework.filter.FilterParameter)
	 */
	@Override
	public
	void setParameter(FilterParameter<?> parameter) {
		this.parameter =  (FilterParameter<Double>) parameter;
	}
}
