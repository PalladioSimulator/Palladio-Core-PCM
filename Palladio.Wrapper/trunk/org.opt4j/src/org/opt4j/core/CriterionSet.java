/**
 * 
 */
package org.opt4j.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Superclass for {@code Criterion}-{@code Values} pairs. Provides methods for 
 * the administration of these pairs.
 * 
 * @author noorshams
 *
 */
public abstract class CriterionSet<T extends Criterion> implements Iterable<Entry<T, Value<?>>> {

	protected SortedMap<T, Value<?>> map = new TreeMap<T, Value<?>>();
	
	protected double[] array = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Entry<T, Value<?>>> iterator() {
		return map.entrySet().iterator();
	}
	
	/**
	 * Returns an array of all CriterionSet values.
	 * 
	 * @return an array containing CriterionSet values
	 */
	public abstract double[] array(); 
	
	/**
	 * Returns the number of set {@code Criterion}s.
	 * 
	 * @return the number of set {@code Criterion}s
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Returns all {@code Criterion}s.
	 * 
	 * @return all {@code Criterion}s
	 */
	public Collection<T> getKeys() {
		return map.keySet();
	}
	
	/**
	 * Returns all values.
	 * 
	 * @return all values
	 */
	public Collection<Value<?>> getValues() {
		return map.values();
	}
	
	/**
	 * Returns the value that is assigned to the given {@code Criterion}. Returns
	 * {@code null} if the {@code Criterion} does not exist.
	 * 
	 * @param criterion
	 *            the given criterion
	 * @return the value
	 */
	public Value<?> get(T criterion) {
		return map.get(criterion);
	}
	
	/**
	 * Returns the Criterion that is assigned to the given value. Returns
	 * {@code null} if the value does not exist.
	 * 
	 * @param value
	 *            the given value
	 * @return the Criterion
	 */
	public T get(Value<?> value) {
		T t = null;
		for (Entry<T, Value<?>> entry : this) {
			Value<?> v = entry.getValue();
			if (value.equals(v)) {
				t = entry.getKey();
				break;
			}
		}
		return t;
	}

	/**
	 * Adds the Criterion with the specified value.
	 * 
	 * @param criterion
	 *            the criterion
	 * @param value
	 *            the value
	 */
	public void add(T criterion, Value<?> value) {
		if (value == null) {
			map.put(criterion, new DoubleValue(null));
		} else {
			map.put(criterion, value);
		}
		array = null;
	}
	
	/**
	 * Adds the Criterion with the specified double value.
	 * 
	 * @param criterion
	 *            the criterion
	 * @param value
	 *            the value
	 */
	public void add(T criterion, double value) {
		add(criterion, new DoubleValue(value));
	}
	
	/**
	 * Adds the Criterion with the specified integer value.
	 * 
	 * @param criterion
	 *            the criterion
	 * @param value
	 *            the value
	 */
	public void add(T criterion, int value) {
		add(criterion, new IntegerValue(value));
	}
	
	/**
	 * Adds all Criterions with the specified value specified in {@code
	 * criterionSet}.
	 * 
	 * @param criterionSet
	 *            the criterionSet
	 */
	public void add(CriterionSet<T> criterionSet) {
		map.putAll(criterionSet.map);
		array = null;
	}
	
	/**
	 * Returns {@code true} if this CriterionSet is equal to the specified
	 * CriterionSet. This comparison is based on the {@code #array()} values.
	 * 
	 * @param opponent
	 *            other CriterionSet
	 * @return {@code true} if the CriterionSets are equal
	 */
	public boolean isEqual(CriterionSet<T> opponent) {
		double[] va = this.array();
		double[] vb = opponent.array();

		if (va.length != vb.length) {
			return false;
		}
		
		for (int i = 0; i < va.length; i++) {
			if (va[i] != vb[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Calculates the euclidean distance of two {@code CriterionSet}s. This
	 * calculation is based on the {@code #array()} values.
	 * 
	 * @param other
	 *            the second CriterionSet
	 * @return the euclidean distance
	 */
	public double distance(CriterionSet<T> other) {
		double[] va = this.array();
		double[] vb = other.array();

		if (va.length != vb.length){
			return -1;
		}
		
		double s = 0;
		for (int i = 0; i < va.length; i++) {
			s += (va[i] - vb[i]) * (va[i] - vb[i]);
		}

		return Math.sqrt(s);
	}
}
