package org.opt4j.genotype;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.opt4j.core.Genotype;

/**
 * The {@code IntegerGenotype} is a {@code Genotype} that consists of integer
 * values.
 * 
 * @author lukasiewycz
 * 
 */
public class IntegerGenotype extends ArrayList<Integer> implements ListGenotype {

	protected final Bounds<Integer> bounds;

	/**
	 * Constructs a {@code IntegerGenotype} with the given {@code Bounds}.
	 * 
	 * @param bounds
	 *            the bounds
	 */
	public IntegerGenotype(Bounds<Integer> bounds) {
		this.bounds = bounds;
	}

	/**
	 * Returns the lower bound for the {@code i}-th element.
	 * 
	 * @param index
	 *            the {@code i}-th element
	 * @return the lower bound of the {@code i}-th element
	 */
	public int getLowerBound(int index) {
		return bounds.getLowerBound(index);
	}

	/**
	 * Returns the upper bound for the {@code i}-th element.
	 * 
	 * @param index
	 *            the {@code i}-th element
	 * @return the upper bound of the {@code i}-th element
	 */
	public int getUpperBound(int index) {
		return bounds.getUpperBound(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.Genotype#newInstance()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <G extends Genotype> G newInstance() {
		try {
			Constructor<? extends IntegerGenotype> cstr = this.getClass()
					.getConstructor(Bounds.class);
			return (G) cstr.newInstance(bounds);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static final long serialVersionUID = 1L;

}
