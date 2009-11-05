package de.uka.ipd.sdq.dsexplore.helper;

public class Triple<T,S,R> {
	
	private T first;
	private S second;
	private R third;
	
	public Triple(){
		super();
	}
	
	public Triple(T first, S second, R third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
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
	public R getThird() {
		return third;
	}
	public void setThird(R third) {
		this.third = third;
	}
	
	

}
