package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSECreator;

/**
 * XXX: Make this a strategy how to obtain Genotypes? Not a subtype of PredefinedInstanceEvaluator?
 * @author Anne
 *
 */
public class RandomSearch extends PredefinedInstanceEvaluator{
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.start.RandomSearch");
	
	private DSECreator creator = new DSECreator();
	private int numberOfCandidates = 0;

	public RandomSearch(DSEWorkflowConfiguration dseConfig) throws CoreException {
		super(dseConfig);
		this.numberOfCandidates =  dseConfig.getMaxIterations() * dseConfig.getIndividualsPerGeneration();
		if (this.numberOfCandidates == 0){
			logger.warn("Max iterations times number of individuals is zero, no candidates are created.");
		}
	}


	private List<DesignDecisionGenotype> createRandomCandidates(long numberOfCandidates) {
		
		List<DesignDecisionGenotype> result = new ArrayList<DesignDecisionGenotype>();
		for (long i = 0; i < numberOfCandidates; i++) {
			result.add(this.creator.create());
		}
		
		return result;
	}

	/**
	 * Creates a new random list of genotypes each time.
	 */
	@Override
	protected List<DesignDecisionGenotype> getGenotypes() {
		return createRandomCandidates(this.numberOfCandidates);
	}

}
