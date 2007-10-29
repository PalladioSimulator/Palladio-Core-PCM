package de.uka.ipd.sdq.sensorframework.adapter.internal;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

class FilteredMeasurementsCollection extends AbstractCollection<Measurement> {

	private Collection<Measurement> originalMeasurements = null;
	private double percentageToRemove;
	private ArrayList<TimeSpanMeasurement> outlier = new ArrayList<TimeSpanMeasurement>();
	
	public FilteredMeasurementsCollection(
			Collection<Measurement> originalMeasurements,
			double percentageToRemove) {
		super();
		this.originalMeasurements = originalMeasurements;
		this.percentageToRemove = percentageToRemove;
		findOutlier();
	}

	private void findOutlier() {
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
			outlier.add(sortedMeasurements.get(i));
		}
	}

	@Override
	public Iterator<Measurement> iterator() {
		return new Iterator<Measurement>(){
			Iterator<Measurement> it = originalMeasurements.iterator();
			int current = 0;
			
			public boolean hasNext() {
				return current < size();
			}

			public Measurement next() {
				Measurement next;
				while ( outlier.contains(next = it.next()) )
					current++;
				current++;
				return next;
			}

			public void remove() {
			}
		};
	}

	@Override
	public int size() {
		return originalMeasurements.size() - outlier.size();
	}
	
}

public class OutlierRemovingAdapterTimeSpanSensor implements IAdapter {

	private Properties myProperties = new Properties();
	private SensorAndMeasurements sam;

	public OutlierRemovingAdapterTimeSpanSensor(SensorAndMeasurements sensorAndMeasurements){
		this.sam = sensorAndMeasurements;
	}

	public Object getAdaptedObject() {
		SensorAndMeasurements result = new SensorAndMeasurements(sam.getSensor(),
			new FilteredMeasurementsCollection(sam.getMeasurements(),0.1));
		
		return result;
	}

	public Properties getProperties() {
		return myProperties;
	}

	public void setProperties(Properties arg0) {
		myProperties = arg0;
	}

}
