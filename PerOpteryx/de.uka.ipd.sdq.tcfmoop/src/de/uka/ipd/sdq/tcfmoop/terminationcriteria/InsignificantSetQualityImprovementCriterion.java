package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig.ValueDifference;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 */
public class InsignificantSetQualityImprovementCriterion extends
		AbstractTerminationCriterion {
	
	//List of Average/MaxMin values archives for all objectives for x generations.
	private List<AverageValuesArchive> averageValueArchive = new LinkedList<AverageValuesArchive>();
	//the n-x. set to compare with
	private Integer pastIterationNumber;
	
	//OutputNodes
	//dynamic
	private Node generationToCompareWithNode;
	private Node objectivesNode;

	public InsignificantSetQualityImprovementCriterion(IConfiguration conf, Population population,
			Archive archive) {
		super(conf, population, archive);
		if((conf instanceof InsignificantSetQualityImprovementConfig) && conf.validateConfiguration()){
			this.pastIterationNumber = ((InsignificantSetQualityImprovementConfig)(conf)).getComparisionGenerations();
			this.initializeObjectives(((InsignificantSetQualityImprovementConfig)(conf)).getValueDifferences());
		}else{
			throw new RuntimeException("InsignificantSetQualityImprovementCriterion.initialize: " +
			"wrong or invalid configuration object");
		}
		initializeOutputTree();
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("Insignificant Set Quality Improvement");
		this.outputInformation.getChildren().clear();
		this.objectivesNode = this.outputInformation.addChild("Objectives", NodeType.PARAMETER_GROUP);

		for(AverageValuesArchive ava : this.averageValueArchive){
			Tree temp = new Tree(ava.objective.getName(), NodeType.PARAMETER_GROUP);
			temp.addChild("Current Average: " + ava.getCurrentAverage(), NodeType.PARAMETER);
			temp.addChild("Difference current/required: " + ava.getCurrentAverageDifference()+ "/" + ava.requiredAveragesDifference, NodeType.PARAMETER);
			this.objectivesNode.attachSubtree(temp);
		}
		this.generationToCompareWithNode =  this.outputInformation.addChild("Current Generation is compared with : " + this.pastIterationNumber + " generations ago", NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * Transforms the supplied objective names into references to real existing objective objects.
	 */
	private void initializeObjectives(List<ValueDifference> valueDiferencesList){
		for(ValueDifference vd : valueDiferencesList){
			try {
				this.averageValueArchive.add(new AverageValuesArchive(vd.objective, new DoubleValue(vd.averageImprovement), new DoubleValue(vd.maxMinImprovement), this.pastIterationNumber));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Insignificant Set Quality Improvement Criterion: This criterion compares the averages 
	 * minimum/maximum values of all or of part of the quality criteria in the pareto optimal set of the 
	 * n. iteration with the pareto optimal set of the n-x. iteration. If changes are insignificant 
	 * this criterion reports that the optimization should stop.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime){
		this.evaluationResult = true;
		
		for(AverageValuesArchive ava : this.averageValueArchive){
			double newAverage = this.getAverage(ava.objective);
			double newMaxMin = this.getMaxMin(ava.objective);
			ava.update(newAverage, newMaxMin);

			if(this.evaluationResult == true){
				this.evaluationResult = ava.getIsChangeInsignificant();
			}
		}
	}
	
	/**
	 * Calculate the average of the objective o for the current iteration.
	 * @param o The Objective to calculate the average for.
	 * @return the average value of the Objective o in the n. iteration.
	 */
	private double getAverage(Objective o){
		double sum = 0;
		
		for(Individual indi : this.archive){
			sum += indi.getObjectives().get(o).getDouble();
		}
		
		return (sum/archive.size());
	}
	
	/**
	 * Discover the maximum (by maximizing) or minimum (by minimizing) value of the objective o in the n. iteration.
	 * @param o The Objective to calculate the average for.
	 * @return the maximum (by maximizing) or minimum (by minimizing) value of the objective o in the n. iteration.
	 */
	private double getMaxMin(Objective o){
		double currentMaxMin;
		
		if(o.getSign() == Sign.MAX){
			currentMaxMin = Double.NEGATIVE_INFINITY;
			for(Individual indi : this.archive){
				if(indi.getObjectives().get(o).getDouble() > currentMaxMin){
					currentMaxMin = indi.getObjectives().get(o).getDouble();
				}
			}
		}else{
			currentMaxMin = Double.POSITIVE_INFINITY;
			for(Individual indi : this.archive){
				if(indi.getObjectives().get(o).getDouble() < currentMaxMin){
					currentMaxMin = indi.getObjectives().get(o).getDouble();
				}
			}
		}
		
		return currentMaxMin;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateOutputInformation() {
		
		for(Node objectiveNode : this.objectivesNode.getChildren()){
			for(AverageValuesArchive ava : this.averageValueArchive){
				if(objectiveNode.getValue().equals(ava.objective.getName())){
					objectiveNode.getChildren().get(0).updateValue("Current Average: " + ava.getCurrentAverage());
					objectiveNode.getChildren().get(1).updateValue("Difference current/required: " + ava.getCurrentAverageDifference()+ "/" + ava.requiredAveragesDifference);
				}
			}
		}		
		this.generationToCompareWithNode.updateValue("Current Generation is compared with : " + this.pastIterationNumber + " generations ago");
	}
	
	private class AverageValuesArchive{
		//The Objective this archive stores history for
		public final Objective objective;
		//The minimum required Differences. Everything below these percentages is considered insignificant
		public final Value<?> requiredAveragesDifference;
		public final Value<?> requiredMaxMinDifference;
		//Archives for the average values and for the max/min values for x iterations.
		private LinkedList<Double> averageValues = new LinkedList<Double>();
		private LinkedList<Double> maxMinValues = new LinkedList<Double>();
		//The percentage differences between the n. and the n-x. iteration value of the average and minMin
		private double currentAveragesDifference = 0;
		private double currentMaxMinDifference = 0;
		//The x of the n-x. iteration
		private int pastIterationNumber = 0;
		//Denotes whether the made change was insignificant or not
		private boolean isChangeInsignificant = false;
		
		/**
		 * Represents an archive that stores average values and max/min values of the objective for x generations. 
		 * @param objective The Objective
		 * @param requiredAveragesDifference The minimum required average Differences. A percentage value in the interval [0, 1]
		 * @param requiredMaxMinDifference The minimum required max/min Differences. A percentage value in the interval [0, 1]
		 * @param pastIterationNumber The x of the n-x. iteration ( >= 1 )
		 * @throws Exception If the required conditions are not obeyed.
		 */
		public AverageValuesArchive(Objective objective, Value<?> requiredAveragesDifference, Value<?> requiredMaxMinDifference, int pastIterationNumber) throws Exception{
			if(requiredAveragesDifference == null || objective == null ||
					requiredAveragesDifference.getDouble() < 0 || requiredAveragesDifference.getDouble() > 1 ||
					pastIterationNumber < 1 ||
			   requiredMaxMinDifference.getDouble() < 0 || requiredMaxMinDifference.getDouble() >1 ){
				throw new Exception("AverageValuesArchive.AverageValuesArchive: " +
						"None of the supplied parameters should be null, maximumPercentageImprovement and minimumPercentageHighestValue must be a percentage values between 0 and 1" +
						"pastIterationNumber must be at least 1");
			}
			this.objective = objective;
			this.requiredAveragesDifference = requiredAveragesDifference;
			this.requiredMaxMinDifference = requiredMaxMinDifference;
			this.pastIterationNumber = pastIterationNumber;
		}
		
		/**
		 * Update the archive with another tuple of (average, maxmin) - values. 
		 * Calling this function will automatically make all required changes to the archive including
		 * setup, evaluation and cleanup. Call getIsChangeInsignificant() afterwards to see the result
		 * of the evaluation.
		 * @param newAverageValue the average value for the objective in the n. iteration
		 * @param newMaximumValue the maximum/minimum value for the objective in the n. iteration
		 */
		public void update(double newAverageValue, double newMaxMinValue){
			this.averageValues.addFirst(newAverageValue);
			this.maxMinValues.addFirst(newMaxMinValue);
			
			if(averageValues.size() > pastIterationNumber){
				
				this.currentAveragesDifference = Math.abs((this.averageValues.getFirst() / this.averageValues.getLast()) - 1);
				this.currentMaxMinDifference = Math.abs((this.maxMinValues.getFirst() / this.maxMinValues.getLast()) - 1);
				
				if(this.currentAveragesDifference <= this.requiredAveragesDifference.getDouble() &&
						this.currentMaxMinDifference <= this.requiredMaxMinDifference.getDouble()){
					this.isChangeInsignificant = true;
				}else{
					this.isChangeInsignificant = false;
				}
				
				this.averageValues.removeLast();
				this.maxMinValues.removeLast();
			}
		}
		
		/**
		 * Returns the result of the evaluation of the archive.
		 * @return the result of the evaluation of the archive.
		 */
		public boolean getIsChangeInsignificant(){
			return this.isChangeInsignificant;
		}
		
		/**
		 * Returns the difference between the averages of the objective from the n. and the n-x. iterations. Percentage value in the interval [0, 1]
		 * @return the difference between the averages of the objective from the n. and the n-x. iterations. Percentage value in the interval [0, 1]
		 */
		public double getCurrentAverageDifference(){
			return this.currentAveragesDifference;
		}
		
		/**
		 * Returns the difference between the maxmin of the objective from the n. and the n-x. iterations. Percentage value in the interval [0, 1]
		 * @return the difference between the maxmin of the objective from the n. and the n-x. iterations. Percentage value in the interval [0, 1]
		 */
		public double getCurrentMaxMinDifference(){
			return this.currentMaxMinDifference;
		}
		
		/**
		 * Returns the average of the objective from the n. iterations.
		 * @return the average of the objective from the n. iterations.
		 */
		public double getCurrentAverage(){
			if(this.averageValues.isEmpty()){
				return 0;
			}else{
				return this.averageValues.getFirst();
			}
		}
	}
}