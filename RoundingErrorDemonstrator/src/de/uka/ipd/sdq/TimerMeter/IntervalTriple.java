package de.uka.ipd.sdq.TimerMeter;

public class IntervalTriple /*implements Comparable<IntervalTriple>*/{
	private boolean areNeighbors;
	private Interval firstInterval;
	private Interval secondInterval;
	
	private Interval thirdInterval;
	
	public IntervalTriple(Interval a, Interval b, Interval c){
		if(a.compareTo(b)<0 && a.compareTo(c)<0){
			this.firstInterval = a;
			if(b.compareTo(c)<0){
				this.secondInterval = b;
				this.thirdInterval = c;
			}else{
				this.secondInterval = c;
				this.thirdInterval = b;
			}
		}else if(b.compareTo(a)<0 && b.compareTo(c)<0){
			this.firstInterval = b;
			if(a.compareTo(c)<0){
				this.secondInterval = a;
				this.thirdInterval = c;
			}else{
				this.secondInterval = c;
				this.thirdInterval = a;
			}
		}else if(c.compareTo(a)<0 && c.compareTo(b)<0){
			this.firstInterval = c;
			if(a.compareTo(b)<0){
				this.secondInterval = a;
				this.thirdInterval = b;
			}else{
				this.secondInterval = b;
				this.thirdInterval = a;
			}
		}
		if(secondInterval.getDisplayedIntervalLength()-firstInterval.getDisplayedIntervalLength()==1
			&&	thirdInterval.getDisplayedIntervalLength()-secondInterval.getDisplayedIntervalLength()==1){
			areNeighbors = true;
		}
	}
	
	public Long[] getElementsDifference(){
		return new Long[]
		    {
				(secondInterval.getDisplayedIntervalLength()-firstInterval.getDisplayedIntervalLength()),
				(thirdInterval.getDisplayedIntervalLength()-secondInterval.getDisplayedIntervalLength())
			};
	}

//	@Override
//	public int compareTo(IntervalTriple o) {
//		int comparisonFirstInterval = this.firstInterval.compareTo(o.firstInterval);
//		if(comparisonFirstInterval!=0){
//			return comparisonFirstInterval;
//		}else{
//			int comparisonTupleDifference = this.getElementsDifference().compareTo(o.getElementsDifference());
//			return comparisonTupleDifference; //TODO think about better sorting
//		}
//	}

	public Interval getFirstInterval() {
		return firstInterval;
	}

	public Interval getSecondInterval() {
		return secondInterval;
	}

	public Interval getThirdInterval() {
		return thirdInterval;
	}

	public boolean isAreNeighbors() {
		return areNeighbors;
	}
}
