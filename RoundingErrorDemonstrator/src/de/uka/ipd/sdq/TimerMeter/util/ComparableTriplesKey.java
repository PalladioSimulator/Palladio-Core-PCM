package de.uka.ipd.sdq.TimerMeter.util;

public class ComparableTriplesKey implements Comparable<ComparableTriplesKey>{
	private Double accuracy;
	public Double getAccuracy() {
		return accuracy;
	}

	private int indexOfTriple;
	private boolean isFromDistancesNotFromValues;
	
	@Override
	public int compareTo(ComparableTriplesKey o) {
		return accuracy.compareTo(o.getAccuracy());
	}
	
	public int getIndexOfTriple() {
		return indexOfTriple;
	}

	public boolean isFromDistancesNotFromValues() {
		return isFromDistancesNotFromValues;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public void setFromDistancesNotFromValues(boolean isFromDistancesNotFromValues) {
		this.isFromDistancesNotFromValues = isFromDistancesNotFromValues;
	}

	public void setIndexOfTriple(int indexOfTriple) {
		this.indexOfTriple = indexOfTriple;
	}
	
	public String toString(){
		if(isFromDistancesNotFromValues){
			return new String("{"+this.accuracy+",distances,"+this.indexOfTriple+"}");
		}else{
			return new String("{"+this.accuracy+",values,"+this.indexOfTriple+"}");
		}
	}
}
