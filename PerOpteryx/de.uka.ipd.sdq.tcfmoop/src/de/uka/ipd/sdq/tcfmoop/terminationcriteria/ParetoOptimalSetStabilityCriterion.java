package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig;
import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig.EvaluationMode;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 */
public class ParetoOptimalSetStabilityCriterion extends
		AbstractTerminationCriterion {
		
	/*
	 * The evaluation modes that this criterion supports. If mode is set to EXACT_NUMBER, then the criterion searches every time 
	 * for exactly x candidates who have survived for n iterations. If PERCENTAGE is set as evaluation mode, then the number of
	 * the survived candidates is relative to the current amount of candidates in the archive. 
	 */
	private EvaluationMode mode;	
	//The minimum number of individual who must survive
	private int minimumSurvivors;
	//The minimum number of individual in percentage who must survive
	private Double minimumSurvivorsInPercentage;
	//The minimum amount of iterations these individuals have to survive
	private int minimumIterationsToSurvive;
	//Stores information about the individuals, including survived generations
	private Map<Individual, IndividualStatistics> survivalsCounter;
	//Denotes how many individuals have remained pareto optimal the longest or how many have reached the required minimum number of iterations to survive.
	private int numberOfIndividualsThatHasRemainedOptimalTheLongest;
	//Shows the currently reached maximum number of survived iterations.
	private int currentlyReachedMaxNumberOfIterations;
	
	//OutputNodes
	//static
	@SuppressWarnings("unused")
	private Node evaluationModeNode;
	//dynamic
	private Node survivedGenerationsNode;
	private Node survivorsNode;
	
	public ParetoOptimalSetStabilityCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof ParetoOptimalSetStabilityConfig) && conf.validateConfiguration()){
			this.minimumIterationsToSurvive = ((ParetoOptimalSetStabilityConfig)(conf)).getMinimumIterationsToSurvive();
			this.mode = ((ParetoOptimalSetStabilityConfig)(conf)).getEvaluationMode();
			if(this.mode == EvaluationMode.EXACT_NUMBER){
				this.minimumSurvivors = ((ParetoOptimalSetStabilityConfig)(conf)).getMinimumSurvivors();
			}else{
				this.minimumSurvivorsInPercentage = ((ParetoOptimalSetStabilityConfig)(conf)).getMinimumSurvivorsInPercentage();
			}
		}else{
			throw new RuntimeException("ParetoOptimalSetStabilityCriterion.initialize: " +
					"wrong or invalid configuration object");
		}
		survivalsCounter = new HashMap<Individual, IndividualStatistics>();
		this.initializeOutputTree(archive);
	}
	
	private void initializeOutputTree(Archive archive){
		this.outputInformation.updateValue("Pareto Optimal Set Stability");
		this.outputInformation.getChildren().clear();
		
		this.evaluationModeNode = this.outputInformation.addChild("Evaluation Mode: " + this.mode.name(), NodeType.PARAMETER);
		this.survivedGenerationsNode = this.outputInformation.addChild("Survived Generations: " + this.currentlyReachedMaxNumberOfIterations + "/" + this.minimumIterationsToSurvive, NodeType.PARAMETER);

		if(this.mode == EvaluationMode.EXACT_NUMBER){
			this.survivorsNode = this.outputInformation.addChild("Survivors: " + this.numberOfIndividualsThatHasRemainedOptimalTheLongest + "/" + this.minimumSurvivors, NodeType.PARAMETER);
		}else{
			this.survivorsNode = this.outputInformation.addChild("Survivors: " + (double)this.numberOfIndividualsThatHasRemainedOptimalTheLongest/archive.size()*100 + "%/" + this.minimumSurvivorsInPercentage*100 + "%", NodeType.PARAMETER);
		}
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Pareto Optimal Set Stability Criterion: This criterion evaluates how many candidates
	 * have remained pareto optimal and for how many iterations. If the numbers reach the supplied requirements
	 * this criterion decides that the spareto optimal set is stable enough and probably would not change in the near future.
	 * And therefore suggests the termination of the optimization.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {		
		for(Individual indi : archive){
			if(this.survivalsCounter.containsKey(indi)){
				this.survivalsCounter.get(indi).renewSurvivalStatus(iteration);
			}else{
				this.survivalsCounter.put(indi, new IndividualStatistics(iteration));
			}
		}
		
		//Select the objects to delete
		
		List<Individual> individualsToRemove = new LinkedList<Individual>();
		
		for(Map.Entry<Individual, IndividualStatistics> mapEntry : this.survivalsCounter.entrySet()){
			if(!mapEntry.getValue().hasSurvived(iteration)){
				individualsToRemove.add(mapEntry.getKey());
			}
		}
		
		//Delete these objects
		
		for(Individual i : individualsToRemove){
			this.survivalsCounter.remove(i);
		}
		
		//Count the survivors
		
		this.currentlyReachedMaxNumberOfIterations = 0;
		this.numberOfIndividualsThatHasRemainedOptimalTheLongest = 0;
		
		for(IndividualStatistics iStat : this.survivalsCounter.values()){
			//Has the currently highest generation number reached the required minimum
			if(this.currentlyReachedMaxNumberOfIterations == this.minimumIterationsToSurvive){
				if(iStat.getNumberOfSurvivedGenerations() >= this.minimumIterationsToSurvive){
					this.numberOfIndividualsThatHasRemainedOptimalTheLongest++;
				}
			}else{
				//Currently reached Generation number is lower than the required minimum
				if(iStat.getNumberOfSurvivedGenerations() > this.currentlyReachedMaxNumberOfIterations){
					this.numberOfIndividualsThatHasRemainedOptimalTheLongest = 1;
					this.currentlyReachedMaxNumberOfIterations = iStat.getNumberOfSurvivedGenerations();
					if(this.currentlyReachedMaxNumberOfIterations > this.minimumIterationsToSurvive){
						this.currentlyReachedMaxNumberOfIterations = this.minimumIterationsToSurvive;
					}
				}else if(iStat.getNumberOfSurvivedGenerations() == this.currentlyReachedMaxNumberOfIterations){
					this.numberOfIndividualsThatHasRemainedOptimalTheLongest++;
				}
			}
			
		}
		
		//Make the decision based on the mode
		if(this.currentlyReachedMaxNumberOfIterations == this.minimumIterationsToSurvive && 
				((this.mode == EvaluationMode.EXACT_NUMBER && this.numberOfIndividualsThatHasRemainedOptimalTheLongest >= this.minimumSurvivors) ||
				 (this.mode == EvaluationMode.PERCENTAGE && (double)this.numberOfIndividualsThatHasRemainedOptimalTheLongest/this.archive.size() >= this.minimumSurvivorsInPercentage))){
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
		this.survivedGenerationsNode.updateValue("Survived Generations: " + this.currentlyReachedMaxNumberOfIterations + "/" + this.minimumIterationsToSurvive);
		if(this.mode == EvaluationMode.EXACT_NUMBER){
			this.survivorsNode.updateValue("Survivors: " + this.numberOfIndividualsThatHasRemainedOptimalTheLongest + "/" + this.minimumSurvivors);
		}else{
			this.survivorsNode.updateValue("Survivors: " + (double)this.numberOfIndividualsThatHasRemainedOptimalTheLongest/this.archive.size()*100 + "%/" + this.minimumSurvivorsInPercentage*100 + "%");
		}
	}
	
	/**
	 * A helper class for storing individuals survival information.
	 * @author Atanas Dimitrov
	 */
	private class IndividualStatistics{
		private int survivedGenerations;
		private int lastUpdated;
		
		public IndividualStatistics(int generationNumber){
			this.survivedGenerations = 1;
			this.lastUpdated = generationNumber;
		}
		
		/**
		 * Automatically updates the complete statistic for the individual in question.
		 * @param generationNumber
		 */
		public void renewSurvivalStatus(int generationNumber){
			this.survivedGenerations++;
			this.lastUpdated = generationNumber;
		}
		
		/**
		 * Answer whether the individual has survived the supplied iteration.
		 * @param iterationNumber - number if the iteration
		 * @return true if the individual  has survived the iteration
		 */
		public boolean hasSurvived(int iterationNumber){
			return (this.lastUpdated >= iterationNumber);
		}
		
		/**
		 * Return the number of the survived iterations for the individual
		 * @return the number of the survived iterations for the individual
		 */
		public int getNumberOfSurvivedGenerations(){
			return this.survivedGenerations;
		}
	}

}
