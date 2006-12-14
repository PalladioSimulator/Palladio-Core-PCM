package de.uka.ipd.sdq.simucomframework.stoexvisitor;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;
import de.uka.ipd.sdq.simucomframework.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.cache.StoExCacheEntry;

public class PCMProbfunctionEvaluationVisitor extends ProbfunctionSwitch {

	private String stoex;

	public PCMProbfunctionEvaluationVisitor(String stoex) {
		this.stoex = stoex;
	}
	
	@Override
	public Object caseProbabilityDensityFunction(ProbabilityDensityFunction object) {
		IProbabilityFunction pdf = StoExCache.singleton().getEntry(stoex).getProbFunction(object);
		return drawSample(pdf);
	}

	@Override
	public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
		IProbabilityFunction pdf = StoExCache.singleton().getEntry(stoex).getProbFunction(object);
		return drawSample(pdf);
	}

	private Object drawSample(IProbabilityFunction f) {
		if (f instanceof IProbabilityMassFunction)
			return ((IProbabilityMassFunction)f).drawSample();
		if (f instanceof IProbabilityDensityFunction)
			return ((IProbabilityDensityFunction)f).drawSample();
		throw new RuntimeException("Should never be here. Unknown Probfunction found!");
	}
}
