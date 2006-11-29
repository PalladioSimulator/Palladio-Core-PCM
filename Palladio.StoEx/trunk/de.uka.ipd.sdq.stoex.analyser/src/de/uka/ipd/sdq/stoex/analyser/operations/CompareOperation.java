package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;

public abstract class CompareOperation {

	public abstract IProbabilityMassFunction compare(double left, double right);
	
	public abstract IProbabilityMassFunction compare(IProbabilityMassFunction left, double right);
		
	
	public abstract IProbabilityMassFunction compare(double left, IProbabilityMassFunction right);
	
	public abstract IProbabilityMassFunction compare(IProbabilityMassFunction left, IProbabilityMassFunction right);
	

	/**
	 * @param left
	 * @param right
	 * @return
	 */
	public IProbabilityMassFunction getBoolPMF(double trueProb) {
		IProbabilityFunctionFactory probFac = 
			IProbabilityFunctionFactory.eINSTANCE;

		IUnit unit = probFac.createUnit("bool");
		
		List<ISample> sampleList = new ArrayList<ISample>();
		sampleList.add(probFac.createSample("TRUE", trueProb));
		sampleList.add(probFac.createSample("FALSE", 1-trueProb));

		IProbabilityMassFunction boolPMF = probFac
				.createProbabilityMassFunction(sampleList, unit, true);

		return boolPMF;
	}
}
