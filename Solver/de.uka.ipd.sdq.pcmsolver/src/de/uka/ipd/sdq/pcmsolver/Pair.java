package de.uka.ipd.sdq.pcmsolver;

// copied from de.uka.ipd.sdq.dsexplore.helper.Pair
public class Pair<T,S> {
	
	private T first;
	private S second;
	
	public Pair(){
		super();
	}
	
	public Pair(T first, S second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public S getSecond() {
		return second;
	}
	public void setSecond(S second) {
		this.second = second;
	}
	

}