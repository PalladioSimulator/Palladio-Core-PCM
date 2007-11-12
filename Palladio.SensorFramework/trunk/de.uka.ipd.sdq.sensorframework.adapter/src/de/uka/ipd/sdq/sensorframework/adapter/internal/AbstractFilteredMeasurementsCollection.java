package de.uka.ipd.sdq.sensorframework.adapter.internal;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public abstract class AbstractFilteredMeasurementsCollection extends
		AbstractCollection<Measurement> {

	protected Collection<Measurement> originalMeasurements = null;
	private ArrayList<Measurement> filteredItems = null;

	public AbstractFilteredMeasurementsCollection(Collection<Measurement> originalMeasurements) {
		super();
		this.originalMeasurements = originalMeasurements;
	}

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

	@Override
	public int size() {
		if (filteredItems == null) {
			filteredItems = new ArrayList<Measurement>();
			applyFilter(filteredItems);
		}
		return originalMeasurements.size() - filteredItems.size();
	}

}