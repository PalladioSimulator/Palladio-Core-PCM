/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Value;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantParetoFrontChangeConfig;

/**
 * @author Atanas Dimitrov
 *
 */
public class InsignificantParetoFrontChangeCriterion extends
		AbstractTerminationCriterion {

	//The minimum significant difference. Everything below this is considered insignificant
	private double requiredPersentageDifference;
	//The current difference between the two fronts
	private double currentPersentageDifference;
	//The x in the n-x. iteration. Gives information about the generation of the second front
	private int pastInterationNumber;
	//An archive of the last x pareto fronts
	private LinkedList<LinkedList<Objectives>> paretoFrontMemory = new LinkedList<LinkedList<Objectives>>();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(IConfiguration conf, Population population,
			Archive archive) {
		if((conf instanceof InsignificantParetoFrontChangeConfig) && conf.validateConfiguration()){
			this.requiredPersentageDifference = ((InsignificantParetoFrontChangeConfig)(conf)).getMinimumAllowedDifference();
			this.pastInterationNumber = ((InsignificantParetoFrontChangeConfig)(conf)).getPastIterationNumber();
			
		}else{
			throw new RuntimeException("InsignificantParetoFrontChangeCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		super.initialize(conf, population, archive);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Insignificant Pareto Front Change Criterion: This criterion compares the pareto front from the 
	 * n. iteration with the pareto front from the n-x. iteration and calculates the difference between the two.
	 * If this difference is below the supplied minimum, it is reported that the optimization should stop.
	 */
	@Override
	public void evaluate(int iteration, long currentTime) {
		
		this.memorizeCurrentParetoFront();
		this.clearOutDatedParetoFronts();
		
		if(this.paretoFrontMemory.size() <= this.pastInterationNumber){
			this.evaluationResult = false;
			return;
		}		
		
		this.currentPersentageDifference = this.calcuteDifference(this.paretoFrontMemory.getFirst(), this.paretoFrontMemory.getLast());
		
		if(this.currentPersentageDifference < this.requiredPersentageDifference){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
		
	}
	
	/**
	 * Copies the current pareto front to a local archive.
	 */
	private void memorizeCurrentParetoFront(){
		LinkedList<Objectives> newFront = new LinkedList<Objectives>();
		for(Individual indi : this.archive){
			Objectives obj = new Objectives();
			for(Entry<Objective, Value<?>> keyValuePair : indi.getObjectives()){
				obj.add(keyValuePair.getKey(), keyValuePair.getValue().getDouble());
			}
			newFront.add(obj);
		}
		this.paretoFrontMemory.addFirst(newFront);
	}
	
	/**
	 * Clear every pareto front that lies beyond the n-x. one.
	 */
	private void clearOutDatedParetoFronts(){
		while(this.paretoFrontMemory.size() > this.pastInterationNumber + 1){
			this.paretoFrontMemory.removeLast();
		}
	}
	
	/**
	 * Calculate the difference between the two pareto fronts by measuring the the coverage between them
	 * @param newFront pareto front of a latest iteration
	 * @param oldFront pareto front of an earlier iteration
	 * @return the calculated pareto front difference. A percentage value in the interval [0, 1].
	 */
	private double calcuteDifference(Collection<Objectives> newFront, Collection<Objectives> oldFront){
		int numberOfDominatedIndividualsInCoveredFront = 0;
		int numberOfIndividualsInCoveredFront = oldFront.size();
		
		for(Objectives indiToBeDominated : oldFront){
			for(Objectives coveringIndi : newFront){
				if(coveringIndi.dominates(indiToBeDominated)){
					numberOfDominatedIndividualsInCoveredFront++;
					break;
				}
			}
		}
		
		if(numberOfIndividualsInCoveredFront == 0){
			if(newFront.size() == 0){
				return 0;
			}else{
				return 1;
			}
		}else{
			return (double)numberOfDominatedIndividualsInCoveredFront/numberOfIndividualsInCoveredFront;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public StringBuilder getOutputInformation() {
		this.outputInformation = new StringBuilder();
		this.outputInformation.append("Criterion Name: Insignificant Pareto Front Change" + '\n');
		this.outputInformation.append("Current Difference: " + this.currentPersentageDifference + "/" + this.requiredPersentageDifference + '\n');
		this.outputInformation.append("Current Generation is compared with: " + this.pastInterationNumber + " generation ago generation" + '\n');
		
		return super.getOutputInformation();
	}

}
