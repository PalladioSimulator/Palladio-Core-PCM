

public class ComparableDistanceTuplesKeyValuePair extends TimerMeterSomething implements Comparable<ComparableDistanceTuplesKeyValuePair>{
//	private int indexOfTriple;

//	private boolean isFromDistancesNotFromValues;
//	private Long[] triple;
	private Long firstDistance;
	private Long secondDistance;
	@Override
	
	public int compareTo(ComparableDistanceTuplesKeyValuePair o) {
		if(accuracy!=null){
			return accuracy.compareTo(o.getAccuracy());
		}
		else if(firstDistance!=null && o.getFirstDistance()!=null){
			return firstDistance.compareTo(o.getFirstDistance());
		}else if(secondDistance!=null && o.getSecondDistance()!=null){
			return secondDistance.compareTo(o.getSecondDistance());
//		else if(triple!=null 
//				&& triple.length==3 
//				&& triple[0]!=null 
//				&& triple[1]!=null 
//				&& triple[2]!=null){
//			return triple[0].compareTo(o.getTriple()[0]);
		}else{
			return 0;//TODO
		}
	}
	
	
//	public int getIndexOfTriple() {
//		return indexOfTriple;
//	}
//
//	public Long[] getTriple() {
//		return triple;
//	}
//
//	public boolean isFromDistancesNotFromValues() {
//		return isFromDistancesNotFromValues;
//	}
//

//	public void setFromDistancesNotFromValues(boolean isFromDistancesNotFromValues) {
//		this.isFromDistancesNotFromValues = isFromDistancesNotFromValues;
//	}
//	
//	public void setIndexOfTriple(int indexOfTriple) {
//		this.indexOfTriple = indexOfTriple;
//	}
//
//	public void setTriple(Long[] triple) {
//		this.triple = triple;
//	}

	public String toString(){
//		if(isFromDistancesNotFromValues){
			return new String("<{"+this.accuracy+",distances}," +
					"{"+this.firstDistance+","+this.secondDistance+"}>");
//		}else{
//			return new String("{"+this.accuracy+",values,"+this.indexOfTriple+"}");
//		}
	}

	public Long getFirstDistance() {
		return firstDistance;
	}

	public void setFirstDistance(Long firstDistance) {
		this.firstDistance = firstDistance;
	}

	public void setTuple(Long[] tuple) {
		if(tuple==null || tuple.length<2){
			this.firstDistance = Long.MIN_VALUE;
			this.secondDistance = Long.MIN_VALUE;
		}else{//TODO document ignoring indexes 2 and larger
			this.firstDistance = tuple[0];
			this.secondDistance = tuple[1];
		}
	}

	public Long[] getTuple() {
		if(this.firstDistance == Long.MIN_VALUE || this.secondDistance == Long.MIN_VALUE){
			return null;
		}else{//TODO document ignoring indexes 2 and larger
			return new Long[]{this.firstDistance, this.secondDistance};
		}
	}

	public Long getSecondDistance() {
		return secondDistance;
	}

	public void setSecondDistance(Long secondDistance) {
		this.secondDistance = secondDistance;
	}
}
