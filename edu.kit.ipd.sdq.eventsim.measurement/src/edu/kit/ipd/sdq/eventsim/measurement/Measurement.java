package edu.kit.ipd.sdq.eventsim.measurement;

import java.lang.ref.WeakReference;
import java.util.Arrays;

import org.apache.log4j.Logger;


public class Measurement<E, T> {

	private static final Logger log = Logger.getLogger(Measurement.class); 
	
	private Metric what;
	
	private MeasuringPoint<E> where;
	
	private WeakReference<T> who;
	
	private double value;
	
	private double when;
	
	private Object[] metadata;
	
	public Measurement(Metric what, MeasuringPoint<E> where, T who, double value, double when, Object... metadata) {
		this.what = what;
		this.where = where;
		this.who = new WeakReference<T>(who);
		this.value = value;
		this.when = when;
		this.metadata = metadata;
	}

	public Metric getWhat() {
		return what;
	}

	public MeasuringPoint<E> getWhere() {
		return where;
	}

	public T getWho() {
		T trigger = who.get();
//		if(trigger == null) {
//			// TODO refine message
//			log.warn("Trigger of measurement has been garbage-collected already");
//		}
		return trigger;
	}

	public double getWhen() {
		return when;
	}
	
	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Measurement [what=").append(what).append(", where=").append(where).append(", who=").append(who)
				.append(", value=").append(value).append(", when=").append(when).append(", metadata=")
				.append(Arrays.toString(metadata)).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((what == null) ? 0 : what.hashCode());
		temp = Double.doubleToLongBits(when);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		@SuppressWarnings("rawtypes")
		Measurement other = (Measurement) obj;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		if (what != other.what)
			return false;
		if (Double.doubleToLongBits(when) != Double.doubleToLongBits(other.when))
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
	
}
