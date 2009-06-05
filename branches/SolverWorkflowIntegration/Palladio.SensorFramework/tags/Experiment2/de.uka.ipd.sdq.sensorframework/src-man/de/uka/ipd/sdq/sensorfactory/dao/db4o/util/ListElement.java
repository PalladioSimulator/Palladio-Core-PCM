package de.uka.ipd.sdq.sensorfactory.dao.db4o.util;

public class ListElement<T> {
	private T data = null;
	private ListElement<T> next = null;
	public ListElement(T data) {
		super();
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ListElement<T> getNext() {
		return next;
	}
	public void setNext(ListElement<T> next) {
		this.next = next;
	}
}
