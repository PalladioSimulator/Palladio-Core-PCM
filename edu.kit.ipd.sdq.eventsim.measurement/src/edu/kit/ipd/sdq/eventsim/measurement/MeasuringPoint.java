package edu.kit.ipd.sdq.eventsim.measurement;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.palladiosimulator.pcm.core.entity.Entity;

public class MeasuringPoint<E> {

	private E element;

	private String property;

	private Set<Object> contexts;

	public MeasuringPoint(E element, String property, Object... contexts) {
		this.element = element;
		this.property = property;
		this.contexts = new HashSet<Object>(4);
		
		// create set from contexts array
		for(Object c : contexts) {
			this.contexts.add(c);	
		}
	}

	public MeasuringPoint(E element, Object... contexts) {
		this(element, "", contexts);
	}

	public E getElement() {
		return element;
	}
	
	public String getProperty() {
		return property;
	}

	public Set<Object> getContexts() {
		return Collections.unmodifiableSet(contexts);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MeasuringPoint [element=").append(toString(element)).append(", property=").append(property)
				.append(", contexts=").append(toString(contexts)).append("]");
		return builder.toString();
	}

	private String toString(Object o) {
		if (Entity.class.isInstance(o)) {
			Entity entity = (Entity) o;
			final StringBuilder builder = new StringBuilder();
			builder.append(entity.getEntityName());
			builder.append(" <");
			builder.append(entity.eClass().getName());
			builder.append("> ");
			builder.append(" [ID: ");
			builder.append(entity.getId());
			builder.append("]");
			return builder.toString();
		} else {
			return o.toString();
		}
	}
	
	private String toString(Set<Object> objects) {
		StringBuilder b = new StringBuilder().append("[");
		for(Object o : objects) {
			b.append(toString(o)).append(",");
		}
		if (b.length() > 1)
			b.deleteCharAt(b.length() - 1);
		b.append("]");
		return b.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contexts == null) ? 0 : contexts.hashCode());
		result = prime * result + ((element == null) ? 0 : element.hashCode());
		result = prime * result + ((property == null) ? 0 : property.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		MeasuringPoint other = (MeasuringPoint) obj;
		if (contexts == null) {
			if (other.contexts != null)
				return false;
		} else if (!contexts.equals(other.contexts))
			return false;
		if (element == null) {
			if (other.element != null)
				return false;
		} else if (!element.equals(other.element))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

}
