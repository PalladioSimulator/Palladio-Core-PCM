package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**
 * Values need to be separated by a semicolon. 
 * @author Anne
 *
 */
public class GivenInstanceEvaluator extends PredefinedInstanceEvaluator {
	
	private String filename;
	private MDSDBlackboard blackboard;
	
	public GivenInstanceEvaluator(DSEWorkflowConfiguration dseConfig, DecisionSpace problem, MDSDBlackboard blackboard) throws CoreException {
		super(dseConfig, problem);
		if (dseConfig.hasPredefinedInstances()){
			this.filename = dseConfig.getPredefinedInstancesFileName();
			this.blackboard = blackboard;
		}

	}

	@Override
	protected List<DesignDecisionGenotype> getGenotypes() throws CoreException{
		if (this.filename != null){
			return GenotypeReader.getGenotypes(filename, this.blackboard);
		} else {
			return Collections.emptyList();
		}
		 
	}



}
