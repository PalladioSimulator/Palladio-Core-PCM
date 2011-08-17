package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.startingPopulation;

import java.util.Collection;

import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.optimizer.Completer;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;

/**
 * Interface defines a heuristic that generates a starting population
 * @author Tom Beyer
 *
 */
public interface IStartingPoulationHeuristic {
	/**
	 * 
	 * @param completer Used to evaluate inidividuals
	 * @param individualBuilder Used to copy individual
	 * @param firstIndividual This individual is used as a starting point for the creation of all other individuals
	 * @return
	 */
	public Collection<DSEIndividual> getStartingPopulation(Completer completer, IndividualBuilder individualBuilder, DSEIndividual firstIndividual);
}
