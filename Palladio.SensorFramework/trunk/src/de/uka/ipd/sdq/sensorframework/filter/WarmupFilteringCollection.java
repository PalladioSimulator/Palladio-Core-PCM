package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;

public class WarmupFilteringCollection extends
		AbstractMeasurementsFilter {

	private FilterParameter<Long> parameter; 
	
	public WarmupFilteringCollection() {
		/** Default number of measurements to skip. */
		parameter = new FilterParameter<Long>(2500L, "Warm Up");
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.internal.AbstractFilteredMeasurementsCollection#applyFilter(java.util.Collection)
	 */
	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		Iterator<Measurement> it = originalMeasurements.iterator();
		
		for(int i=0; i < originalMeasurements.size() && i < parameter.getValue(); i++){
			Measurement m = it.next();
			filteredItemsList.add(m);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.filter.AbstractFilteredMeasurementsCollection#getParameter()
	 */
	@Override
	public FilterParameter<Long> getParameter() {
		return parameter;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.filter.AbstractFilteredMeasurementsCollection#setParameter(de.uka.ipd.sdq.sensorframework.filter.FilterParameter)
	 */
	@Override
	public
	void setParameter(FilterParameter<?> parameter) {
		this.parameter = (FilterParameter<Long>) parameter;
	}
}
