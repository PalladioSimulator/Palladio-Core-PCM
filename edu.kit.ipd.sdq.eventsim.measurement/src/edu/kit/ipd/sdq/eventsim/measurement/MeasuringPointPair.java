package edu.kit.ipd.sdq.eventsim.measurement;

public class MeasuringPointPair<T, U> extends MeasuringPoint<Pair<T, U>> {

	public MeasuringPointPair(T first, U second, String property, Object... contexts) {
		super(new Pair<>(first, second), property, contexts);
	}

}
