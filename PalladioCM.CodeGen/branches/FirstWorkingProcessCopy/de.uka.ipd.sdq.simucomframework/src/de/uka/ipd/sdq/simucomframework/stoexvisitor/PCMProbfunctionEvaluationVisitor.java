package de.uka.ipd.sdq.simucomframework.stoexvisitor;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;

public class PCMProbfunctionEvaluationVisitor extends ProbfunctionSwitch {

	@Override
	public Object caseProbabilityDensityFunction(ProbabilityDensityFunction object) {
		IProbabilityDensityFunction pdf = null;
		try {
			pdf = IProbabilityFunctionFactory.eINSTANCE.transformToPDF(object);
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (ProbabilitySumNotOneException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (DoubleSampleException e) {
			e.printStackTrace();
			System.exit(-1);
		}		
		return pdf.drawSample();
	}

	@Override
	public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
		IProbabilityMassFunction pmf = IProbabilityFunctionFactory.eINSTANCE.transformToPMF(object);		
		return pmf.drawSample();
	}

}
