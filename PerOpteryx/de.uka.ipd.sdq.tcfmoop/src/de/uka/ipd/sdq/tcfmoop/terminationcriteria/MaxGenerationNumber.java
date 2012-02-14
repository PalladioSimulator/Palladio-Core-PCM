package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.MaxGenerationNumberConfig;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

public class MaxGenerationNumber extends AbstractTerminationCriterion {

	//The maximum number of iterations that the optimization algorithm should execute.
	private int maximumNumberOfGenerations;
	//Executed iterations so far.
	private int generationsSoFar;
	
	//OutputNodes
	//dynamic
	private Node currentMaxGenNode;
	
	public MaxGenerationNumber(IConfiguration conf, Population population, Archive archive) {
		super(conf, population, archive);
		if((conf instanceof MaxGenerationNumberConfig) && conf.validateConfiguration()){
			this.maximumNumberOfGenerations = ((MaxGenerationNumberConfig)(conf)).getMaximumNumberOfIterations();
		}else{
			throw new RuntimeException("MaxGenerationNumber.initialize: " +
			"wrong or invalid configuration object");
		}
		initializeOutputTree();
	}
	
	private void initializeOutputTree(){
		this.outputInformation.updateValue("Maximum Number of Generations");
		this.outputInformation.getChildren().clear();
		this.currentMaxGenNode = this.outputInformation.addChild("Current/Maximum: " + this.generationsSoFar + "/" + this.maximumNumberOfGenerations, NodeType.PARAMETER);
		this.outputInformation.getChildren().add(this.suggestedStop);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Maximum Number of Generation Criterion. If the number of the evaluated iterations
	 * reaches the supplied limit, the criterion suggest that the optimization should be stopped.
	 */
	@Override
	public void evaluateImpl(int iteration, long currentTime) {
		generationsSoFar = iteration;
		if(generationsSoFar >= maximumNumberOfGenerations){
			this.evaluationResult = true;
		}else{
			this.evaluationResult = false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateOutputInformation(){
		this.currentMaxGenNode.updateValue("Current/Maximum Generation Number: " + this.generationsSoFar + "/" + this.maximumNumberOfGenerations);
	}
}