package de.uka.ipd.sdq.dsexplore.helper;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class DummyAnalysisResult implements IAnalysisResult {

	public DummyAnalysisResult(PCMInstance pcmInstance) {
		
	}


	@Override
	public int compareTo(IAnalysisResult other) {
		return 0;
	}

	@Override
	public double getMeanValue() {
		return 0;
	}


}
