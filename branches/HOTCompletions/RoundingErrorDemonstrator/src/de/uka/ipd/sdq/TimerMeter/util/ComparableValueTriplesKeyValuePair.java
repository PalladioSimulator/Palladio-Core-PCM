package de.uka.ipd.sdq.TimerMeter.util;
import java.util.Arrays;



public class ComparableValueTriplesKeyValuePair extends TimerMeterSomething implements Comparable<ComparableValueTriplesKeyValuePair>{
//	private Double accuracy;
	private int indexOfTriple;

//	private boolean isFromDistancesNotFromValues;
	private Long[] triple;
	
	@Override
	public int compareTo(ComparableValueTriplesKeyValuePair o) {
		if(accuracy!=null){
			return accuracy.compareTo(o.getAccuracy());
		}else if(triple!=null 
				&& triple.length==3 
				&& triple[0]!=null 
				&& triple[1]!=null 
				&& triple[2]!=null){
			return triple[0].compareTo(o.getTriple()[0]);
		}else{
			return 0;//TODO
		}
	}
	
//	public Double getAccuracy() {
//		return accuracy;
//	}
	
	public int getIndexOfTriple() {
		return indexOfTriple;
	}

	public Long[] getTriple() {
		return triple;
	}

//	public boolean isFromDistancesNotFromValues() {
//		return isFromDistancesNotFromValues;
//	}

//	public void setAccuracy(Double accuracy) {
//		this.accuracy = accuracy;
//	}

//	public void setFromDistancesNotFromValues(boolean isFromDistancesNotFromValues) {
//		this.isFromDistancesNotFromValues = isFromDistancesNotFromValues;
//	}
	
	public void setIndexOfTriple(int indexOfTriple) {
		this.indexOfTriple = indexOfTriple;
	}

	public void setTriple(Long[] triple) {
		this.triple = triple;
	}

	public String toString(){
//		if(isFromDistancesNotFromValues){
//			return new String("{"+this.accuracy+",distances,"+this.indexOfTriple+"}");
//		}else{
			return new String("<{"+this.accuracy+",values,"+this.indexOfTriple+"}," +
					Arrays.toString(this.triple)+">");
//		}
	}
}
