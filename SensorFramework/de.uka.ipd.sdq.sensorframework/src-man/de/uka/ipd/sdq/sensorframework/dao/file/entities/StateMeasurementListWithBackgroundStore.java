package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

public class StateMeasurementListWithBackgroundStore extends
		MeasurementListWithBackgroundStore<State> {

	public StateMeasurementListWithBackgroundStore(
			BackgroundMemoryList<Double> eventTimes, BackgroundMemoryList<State> internalStore) {
		super(eventTimes, internalStore);
	}

	@Override
	public Measurement get(int i) {
		return new StateMeasurementImpl(i, eventTimes.get(i), measurementsStore.get(i));
	}
}
