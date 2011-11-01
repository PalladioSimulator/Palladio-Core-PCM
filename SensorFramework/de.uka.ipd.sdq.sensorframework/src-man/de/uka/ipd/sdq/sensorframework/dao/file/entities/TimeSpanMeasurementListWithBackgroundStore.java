package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

public class TimeSpanMeasurementListWithBackgroundStore extends
		MeasurementListWithBackgroundStore<Double> {

	public TimeSpanMeasurementListWithBackgroundStore(
			BackgroundMemoryList<Double> eventTimes,
			BackgroundMemoryList<Double> internalStore) {
		super(eventTimes, internalStore);
	}

	@Override
	public Measurement get(int i) {
		return new TimeSpanMeasurementImpl(i, eventTimes.get(i), this.measurementsStore.get(i));
	}

}
