package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import org.opt4j.core.Archive;
import org.opt4j.core.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.MaxGenerationNumberConfig;

public class MaxGenerationNumber extends AbstractTerminationCriterion {

	//The maximum number of iterations that the optimization algorithm should execute.
	private int maximumNumberOfGenerations;
	//Executed iterations so far.
	private int generationsSoFar;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(IConfiguration conf, Population population, Archive archive) {
		if((conf instanceof MaxGenerationNumberConfig) && conf.validateConfiguration()){
			this.maximumNumberOfGenerations = ((MaxGenerationNumberConfig)(conf)).getMaximumNumberOfIterations();
		}else{
			throw new RuntimeException("MaxGenerationNumber.initialize: " +
			"wrong or invalid configuration object");
		}
		super.initialize(conf, population, archive);
	}
	
	/**
	 * {@inheritDoc}
	 * Implements the Maximum Number of Generation Criterion. If the number of the evaluated iterations
	 * reaches the supplied limit, the criterion suggest that the optimization should be stopped.
	 */
	@Override
	public void evaluate(int iteration, long currentTime) {
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
	public StringBuilder getOutputInformation(){
		this.outputInformation = new StringBuilder();
		this.outputInformation.append("Criterion Name: Maximum Number of Generations" + '\n');
		this.outputInformation.append("Current Generation Number: " + this.generationsSoFar + '\n');
		this.outputInformation.append("Maximum Generation Number: " + this.maximumNumberOfGenerations + '\n');
		return super.getOutputInformation();
	}
}