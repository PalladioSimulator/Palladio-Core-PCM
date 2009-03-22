package de.uka.ipd.sdq.TimerMeter;

public interface IntervalTuple {

	public Long getElementsDifference();

	public Interval getFirstInterval();

	public int getFirstIntervalEndIndex();

	public long getFirstIntervalLength();

	public int getFirstIntervalStartIndex();

	public Interval getSecondInterval();

	public int getSecondIntervalEndIndex();

	public long getSecondIntervalLength();

	public int getSecondIntervalStartIndex();

	public boolean isAreNeighbors();
	
//	IntervalTuple(
//			int firstIntervalStartIndex, 
//			int firstIntervalEndIndex, 
//			int secondIntervalStartIndex, 
//			int secondIntervalEndIndex);

}
