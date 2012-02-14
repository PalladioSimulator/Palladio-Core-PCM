package de.uka.ipd.sdq.dsexplore.opt4j.archive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.config.Task;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualSet;
import org.opt4j.core.IndividualSetListener;
import org.opt4j.core.optimizer.Population;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.helper.FilterParetoOptimalIndividuals;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;


/**
 * Stores all individuals ever added to the tracked population
 * 
 * This is an {@link IndividualSetListener} that listens on the 
 * {@link Population} instance from the Opt4J {@link Task}.
 * 
 * Additionally, a set Pareto-optimal candidates is maintained that can be retrieved 
 * by {@link PopulationTracker#getParetoOptimalIndividuals()}. 
 * 
 * @author Anne
 *
 */
public class PopulationTracker implements
		IndividualSetListener {
	
	private List<DSEIndividual> individuals = new LinkedList<DSEIndividual>();

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.archive.DSEListener");

	
	@Inject
	public PopulationTracker(Population population){
		super();
		population.addListener(this);
	}

	@Override
	public void individualAdded(IndividualSet collection,
			Individual individual) {
		
		if (individual instanceof DSEIndividual){
			//This itselfs stores all
			this.individuals.add((DSEIndividual)individual);
		} else {
			logger.error("It has been attempted to add an individual that is not a DSEIndividual to the archive. Fix your implementation.");
		}
	}

	public List<DSEIndividual> getIndividuals(){
		return this.individuals;
	}

	@Override
	public void individualRemoved(IndividualSet collection,
			Individual individual) {
		// do nothing

	}
	
	/**
	 * Careful: This can 20 minutes to calculate if you have over 1000 candidates in the {@link PopulationTracker}.
	 * @return
	 */
	public List<DSEIndividual> getParetoOptimalIndividuals(){
		
		List<DSEIndividual> optimalList = new ArrayList<DSEIndividual>(this.individuals.size());
		
		optimalList.addAll(this.individuals);
		
		return FilterParetoOptimalIndividuals.filterPareto(optimalList);
	}
	
	/**
	 * Returns the individual for the given phenotype or null if none can be found.
	 * @param pheno
	 * @return the individual or null
	 */
	public DSEIndividual getIndividualForPhenotype(PCMPhenotype pheno){
		for (DSEIndividual i : this.individuals) {
			if (i.getPhenotype() != null && i.getPhenotype() == pheno){
				return i;
			}
		}
		return null;
	}

	public int size() {
		return this.individuals.size();
	}
	
	/**
	 * Has to be an evaluated individual.
	 * @param individual
	 * @throws RuntimeException if the individual is null or not yet evaluated (i.e. individual.isEvaluated returns false). 
	 */
	public boolean addIndividualsManually(DSEIndividual individual){
		if (individual != null && individual.isEvaluated()){
			return this.individuals.add(individual);
		} else {
			throw new RuntimeException("Only evaluated candidates may be added to PopulationTracker!");
		}
	}

}
