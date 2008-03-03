package de.uka.ipd.sdq.sensorframework.filter;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

public abstract class AbstractMeasurementsFilter extends
		AbstractCollection<Measurement> {

	protected Collection<Measurement> originalMeasurements = null;
	private ArrayList<Measurement> filteredItems = null;
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<Measurement> iterator() {
		if (filteredItems == null) {
			filteredItems = new ArrayList<Measurement>();
			applyFilter(filteredItems);
		}
		return new Iterator<Measurement>(){
			Iterator<Measurement> it = originalMeasurements.iterator();
			int current = 0, alreadyReturned = 0;
			
			public boolean hasNext() {
				return current < originalMeasurements.size() && alreadyReturned < size();
			}
	
			public Measurement next() {
				Measurement next;
				while ( filteredItems.contains(next = it.next()) )
					current++;
				current++; alreadyReturned++;
				return next;
			}
	
			public void remove() {
			}
		};
	}

	protected abstract void applyFilter(Collection<Measurement> filteredItemsList);

	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		if (filteredItems == null) {
			filteredItems = new ArrayList<Measurement>();
			applyFilter(filteredItems);
		}
		return originalMeasurements.size() - filteredItems.size();
	}

	public Collection<Measurement> getOriginalMeasurements()
			throws InstantiationException {
		if (originalMeasurements == null)
			throw new InstantiationException("Value 'parameter' not be set!");
		return originalMeasurements;
	}

	public void setOriginalMeasurements(Collection<Measurement> originalMeasurements) {
		this.originalMeasurements = originalMeasurements;
	}
	
	/**
	 * Get the parameter used to configure the filter
	 * 
	 * @return This adapters properties
	 */
	abstract public FilterParameter<?> getParameter(); 
	
	/**
	 * Set the filter parameter. Parameter can be used to control the
	 * filter/histogram
	 * 
	 * @param newProperties
	 *            The new properties to be used in this adapter
	 */
	abstract public void setParameter(FilterParameter<?> parameter);
}