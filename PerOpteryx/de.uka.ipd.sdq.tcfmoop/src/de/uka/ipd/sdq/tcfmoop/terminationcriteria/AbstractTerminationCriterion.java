/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import org.opt4j.core.Archive;
import org.opt4j.core.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;

/**
 * @author Atanas Dimitrov
 *
 */
public abstract class AbstractTerminationCriterion implements ITerminationCriterion {
	
	protected boolean evaluationResult = false;
	protected StringBuilder outputInformation = new StringBuilder();
	protected Population population;
	protected Archive archive;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.tcfmoop.terminationcriteria.ITerminationCriteria#getEvaluationResult()
	 */
	@Override
	public final boolean getEvaluationResult() {
		return this.evaluationResult;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.tcfmoop.terminationcriteria.ITerminationCriteria#getOutputInformation()
	 */
	@Override
	public StringBuilder getOutputInformation() {
		return this.outputInformation;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.tcfmoop.terminationcriteria.ITerminationCriteria#initialize()
	 */
	@Override
	public void initialize(IConfiguration conf, Population population,
			Archive archive) {
		this.archive = archive;
		this.population = population;
	}

}