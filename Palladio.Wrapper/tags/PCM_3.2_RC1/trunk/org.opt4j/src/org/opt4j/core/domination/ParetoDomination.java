/**
 * 
 */
package org.opt4j.core.domination;



import org.opt4j.core.Objectives;

import com.google.inject.Singleton;


/**
 * The {@code DominationStrategy} Pareto-Domination.
 * 
 * @see DominationStrategy
 * @author lukasiewycz, noorshams
 *
 */
@Singleton
public class ParetoDomination implements DominationStrategy {

	/**
	 * {@inheritDoc} The dominance relation is <em>Pareto-Domination</em>.
	 */
	/* (non-Javadoc)
	 * @see dominationStrategy.DominationStrategy#dominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)
	 */
	@Override
	public boolean dominates(Objectives o1, Objectives o2) {
		double[] va = o1.array();
		double[] vb = o2.array();

		return dominates(va, vb);
	}
	
	/**
	 * {@link ParetoDomination#dominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)}
	 * @param va array of objective values
	 * @param vb array of objective values
	 * @return {@code true}, if {@code va} dominates {@code vb}, <br>{@code false}, otherwise
	 * 
	 */
	public boolean dominates(double[] va, double[] vb) {
		
		boolean equal = true;
		for (int i = 0; i < va.length; i++) {
			if (va[i] > vb[i]) {
				return false;
			} else if (va[i] < vb[i]) {
				equal = false;
			}
		}
		return !equal;
	}

	/**
	 * {@inheritDoc} The dominance relation is <em>Pareto-Domination</em>.
	 */
	/* (non-Javadoc)
	 * @see dominationStrategy.DominationStrategy#weaklyDominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)
	 */
	@Override
	public boolean weaklyDominates(Objectives o1, Objectives o2) {
		double[] va = o1.array();
		double[] vb = o2.array();
		
		return weaklyDominates(va, vb);
	}
	
	/**
	 * {@link ParetoDomination#weaklyDominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)}
	 * @param va array of objective values
	 * @param vb array of objective values
	 * @return {@code true}, if {@code va} weakly dominates {@code vb}, <br>{@code false}, otherwise
	 * 
	 */
	public boolean weaklyDominates(double[] va, double[] vb) {
		for (int i = 0; i < va.length; i++) {
			if (vb[i] < va[i]) {
				return false;
			}
		}
		return true;
	}

}
