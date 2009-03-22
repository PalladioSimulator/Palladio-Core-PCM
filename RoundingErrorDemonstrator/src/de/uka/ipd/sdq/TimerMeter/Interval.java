package de.uka.ipd.sdq.TimerMeter;

public interface Interval {

	public int compareTo(Interval o);

	public Double getAccuracy();

	public long getDisplayedIntervalEnd();

	public long getDisplayedIntervalLength();

	public long getDisplayedIntervalStart();

	public int getIntervalEndIndex();

	public int getIntervalStartIndex();

	public double getRealIntervalEnd();

	public double getRealIntervalLength();

	public double getRealIntervalStart();

	public Boolean getRoundedNotTruncated();
}
