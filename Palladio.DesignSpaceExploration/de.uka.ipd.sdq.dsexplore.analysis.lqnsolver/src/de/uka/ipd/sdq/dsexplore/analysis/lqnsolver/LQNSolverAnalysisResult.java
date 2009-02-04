package de.uka.ipd.sdq.dsexplore.analysis.lqnsolver;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class LQNSolverAnalysisResult implements IAnalysisResult {

	@Override
	public int compareTo(IAnalysisResult other) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMeanValue() throws AnalysisFailedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMedianValue() throws AnalysisFailedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PCMInstance getPCMInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			throws AnalysisFailedException {
		// TODO Auto-generated method stub
		return 0;
	}

}
