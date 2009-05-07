package de.uka.ipd.sdq.TimerMeter;

public class IntervalImplFat extends IntervalImpl{
	private Double accuracy;
//	Double epsilon;
	private long displayedIntervalEnd;//TODO rationalise away

	private long displayedIntervalLength;
	private long displayedIntervalStart;//TODO rationalise away
	private int intervalEndIndex;
	private int intervalStartIndex;
	private double realIntervalEnd;//TODO rationalise away
	private double realIntervalLength;//TODO rationalise away
	private double realIntervalStart;//TODO rationalise away
	private Boolean roundedNotTruncated;
	
	public String toString(){ 
		StringBuffer sb = new StringBuffer();
		if(roundedNotTruncated) sb.append("R{"); else sb.append("T{"); 
		sb.append(accuracy+"*["+intervalStartIndex+";"+intervalStartIndex+"]~");
		sb.append(displayedIntervalLength);
		sb.append("}"); 
		return sb.toString();
	}

	public IntervalImplFat(
			Double accuracy, 
			int intervalStartIndex, 
			int intervalEndIndex, 
			Boolean roundedNotTruncated){
		super(accuracy,intervalStartIndex, intervalEndIndex, roundedNotTruncated);
		
		this.realIntervalStart = this.intervalStartIndex*this.accuracy;
		this.realIntervalEnd = this.intervalEndIndex*this.accuracy;
		this.realIntervalLength = this.realIntervalEnd - this.realIntervalStart;

		if(roundedNotTruncated){
			this.displayedIntervalStart = Math.round(this.realIntervalStart);
		}else{
			this.displayedIntervalStart = new Double(this.realIntervalStart).longValue();
		}
		if(roundedNotTruncated){
			this.displayedIntervalEnd = Math.round(this.realIntervalEnd);
		}else{
			this.displayedIntervalEnd = new Double(this.realIntervalEnd).longValue();
		}
		this.displayedIntervalLength = this.displayedIntervalEnd - this.displayedIntervalStart;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public long getDisplayedIntervalEnd() {
		return displayedIntervalEnd;
	}

	public long getDisplayedIntervalLength() {
		return displayedIntervalLength;
	}

	//	@Override
//	public int compareTo(IntervalImplFat o) {
//		int accuracyComparison = new Double(this.getAccuracy()).compareTo(o.getAccuracy());
//		if(accuracyComparison!=0){
//			return accuracyComparison;
//		}
//		int lengthComparison = new Long(this.displayedIntervalLength).compareTo(o.getDisplayedIntervalLength());
//		if(lengthComparison!=0){
//			return lengthComparison;
//		}else{
//			if(this.getIntervalStartIndex()<o.getIntervalStartIndex()){
//				return -1;
//			}else if(this.getIntervalStartIndex()>o.getIntervalStartIndex()){
//				return 1;
//			}else{ 
//				if(this.getIntervalEndIndex()<o.getIntervalEndIndex()){
//					return -1;
//				}else if(this.getIntervalEndIndex()>o.getIntervalEndIndex()){
//					return 1;
//				}else{
//					return 0;
//				}
//			}
//		}
//	}
//
	public long getDisplayedIntervalStart() {
		return displayedIntervalStart;
	}

	public int getIntervalEndIndex() {
		return intervalEndIndex;
	}

public int getIntervalStartIndex() {
		return intervalStartIndex;
	}

	public double getRealIntervalEnd() {
		return realIntervalEnd;
	}

	public double getRealIntervalLength() {
		return realIntervalLength;
	}

	public double getRealIntervalStart() {
		return realIntervalStart;
	}

	public Boolean getRoundedNotTruncated() {
		return roundedNotTruncated;
	}
}
