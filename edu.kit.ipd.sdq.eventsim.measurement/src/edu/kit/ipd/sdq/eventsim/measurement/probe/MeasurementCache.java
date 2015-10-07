package edu.kit.ipd.sdq.eventsim.measurement.probe;

import java.util.HashMap;
import java.util.Map;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;

public class MeasurementCache<E, T> {

	private Map<MeasuringPointAndTrigger, Measurement<E, T>> measurements;

	public MeasurementCache() {
		this.measurements = new HashMap<>();
	}
	
	public void put(Measurement<E, T> m) {
		measurements.put(new MeasuringPointAndTrigger(m.getWhere(), m.getWho()), m);
	}

	public Measurement<E, T> getLastMeasurement(T t, MeasuringPoint<E> p) {
		return measurements.get(new MeasuringPointAndTrigger(p, t));
	}
	
	private class MeasuringPointAndTrigger {
		
		private MeasuringPoint<E> where;
		
		private T who;
		
		public MeasuringPointAndTrigger(MeasuringPoint<E> where, T who) {
			this.who = who;
			this.where = where;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((where == null) ? 0 : where.hashCode());
			result = prime * result + ((who == null) ? 0 : who.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			MeasuringPointAndTrigger other = (MeasuringPointAndTrigger) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (where == null) {
				if (other.where != null)
					return false;
			} else if (!where.equals(other.where))
				return false;
			if (who == null) {
				if (other.who != null)
					return false;
			} else if (!who.equals(other.who))
				return false;
			return true;
		}

		private MeasurementCache<E, T> getOuterType() {
			return MeasurementCache.this;
		}
		
	}

}
