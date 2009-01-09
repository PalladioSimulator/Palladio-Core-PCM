package de.uka.ipd.sdq.dsexplore.helper;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class DummyAnalysisResult implements IAnalysisResult {
	
	private PCMInstance pcmInstance;

	public DummyAnalysisResult(PCMInstance pcmInstance) {
		this.pcmInstance = pcmInstance;
	}

	public void setPCMInstance(PCMInstance inst){
		this.pcmInstance = inst;
	}

	@Override
	public int compareTo(IAnalysisResult other) {
		return 0;
	}

	@Override
	public double getMeanValue() throws AnalysisFailedException {
		return 0;
	}

	@Override
	public PCMInstance getPCMInstance() {
		return this.pcmInstance;
	}

	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			throws AnalysisFailedException {
		return 0;
	}

	@Override
	public double getMedianValue() throws AnalysisFailedException {
		return 0;
	}

}
