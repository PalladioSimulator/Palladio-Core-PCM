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

package org.opt4j.common.archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.Objectives;

/**
 * This {@code AbstractArchive} provides some common methods for archives. The
 * {@code AbstractArchive#update(Collection)} is implemented such that each
 * dominated Individual is removed from the archive and with the new (unknown)
 * non-dominated {@code Individuals} the method {@code
 * AbstractArchive#updateWithNondominated(Collection)}.
 * 
 * @author helwig, glass, lukasiewycz
 * 
 */
public abstract class AbstractArchive extends IndividualCollection implements
		Archive {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.Archive#update(org.opt4j.core.Individual[])
	 */
	public void update(Individual... individuals) {
		update(Arrays.asList(individuals));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.Archive#update(java.util.Collection)
	 */
	public void update(Collection<Individual> individuals) {

		List<Individual> candidates = new ArrayList<Individual>(individuals);

		Objectives o1, o2;

		/*
		 * Remove all individuals that are already in the archive and those that
		 * are dominated among the candidates
		 */
		candidates.removeAll(this);
		for (int i = 0; i < candidates.size() - 1; i++) {
			o1 = candidates.get(i).getObjectives();
			for (int j = i + 1; j < candidates.size(); j++) {
				o2 = candidates.get(j).getObjectives();
				if (o2.weaklyDominates(o1)) {
					candidates.remove(i);
					i--;
					break;
				} else if (o1.weaklyDominates(o2)) {
					candidates.remove(j);
					j--;
				}
			}
		}

		/*
		 * Remove those individuals from the archive which are dominated by the
		 * candidates. Remove those individuals from the candidates which are
		 * dominated by the archive.
		 */
		Iterator<Individual> i1, i2;
		for (i1 = candidates.iterator(); i1.hasNext();) {
			o1 = i1.next().getObjectives();
			for (i2 = this.iterator(); i2.hasNext();) {
				o2 = i2.next().getObjectives();
				if (o1.weaklyDominates(o2)) {
					i2.remove();
				} else if (o2.dominates(o1)) {
					i1.remove();
					break;
				}
			}
		}

		updateWithNondominated(candidates);
	}

	/**
	 * Updates with a collection of new (unknown) non-dominated candidate
	 * individuals.
	 * 
	 * @param candidates
	 */
	protected abstract void updateWithNondominated(
			Collection<Individual> candidates);

	/**
	 * Returns a {@code String} representation of the pareto front stored in
	 * this {@code Archive}.
	 * 
	 * @return {@code String} representation of this archive's pareto front
	 */
	@Override
	public String toString() {
		String s = "";
		for (Individual ind : this) {
			double[] obj = ind.getObjectives().array();
			for (int i = 0; i < obj.length; i++) {
				s += obj[i] + "\t";
			}
			s += "\n";
		}
		return s;
	}

	private static final long serialVersionUID = 1L;
}
