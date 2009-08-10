package de.uka.ipd.sdq.dsexplore.opt4j.archive;

import java.util.ArrayList;
import java.util.List;

import org.opt4j.config.Task;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.Population;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.helper.FilterParetoOptimalIndividuals;


/**
 * Stores all individuals ever added to the tracked population
 * 
 * This is an {@link IndividualCollectionListener} that listens on the 
 * {@link Population} instance from the Opt4J {@link Task}.
 * 
 * Additionally, a set Pareto-optimal candidates is maintained that can be retrieved 
 * by {@link PopulationTracker#getParetoOptimalIndividuals()}. 
 * 
 * @author Anne
 *
 */
public class PopulationTracker extends IndividualCollection implements
		IndividualCollectionListener {
	
	//IndividualCollection optimalIndividuals = new IndividualCollection();
	
	//IndividualCollection unevaluatedCandidates = new IndividualCollection();
	
	@Inject
	public PopulationTracker(Population population){
		super();
		population.addListener(this);
	}

	@Override
	public void individualAdded(IndividualCollection collection,
			Individual individual) {
		
		//This itselfs stores all
		this.add(individual);

		/*checkPreviouslyUnevaluatedIndividuals();
		
		if (individual.isEvaluated()){
			checkOptimality(individual);
		} else {
			this.unevaluatedCandidates.add(individual);
		}*/
	}

	/*private void checkPreviouslyUnevaluatedIndividuals() {
		for (Individual individual2 : this.unevaluatedCandidates) {
			if (individual2.isEvaluated()){
				checkOptimality(individual2);
				this.unevaluatedCandidates.remove(individual2);
			} 
		}
	}*/

	/*private void checkOptimality(Individual individual) {
		//Determine whether it is dominating and should be store in this.optimalIndividuals
		boolean isDominated = false;
		
		List<Individual> toBeRemoved = new ArrayList<Individual>();
		
		for (Individual oldIndividual : this.optimalIndividuals) {
			
			if (individual.getObjectives().dominates(oldIndividual.getObjectives())){
				toBeRemoved.add(oldIndividual);
			} else if (oldIndividual.getObjectives().dominates(individual.getObjectives())){
				//We can stop the search if it is dominated, as it can then itself dominate none from the optimal set.
				isDominated = true;
				break;
			}
		}
		
		if (!isDominated){
			this.optimalIndividuals.remove(toBeRemoved);
			this.optimalIndividuals.add(individual);
		}
	}*/

	@Override
	public void individualRemoved(IndividualCollection collection,
			Individual individual) {
		// do nothing

	}
	
	public List<Individual> getParetoOptimalIndividuals(){
		
		List<Individual> optimalList = new ArrayList<Individual>();
		
		optimalList.addAll(this.individuals);
		
		return FilterParetoOptimalIndividuals.filterPareto(optimalList);
	}

}
