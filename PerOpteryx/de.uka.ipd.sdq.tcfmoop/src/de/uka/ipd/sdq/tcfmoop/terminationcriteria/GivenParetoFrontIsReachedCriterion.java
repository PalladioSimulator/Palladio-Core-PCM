/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objectives;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.GivenParetoFrontIsReachedConfig;
import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 *
 */
public class GivenParetoFrontIsReachedCriterion extends
		AbstractTerminationCriterion {
	
	//The pareto front that the optimization targets
	private List<Objectives> paretoFront;
	//Initial size of the targeted pareto front. Needed for optimization purposes
	private int initialParetoFrontSize;
	//The percentage of the targeted front that needs to be dominated by the pareto front of the optimization
	private double requiredPercentagesCovered;
	//The part of the targeted pareto front (in percentages) that is currently covered by the  front of the optimization.
	private double currentPercentagesCovered;
	//OutputNodes
	//dynamic
	private Node frontCoverageNode;
	
	public GivenParetoFrontIsReachedCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof GivenParetoFrontIsReachedConfig) && conf.validateConfiguration()){
			this.paretoFront = ((GivenParetoFrontIsReachedConfig)(conf)).getParetoFront();
			this.requiredPercentagesCovered = ((GivenParetoFrontIsReachedConfig)(conf)).getPercentagesToCover();
			this.initialParetoFrontSize = this.paretoFront.size();
		}else{
			throw new RuntimeException("GivenParetoFrontIsReachedCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		initializeOutputTree();
	}

	private void initializeOutputTree(){
		this.outputInformation.updateValue("Given Pareto Front Is Reached");
		this.outputInformation.getChildren().clear();
		
		this.frontCoverageNode = this.outputInformation.addChild("Front Coverage: " + this.currentPercentagesCovered + "/" + this.requiredPercentagesCovered, NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Given Pareto Front Is Reached Criterion: This stopping criterion receives a targeted pareto front
	 * that the optimization is trying to reach/dominate/cover. Once x percentages of the targeted front are reached/covered/dominated
	 * the criterion will report that the optimization should be stopped.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
		this.currentPercentagesCovered = this.calcuteCoverage(this.archive, this.paretoFront);
		if(this.currentPercentagesCovered >= this.requiredPercentagesCovered){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
	}
	
	/**
	 * Calculates the coverage of the toBeCoveredFront. Returns the covered part of the toBeCoveredFront as
	 * a percentage value in the interval [0,1].
	 * @param coveringFront the pareto front that covers/dominates/reaches. the toBeCoveredFront
	 * @param toBeCoveredFront the pareto front that must be covered/dominated/reached.
	 * @return The covered part of the toBeCoveredFront by the coveringFront in percentages [0,1]
	 */
	private double calcuteCoverage(Collection<Individual> coveringFront, Collection<Objectives> toBeCoveredFront){		
		List<Objectives> indisToRemove = new LinkedList<Objectives>();
		
		for(Objectives indiToBeDominated : toBeCoveredFront){
			for(Individual coveringIndi : coveringFront){
				if(coveringIndi.getObjectives().weaklyDominates(indiToBeDominated)){
					indisToRemove.add(indiToBeDominated);
					break;
				}
			}
		}
		
		toBeCoveredFront.removeAll(indisToRemove);
		
		return 1-((double)(toBeCoveredFront.size())/(double)(this.initialParetoFrontSize));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateOutputInformation() {
		this.frontCoverageNode.updateValue("Front Coverage: " + this.currentPercentagesCovered + "/" + this.requiredPercentagesCovered);
	}

}