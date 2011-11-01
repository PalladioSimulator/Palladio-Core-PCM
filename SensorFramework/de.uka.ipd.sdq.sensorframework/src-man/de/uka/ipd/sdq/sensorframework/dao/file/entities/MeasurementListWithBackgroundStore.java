package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.AbstractList;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

public abstract class MeasurementListWithBackgroundStore<T> 
extends AbstractList<Measurement> {

	protected final BackgroundMemoryList<T> measurementsStore;
	protected final BackgroundMemoryList<Double> eventTimes;

	public MeasurementListWithBackgroundStore(
			BackgroundMemoryList<Double> eventTimes,
			BackgroundMemoryList<T> internalStore) {
		super();
		this.eventTimes = eventTimes;
		this.measurementsStore = internalStore;
	}	
	
	@Override
	public abstract Measurement get(int i);

	@Override
	public int size() {
		return measurementsStore.size();
	}
}
