package de.uka.ipd.sdq.sensorframework.adapter.internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class WarmupFilteringCollection extends AbstractFilteredMeasurementsCollection {

	private long count;
	
	public WarmupFilteringCollection(
			Collection<Measurement> originalMeasurements,
			long numberOfMeasurementsToSkip) {
		super(originalMeasurements);

		this.count = numberOfMeasurementsToSkip;
	}

	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		Iterator<Measurement> it = originalMeasurements.iterator();
		for(int i=0; i < originalMeasurements.size() && i < count; i++){
			Measurement m = it.next();
			filteredItemsList.add(m);
		}
	}
}
