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
import java.util.Collection;
import java.util.List;

import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;

/**
 * The {@code PopulationArchive} keeps the non-dominated {@code Individuals}
 * from the {@link Population}. It is assumed that the {@code
 * PopulationArchive#update(Collection)} method is called with the current
 * {@code Population} in each iteration.
 * 
 * @author lukasiewycz
 * 
 */
public class PopulationArchive extends AbstractArchive {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.common.archive.AbstractArchive#update(java.util.Collection)
	 */
	@Override
	public void update(Collection<Individual> individuals) {

		List<Individual> candidates = new ArrayList<Individual>(individuals);

		Objectives o1, o2;

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

		updateWithNondominated(candidates);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.common.archive.AbstractArchive#updateWithNondominated(java.
	 * util.Collection)
	 */
	@Override
	protected void updateWithNondominated(Collection<Individual> candidates) {
		List<Individual> removes = new ArrayList<Individual>();
		for (Individual i : this) {
			if (!candidates.contains(i)) {
				removes.add(i);
			}
		}
		removeAll(removes);

		for (Individual i : candidates) {
			if (!contains(i)) {
				add(i);
			}
		}
	}

}
