package de.uka.ipd.sdq.TimerMeter;

public class IntervalImpl implements Interval, Comparable<Interval>{
	private Double accuracy;
	//	Double epsilon;
	//	private long displayedIntervalEnd;//TODO rationalise away
	//	private double realIntervalEnd;//TODO rationalise away
	private long displayedIntervalLength;
	//	private double realIntervalLength;//TODO rationalise away

	//	private long displayedIntervalStart;//TODO rationalise away
	//	private double realIntervalStart;//TODO rationalise away
	private int intervalEndIndex;
	private int intervalStartIndex;
	private Boolean roundedNotTruncated;
	
	public IntervalImpl(
			Double accuracy, 
			int intervalStartIndex, 
			int intervalEndIndex, 
			Boolean roundedNotTruncated){
		this.accuracy = accuracy;
		this.intervalStartIndex = intervalStartIndex;
		this.intervalEndIndex = intervalEndIndex;
		this.roundedNotTruncated = roundedNotTruncated;
		
		/*this.*/double realIntervalStart = this.intervalStartIndex*this.accuracy;
		/*this.*/double realIntervalEnd = this.intervalEndIndex*this.accuracy;
//		/*this.*/double realIntervalLength = /*this.*/realIntervalEnd - /*this.*/realIntervalStart;
		long displayedIntervalStart;
		long displayedIntervalEnd;
		if(roundedNotTruncated){
			/*this.*/displayedIntervalStart = Math.round(/*this.*/realIntervalStart);
		}else{
			/*this.*/displayedIntervalStart = new Double(realIntervalStart).longValue();
		}
		if(roundedNotTruncated){
			/*this.*/displayedIntervalEnd = Math.round(/*this.*/realIntervalEnd);
		}else{
			/*this.*/displayedIntervalEnd = new Double(realIntervalEnd).longValue();
		}
		this.displayedIntervalLength = /*this.*/displayedIntervalEnd - /*this.*/displayedIntervalStart;
	}

	@Override
	public int compareTo(Interval o) {
		int accuracyComparison = new Double(this.getAccuracy()).compareTo(o.getAccuracy());
		if(accuracyComparison!=0){
			return accuracyComparison;
		}
		int lengthComparison = new Long(this.displayedIntervalLength).compareTo(o.getDisplayedIntervalLength());
		if(lengthComparison!=0){
			return lengthComparison;
		}else{
			if(this.getIntervalStartIndex()<o.getIntervalStartIndex()){
				return -1;
			}else if(this.getIntervalStartIndex()>o.getIntervalStartIndex()){
				return 1;
			}else{ 
				if(this.getIntervalEndIndex()<o.getIntervalEndIndex()){
					return -1;
				}else if(this.getIntervalEndIndex()>o.getIntervalEndIndex()){
					return 1;
				}else{
					return 0;
				}
			}
		}
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public long getDisplayedIntervalEnd() {
		double realIntervalEnd = this.intervalEndIndex*this.accuracy;
		if(roundedNotTruncated){
			return Math.round(realIntervalEnd);
		}else{
			return new Double(realIntervalEnd).longValue();
		}
	}

	public long getDisplayedIntervalLength() {
		return displayedIntervalLength;
	}

	public long getDisplayedIntervalStart() {
		double realIntervalStart = this.intervalStartIndex*this.accuracy;
		if(roundedNotTruncated){
			return Math.round(realIntervalStart);
		}else{
			return new Double(realIntervalStart).longValue();
		}
	}

	public int getIntervalEndIndex() {
		return intervalEndIndex;
	}

	public int getIntervalStartIndex() {
		return intervalStartIndex;
	}

	public double getRealIntervalEnd() {
		return this.intervalEndIndex*this.accuracy;
	}

	public double getRealIntervalLength() {
		return this.intervalEndIndex*this.accuracy - this.intervalStartIndex*this.accuracy;
	}

	public double getRealIntervalStart() {
		return this.intervalStartIndex*this.accuracy;
	}

	public Boolean getRoundedNotTruncated() {
		return roundedNotTruncated;
	}

}
