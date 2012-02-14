/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.NoNewParetoOptimalCandidatesFoundConfig;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 *
 */
public class NoNewParetoOptimalCandidatesFoundCriterion extends
		AbstractTerminationCriterion {
	
	//Denotes whether new pareto optimal candidates were found in the last iteration.
	private boolean newParetoCandidatesFound = false;
	//Required and current number of iterations without a newly found pareto optimal candidate.
	private int requiredIterationsWithoutNewParetoOptimalCandidate;
	private int currentIterationsWithoutNewParetoOptimalCandidate = 0;
	//Local Archive of the already found pareto optimal candidates.
	private List<Individual> localArchive = new LinkedList<Individual>();
	
	//OutputNodes
	//dynamic
	private Node generationsWithoutNewCandidate;

	public NoNewParetoOptimalCandidatesFoundCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof NoNewParetoOptimalCandidatesFoundConfig) && conf.validateConfiguration()){
			this.requiredIterationsWithoutNewParetoOptimalCandidate = ((NoNewParetoOptimalCandidatesFoundConfig)(conf)).getIterationsWithoutNewCandidates();
		}else{
			throw new RuntimeException("NoNewParetoOptimalCandidatesFoundCriterion.initialize: " +
					"wrong or invalid configuration object");
		}
		initializeOutputTree();
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("No New Pareto Optimal Candidates Found");
		this.outputInformation.getChildren().clear();
		
		this.generationsWithoutNewCandidate = this.outputInformation.addChild("No new pareto optimal candidate for: " + this.currentIterationsWithoutNewParetoOptimalCandidate + 
				"/" + this.requiredIterationsWithoutNewParetoOptimalCandidate + " generations", NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the No New Pareto Optimal Candidates Found Criterion: This criterion tests the pareto optimal set
	 * for new found pareto optimal candidates. If no new pareto optimal candidates are found within n iterations
	 * it suggests a termination of the optimization.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
		this.newParetoCandidatesFound = false;
		
		for(Individual indi : archive){
			if(!localArchive.contains(indi)){
				this.newParetoCandidatesFound = true;
				localArchive.add(indi);
			}
		}
		
		//Clean the local archive
		
		List<Individual> individualsToRemove = new LinkedList<Individual>();
		
		for(Individual indi: this.localArchive){
			if(!archive.contains(indi)){
				individualsToRemove.add(indi);
			}
		}
		
		this.localArchive.removeAll(individualsToRemove);
		
		if(!this.newParetoCandidatesFound){
			this.currentIterationsWithoutNewParetoOptimalCandidate++;
		}else{
			this.currentIterationsWithoutNewParetoOptimalCandidate = 0;
		}
		
		if(this.currentIterationsWithoutNewParetoOptimalCandidate == this.requiredIterationsWithoutNewParetoOptimalCandidate){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateOutputInformation() {
		this.generationsWithoutNewCandidate.updateValue("No new pareto optimal candidate for: " + this.currentIterationsWithoutNewParetoOptimalCandidate + 
				"/" + this.requiredIterationsWithoutNewParetoOptimalCandidate + " generations");
	}

}
