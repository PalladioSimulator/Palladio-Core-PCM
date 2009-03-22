package de.uka.ipd.sdq.TimerMeter;

public interface Interval {

	public int compareTo(Interval o);

	public Double getAccuracy();

	public Boolean getRoundedNotTruncated();

	public int getIntervalStartIndex();

	public int getIntervalEndIndex();

	public long getDisplayedIntervalLength();

	public long getDisplayedIntervalStart();

	public double getRealIntervalStart();

	public long getDisplayedIntervalEnd();

	public double getRealIntervalEnd();

	public double getRealIntervalLength();
}
