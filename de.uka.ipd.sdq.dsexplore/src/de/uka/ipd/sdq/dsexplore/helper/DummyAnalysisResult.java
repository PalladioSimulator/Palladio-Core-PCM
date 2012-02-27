package de.uka.ipd.sdq.dsexplore.helper;

import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class DummyAnalysisResult implements IAnalysisResult {

	public DummyAnalysisResult(PCMInstance pcmInstance) {
		
	}

	@Override
	public double getValueFor(Criterion criterion){
		return 0;
	}


}
