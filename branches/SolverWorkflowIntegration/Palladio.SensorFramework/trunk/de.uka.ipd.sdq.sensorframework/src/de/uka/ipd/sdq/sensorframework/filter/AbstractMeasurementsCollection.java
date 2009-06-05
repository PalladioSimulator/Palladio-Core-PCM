package de.uka.ipd.sdq.sensorframework.filter;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * Superclass for all filtered collection in the SensorFramework.
 * @author Roman Andrej
 */
public abstract class AbstractMeasurementsCollection extends
		AbstractCollection<Measurement> {

	/** Original collection. */
	protected Collection<Measurement> originalMeasurements = null;
	
	/** Filtered collection. */
	private ArrayList<Measurement> filteredItems = null;

	/**
	 * Initializes a new AbstractMeasurementsCollection.
	 */
	public AbstractMeasurementsCollection(){
	}
	
	/**
	 * Initializes a new AbstractMeasurementsCollection.
	 * 
	 * @param originalMeasurements
	 *            The associated measurements.
	 */
	public AbstractMeasurementsCollection(
			Collection<Measurement> originalMeasurements) {
		this.originalMeasurements = originalMeasurements;
	}
	
	/** {@inheritDoc}
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

	/** The Method filtered the measurements. */
	protected abstract void applyFilter(Collection<Measurement> filteredItemsList);

	
	/** {@inheritDoc}
	 */
	@Override
	public int size() {
		if (filteredItems == null) {
			filteredItems = new ArrayList<Measurement>();
			applyFilter(filteredItems);
		}
		return originalMeasurements.size() - filteredItems.size();//TODO does it make sense? or does "filteredItems" contain items filtered AWAY, not items remaining AFTER filtering?
	}

	/**
	 * Get the original collection.
	 */
	public Collection<Measurement> getOriginalMeasurements()
			throws InstantiationException {
		if (originalMeasurements == null)
			throw new InstantiationException("Value 'parameter' not be set!");
		return originalMeasurements;
	}

	/**
	 * Resets internally stored filtered items to <code>null</code>
	 */
	public void resetFilteredItems(){
		filteredItems = null;
	}
}