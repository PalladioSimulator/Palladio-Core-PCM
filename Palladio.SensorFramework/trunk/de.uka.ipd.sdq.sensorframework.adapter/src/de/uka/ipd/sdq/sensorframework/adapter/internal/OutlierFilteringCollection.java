package de.uka.ipd.sdq.sensorframework.adapter.internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public class OutlierFilteringCollection extends AbstractFilteredMeasurementsCollection {

	private double percentageToRemove;
	public OutlierFilteringCollection(
			Collection<Measurement> originalMeasurements,
			double percentageToRemove) {
		super(originalMeasurements);

		this.percentageToRemove = percentageToRemove;
	}

	@Override
	protected void applyFilter(Collection<Measurement> filteredItemsList) {
		int outlierNumber =(int) ( percentageToRemove * originalMeasurements.size() );
		ArrayList<TimeSpanMeasurement> sortedMeasurements = (ArrayList<TimeSpanMeasurement>)new ArrayList<TimeSpanMeasurement>();
		for(Iterator<?> it = originalMeasurements.iterator(); it.hasNext(); )
			sortedMeasurements.add((TimeSpanMeasurement) it.next());
		Collections.sort(sortedMeasurements, new Comparator<TimeSpanMeasurement>(){

			public int compare(TimeSpanMeasurement o1, TimeSpanMeasurement o2) {
				return Double.compare(o1.getTimeSpan(),o2.getTimeSpan());
			}
			
		});
		for(int i=sortedMeasurements.size()-1; i >= sortedMeasurements.size()-outlierNumber; i--){
			filteredItemsList.add(sortedMeasurements.get(i));
		}
	}
}
