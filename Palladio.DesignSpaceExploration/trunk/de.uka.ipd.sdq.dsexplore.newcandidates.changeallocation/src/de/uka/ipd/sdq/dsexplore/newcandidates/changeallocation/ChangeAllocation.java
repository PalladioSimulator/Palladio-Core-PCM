package de.uka.ipd.sdq.dsexplore.newcandidates.changeallocation;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;


public class ChangeAllocation implements INewCandidates {
	
	/** Logger for log4j. */
	protected static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public ChangeAllocation() {

	}

	@Override
	public List<PCMInstance> generateNewCandidates(IAnalysisResult currentSolution) throws CoreException {
		
		logger.debug("ChangeAllocation called");
	
		List<PCMInstance> resultingPCMInstances = new ArrayList<PCMInstance>();

		
		return resultingPCMInstances;
		
	}


	
}
