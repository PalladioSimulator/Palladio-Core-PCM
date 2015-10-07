package edu.kit.ipd.sdq.eventsim.measurement;


public class Measurement<E, T> {

	private Metric what;
	
	private MeasuringPoint<E> where;
	
	private T who;
	
	private double measurement;
	
	private double when;
	
	public Measurement(Metric what, MeasuringPoint<E> where, T who, double measurement, double when) {
		this.what = what;
		this.where = where;
		this.who = who;
		this.measurement = measurement;
		this.when = when;
	}

	public Metric getWhat() {
		return what;
	}

	public MeasuringPoint<E> getWhere() {
		return where;
	}

	public T getWho() {
		return who;
	}

	public double getWhen() {
		return when;
	}
	
	public double getMeasurement() {
		return measurement;
	}

	@Override
	public String toString() {
		return "Measurement [what=" + what + ", where=" + where + ", who=" + who + ", measurement=" + measurement
				+ ", when=" + when + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(measurement);
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
		if (Double.doubleToLongBits(measurement) != Double.doubleToLongBits(other.measurement))
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
