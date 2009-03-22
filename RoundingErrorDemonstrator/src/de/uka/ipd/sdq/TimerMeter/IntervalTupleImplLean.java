package de.uka.ipd.sdq.TimerMeter;

public class IntervalTupleImplLean implements IntervalTuple, Comparable<IntervalTuple>{
	double accuracy;
	boolean areNeighbors;
	long elementsDifference;
	
	int firstIntervalEndIndex;
	long firstIntervalLength;//can be eliminated
	int firstIntervalStartIndex;
	
	boolean roundingNotTruncating;
	
	int secondIntervalEndIndex;
	
	long secondIntervalLength;//can be eliminated
	int secondIntervalStartIndex;
	
	public IntervalTupleImplLean(
			int intervalStartIndexA,
			int intervalEndIndexA,
			int intervalStartIndexB,
			int intervalEndIndexB,
			double accuracy,
			boolean roundingNotTruncating){
		this.accuracy = accuracy;
		this.roundingNotTruncating = roundingNotTruncating;
		if(intervalStartIndexA<intervalStartIndexB){
			this.firstIntervalEndIndex = intervalEndIndexA;
			this.firstIntervalStartIndex = intervalStartIndexA;
			this.secondIntervalEndIndex = intervalEndIndexB;
			this.secondIntervalStartIndex = intervalStartIndexB;
		}else{
			this.firstIntervalEndIndex = intervalEndIndexB;
			this.firstIntervalStartIndex = intervalStartIndexB;
			this.secondIntervalEndIndex = intervalEndIndexA;
			this.secondIntervalStartIndex = intervalStartIndexA;
		}
		long firstIntervalStart;
		long firstIntervalEnd;
		long secondIntervalStart;
		long secondIntervalEnd;
		
		if(roundingNotTruncating){
			firstIntervalStart = Math.round(firstIntervalStartIndex*accuracy);
			firstIntervalEnd = Math.round(firstIntervalEndIndex*accuracy);
			secondIntervalStart = Math.round(secondIntervalStartIndex*accuracy);
			secondIntervalEnd = Math.round(secondIntervalEndIndex*accuracy);
		}else{
			firstIntervalStart = new Double(firstIntervalStartIndex*accuracy).longValue();
			firstIntervalEnd = new Double(firstIntervalEndIndex*accuracy).longValue();
			secondIntervalStart = new Double(secondIntervalStartIndex*accuracy).longValue();
			secondIntervalEnd = new Double(secondIntervalEndIndex*accuracy).longValue();
		}
		
		firstIntervalLength = firstIntervalEnd - firstIntervalStart;
		secondIntervalLength = secondIntervalEnd - secondIntervalStart;
		elementsDifference = secondIntervalLength-firstIntervalLength;
		if(elementsDifference==1){
			areNeighbors = true;
		}
	}
	
	@Override
	public int compareTo(IntervalTuple o) {//TODO rework
		IntervalImpl myFirstInterval = new IntervalImpl(this.accuracy, firstIntervalStartIndex, firstIntervalEndIndex, this.roundingNotTruncating);
		int comparisonFirstInterval = myFirstInterval.compareTo(o.getFirstInterval());
		if(comparisonFirstInterval!=0){
			return comparisonFirstInterval;
		}else{
			int comparisonTupleDifference = this.getElementsDifference().compareTo(o.getElementsDifference());
			return comparisonTupleDifference; //TODO think about better sorting
		}
	}

	public Long getElementsDifference(){
		return elementsDifference;
	}

	@Override
	public Interval getFirstInterval() {
		return new IntervalImpl(this.accuracy, firstIntervalStartIndex, firstIntervalEndIndex, this.roundingNotTruncating);
	}

	@Override
	public int getFirstIntervalEndIndex() {
		return this.firstIntervalEndIndex;
	}

	@Override
	public long getFirstIntervalLength() {
		return firstIntervalLength;
	}

	@Override
	public int getFirstIntervalStartIndex() {
		return this.firstIntervalStartIndex;
	}

	@Override
	public Interval getSecondInterval() {
		return new IntervalImpl(this.accuracy, secondIntervalStartIndex, secondIntervalEndIndex, this.roundingNotTruncating);
	}

	@Override
	public int getSecondIntervalEndIndex() {
		return this.secondIntervalEndIndex;
	}

	@Override
	public long getSecondIntervalLength() {
		return this.secondIntervalLength;
	}

	@Override
	public int getSecondIntervalStartIndex() {
		return this.secondIntervalStartIndex;
	}

	public boolean isAreNeighbors() {
		return areNeighbors;
	}
}
