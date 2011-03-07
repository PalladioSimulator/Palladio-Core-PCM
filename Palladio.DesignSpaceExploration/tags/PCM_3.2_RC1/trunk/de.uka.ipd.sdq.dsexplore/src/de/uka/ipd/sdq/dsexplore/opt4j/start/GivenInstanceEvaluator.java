package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;

/**
 * Values need to be separated by a semicolon. 
 * @author Anne
 *
 */
public class GivenInstanceEvaluator extends PredefinedInstanceEvaluator {
	
	private String filename;
	
	public GivenInstanceEvaluator(DSEWorkflowConfiguration dseConfig) throws CoreException {
		super(dseConfig);
		this.filename = dseConfig.getPredefinedInstancesFileName();

	}

	@Override
	protected List<DesignDecisionGenotype> getGenotypes() throws CoreException{
		return GenotypeReader.getGenotypes(filename); 
	}



}
