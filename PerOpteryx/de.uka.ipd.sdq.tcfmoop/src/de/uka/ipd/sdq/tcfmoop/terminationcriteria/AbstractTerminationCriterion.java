/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;



import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.TerminationCriteriaNames;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;
import de.uka.ipd.sdq.tcfmoop.outputtree.Node.NodeType;

/**
 * @author Atanas Dimitrov
 *
 */
public abstract class AbstractTerminationCriterion implements ITerminationCriterion {
	
	//Defines whether the termination criterion has suggested the termination of the optimization yet or not
	protected boolean evaluationResult = false;
	//The output information tree
	protected Tree outputInformation;
	//Opt4J specific structures required by the optimization
	//Collection of individual that toghether build the most recent set of candidates
	protected Population population;
	//Collection of all currently pareto optimal candidates
	protected Archive archive;
	//name of the termination criteria
	protected TerminationCriteriaNames name;
	//The number of the iteration in which this criterion has proposed a termination of the optimization
	private int stopSuggestedIn = -1;
	//Output node for the stop suggestion information
	protected Node suggestedStop;
	//Defines whether the output information tree needs to be updated
	protected boolean outputNeedsUpdate = false;
	
	/**
	 * Initializes the termination criteria by supplying it with the configuration object and other needed resources.
	 * @param conf - The configuration object.
	 * @param population - The current Population
	 * @param archive - A reference to the archive
	 * @throws RuntimeException if the configuration object is not fully initialized.
	 */
	protected AbstractTerminationCriterion(IConfiguration conf, Population population, Archive archive) {
		this.archive = archive;
		this.population = population;
		this.name = conf.getTerminationCriterionName();
		this.outputInformation = new Tree("Abstract Termination Criterion", NodeType.TERMINATION_CRITERIA);
		this.suggestedStop = this.outputInformation.addChild("Termination suggested: " + this.evaluationResult + "; During: " + this.stopSuggestedIn, NodeType.PARAMETER);
		this.outputNeedsUpdate = true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean getEvaluationResult() {
		return this.evaluationResult;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void evaluate(int iteration, long currentTime) {
		if(!this.evaluationResult){
			this.evaluateImpl(iteration, currentTime);
			if(this.evaluationResult){
				this.stopSuggestedIn = iteration;
			}
			this.outputNeedsUpdate = true;
		}
	}
	
	/**
	 * The implementation of the Evaluation logic is placed here.
	 * @param iteration - The number of the current iteration
	 * @param currentTime - The current time
	 */
	protected abstract void evaluateImpl(int iteration, long currentTime);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TerminationCriteriaNames getName() {
		return this.name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Tree getOutputInformation() {
		if(this.outputNeedsUpdate){
			this.outputNeedsUpdate = false;
			this.updateOutputInformation();
			this.suggestedStop.updateValue("Termination suggested: " + this.evaluationResult + "; During: " + this.stopSuggestedIn);
		}
		return this.outputInformation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract void updateOutputInformation();

}