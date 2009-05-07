package de.uka.ipd.sdq.TimerMeter;

public class IntervalTupleImpl implements IntervalTuple, Comparable<IntervalTuple>{
	boolean areNeighbors;
	Interval firstInterval;
	Interval secondInterval;
	
	public IntervalTupleImpl(Interval a, Interval b){
		if(a.compareTo(b)<0){
			this.firstInterval = a;
			this.secondInterval = b;
		}else{
			this.firstInterval = b;
			this.secondInterval = a;
		}
		if(secondInterval.getDisplayedIntervalLength()-firstInterval.getDisplayedIntervalLength()==1){
			areNeighbors = true;
		}
	}
	
	@Override
	public int compareTo(IntervalTuple o) {
		int comparisonFirstInterval = this.firstInterval.compareTo(o.getFirstInterval());
		if(comparisonFirstInterval!=0){
			return comparisonFirstInterval;
		}else{
			int comparisonTupleDifference = this.getElementsDifference().compareTo(o.getElementsDifference());
			return comparisonTupleDifference; //TODO think about better sorting
		}
	}

	public Long getElementsDifference(){
		return secondInterval.getDisplayedIntervalLength()-firstInterval.getDisplayedIntervalLength();
	}

	public Interval getFirstInterval() {
		return firstInterval;
	}

	@Override
	public int getFirstIntervalEndIndex() {
		return firstInterval.getIntervalEndIndex();
	}

	@Override
	public long getFirstIntervalLength() {
		return firstInterval.getDisplayedIntervalLength();
	}

	@Override
	public int getFirstIntervalStartIndex() {
		return firstInterval.getIntervalStartIndex();
	}

	public Interval getSecondInterval() {
		return secondInterval;
	}

	@Override
	public int getSecondIntervalEndIndex() {
		return secondInterval.getIntervalEndIndex();
	}

	@Override
	public long getSecondIntervalLength() {
		return secondInterval.getDisplayedIntervalLength();
	}

	@Override
	public int getSecondIntervalStartIndex() {
		return secondInterval.getIntervalStartIndex();
	}

	public boolean isAreNeighbors() {
		return areNeighbors;
	}
}
