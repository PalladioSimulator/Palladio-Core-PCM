package de.uka.ipd.sdq.simucomframework.stoexvisitor;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;

public class PCMProbfunctionEvaluationVisitor extends ProbfunctionSwitch {

	@Override
	public Object caseProbabilityDensityFunction(ProbabilityDensityFunction object) {
		// TODO Auto-generated method stub
		return super.caseProbabilityDensityFunction(object);
	}

	@Override
	public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
		IProbabilityMassFunction pmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(object);		
		return pmf.drawSample();
	}

}
