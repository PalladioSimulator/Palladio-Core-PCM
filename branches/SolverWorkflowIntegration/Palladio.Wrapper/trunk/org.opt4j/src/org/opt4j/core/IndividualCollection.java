/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * The {@code IndividualCollection} is a class that holds a specific number of
 * {@code Individuals}. It is {@code Iterable} and can register
 * {@code Listeners} for adding and removing {@code Individuals}.
 * 
 * @author lukasiewycz
 * 
 */
public class IndividualCollection implements Collection<Individual> {

	protected final List<Individual> individuals = new ArrayList<Individual>();

	protected final Set<IndividualCollectionListener> listeners = new CopyOnWriteArraySet<IndividualCollectionListener>();

	/**
	 * {@code ListIterator} that invokes the {@code Listener}s if an element is
	 * removed.
	 */
	class ListIterator implements Iterator<Individual> {

		private int i = 0;

		public boolean hasNext() {
			return individuals.size() > i;
		}

		public Individual next() {
			return individuals.get(i++);
		}
		
		public void remove() {
			individuals.remove(--i);
		}

	}

	/**
	 * Constructs an {@code IndividualCollection}.
	 */
	public IndividualCollection() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean add(Individual individual) {
		boolean b = individuals.add(individual);
		if (b) {
			for (IndividualCollectionListener listener : listeners) {
				listener.individualAdded(this, individual);
			}
		}
		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#iterator()
	 */
	public Iterator<Individual> iterator() {
		return new ListIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#size()
	 */
	public int size() {
		return individuals.size();
	}

	/**
	 * Adds a listener.
	 * 
	 * @param listener
	 *            the added listener
	 */
	public void addListener(IndividualCollectionListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes a listener.
	 * 
	 * @param listener
	 *            the removed listener
	 */
	public void removeListener(IndividualCollectionListener listener) {
		listeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#clear()
	 */
	public void clear() {
		List<Individual> list = new ArrayList<Individual>(this);
		this.removeAll(list);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends Individual> c) {
		boolean b = false;
		for (Individual individual : c) {
			b |= add(individual);
		}
		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return individuals.contains(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return individuals.contains(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#isEmpty()
	 */
	public boolean isEmpty() {
		return individuals.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		boolean value = individuals.remove(o);
		if (value) {
			for (IndividualCollectionListener listener : listeners) {
				listener.individualRemoved(this, (Individual) o);
			}
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		boolean b = false;
		for (Object obj : c) {
			b |= remove(obj);
		}
		
		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		Set<Individual> remove = new HashSet<Individual>();
		for (Individual individual : individuals) {
			if (!c.contains(individual)) {
				remove.add(individual);
			}
		}
		return removeAll(remove);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#toArray()
	 */
	public Object[] toArray() {
		return individuals.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Collection#toArray(T[])
	 */
	public <T> T[] toArray(T[] a) {
		return individuals.toArray(a);
	}

}
