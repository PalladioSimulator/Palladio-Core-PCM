package de.uka.ipd.sdq.TimerMeter;

public class IntervalTuple implements Comparable<IntervalTuple>{
	private Interval firstInterval;
	private Interval secondInterval;
	
	private boolean areNeighbors;
	
	public IntervalTuple(Interval a, Interval b){
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
	
	public Long getElementsDifference(){
		return secondInterval.getDisplayedIntervalLength()-firstInterval.getDisplayedIntervalLength();
	}

	@Override
	public int compareTo(IntervalTuple o) {
		int comparisonFirstInterval = this.firstInterval.compareTo(o.firstInterval);
		if(comparisonFirstInterval!=0){
			return comparisonFirstInterval;
		}else{
			int comparisonTupleDifference = this.getElementsDifference().compareTo(o.getElementsDifference());
			return comparisonTupleDifference; //TODO think about better sorting
		}
	}

	public Interval getFirstInterval() {
		return firstInterval;
	}

	public Interval getSecondInterval() {
		return secondInterval;
	}

	public boolean isAreNeighbors() {
		return areNeighbors;
	}
}
