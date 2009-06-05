package de.uka.ipd.sdq.dsexplore.opt4j.archive;

import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.Population;

import com.google.inject.Inject;

/**
 * Stores all individuals ever added to the tracked population
 * @author Anne
 *
 */
public class PopulationTracker extends IndividualCollection implements
		IndividualCollectionListener {
	
	@Inject
	public PopulationTracker(Population population){
		super();
		population.addListener(this);
	}

	@Override
	public void individualAdded(IndividualCollection collection,
			Individual individual) {
		this.add(individual);

	}

	@Override
	public void individualRemoved(IndividualCollection collection,
			Individual individual) {
		// do nothing

	}

}
