//package edu.kit.ipd.sdq.eventsim.measurement;
//
//public class Trigger<T> {
//
//	private T element;
//
//	public Trigger(T element) {
//		this.element = element;
//	}
//
//	public T getElement() {
//		return element;
//	}
//	
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Trigger [element=").append(element).append("]");
//		return builder.toString();
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((element == null) ? 0 : element.hashCode());
//		return result;
//	}
//
//	@Override
////	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		@SuppressWarnings("rawtypes")
//		Trigger other = (Trigger) obj;
//		if (element == null) {
//			if (other.element != null)
//				return false;
//		} else if (!element.equals(other.element))
//			return false;
//		return true;
//	}
//
//}
