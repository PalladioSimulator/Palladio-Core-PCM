package org.opt4j.common.archive;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;

/**
 * The simplest possible archive that just keeps all individuals (except if they are already in the collection). 
 * @author Anne
 *
 */
public class BasicArchive extends IndividualCollection implements Archive {
	
	public BasicArchive() {
		super();
	}

	@Override
	public void update(Individual... individual) {
		this.update(Arrays.asList(individual));
	}

	@Override
	public void update(Collection<Individual> individuals) {
		for (Iterator<Individual> iterator = individuals.iterator(); iterator
				.hasNext();) {
			Individual individual = iterator.next();
			if (!(this.contains(individual))){
				this.add(individual);
			}
		}
		
	}

}
