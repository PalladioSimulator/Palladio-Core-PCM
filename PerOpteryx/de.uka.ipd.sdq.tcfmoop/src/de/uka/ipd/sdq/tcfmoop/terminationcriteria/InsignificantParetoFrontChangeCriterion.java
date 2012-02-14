/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.Collection;
import java.util.LinkedList;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantParetoFrontChangeConfig;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 *
 */
public class InsignificantParetoFrontChangeCriterion extends
		AbstractTerminationCriterion {

	//The minimum significant difference. Everything below this is considered insignificant
	private double requiredPercentageDifference;
	//The current difference between the two fronts
	private double currentPercentageDifference;
	//The x in the n-x. iteration. Gives information about the generation of the second front
	private int pastInterationNumber;
	//An archive of the last x pareto fronts
	private LinkedList<LinkedList<Objectives>> paretoFrontMemory = new LinkedList<LinkedList<Objectives>>();
	
	//OutputNodes
	//static
	@SuppressWarnings("unused")
	private Node generationToCompareWithNode;
	//dynamic
	private Node currentDifferenceNode;
	
	public InsignificantParetoFrontChangeCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof InsignificantParetoFrontChangeConfig) && conf.validateConfiguration()){
			this.requiredPercentageDifference = ((InsignificantParetoFrontChangeConfig)(conf)).getMinimumAllowedDifference();
			this.pastInterationNumber = ((InsignificantParetoFrontChangeConfig)(conf)).getPastIterationNumber();
			
		}else{
			throw new RuntimeException("InsignificantParetoFrontChangeCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		initializeOutputTree();
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("Insignificant Pareto Front Change");
		this.outputInformation.getChildren().clear();
		
		this.generationToCompareWithNode = this.outputInformation.addChild("Current Generation is compared with: " + this.pastInterationNumber + " generation ago", NodeType.PARAMETER);
		this.currentDifferenceNode = this.outputInformation.addChild("Current Difference: " + this.currentPercentageDifference + "/" + this.requiredPercentageDifference, NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Insignificant Pareto Front Change Criterion: This criterion compares the pareto front from the 
	 * n. iteration with the pareto front from the n-x. iteration and calculates the difference between the two.
	 * If this difference is below the supplied minimum, it is reported that the optimization should stop.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
		
		this.memorizeCurrentParetoFront();
		this.clearOutDatedParetoFronts();
		
		if(this.paretoFrontMemory.size() <= this.pastInterationNumber){
			this.evaluationResult = false;
			return;
		}
		
		this.currentPercentageDifference = this.calcuteDifference(this.paretoFrontMemory.getFirst(), this.paretoFrontMemory.getLast());
		
		if(this.currentPercentageDifference < this.requiredPercentageDifference){
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
			newFront.add(indi.getObjectives());
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
	public void updateOutputInformation() {
		this.currentDifferenceNode.updateValue("Current Difference: " + this.currentPercentageDifference + "/" + this.requiredPercentageDifference);
	}

}
