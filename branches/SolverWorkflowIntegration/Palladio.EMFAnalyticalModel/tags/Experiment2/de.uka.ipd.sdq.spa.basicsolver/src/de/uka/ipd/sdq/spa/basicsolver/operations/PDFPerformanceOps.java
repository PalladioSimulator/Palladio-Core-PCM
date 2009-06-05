package de.uka.ipd.sdq.spa.basicsolver.operations;

import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public class PDFPerformanceOps {

	public PDFPerformanceOps() {
		super();
	}
	
	public ManagedPDF computeIteration(ManagedPDF usage,
			IProbabilityMassFunction iterations)
			throws ProbabilityFunctionException, ConfigurationNotSetException {
		ISamplePDF innerPDF = usage.getSamplePdfFrequencyDomain();
		
		ISamplePDF resultPDF = ManagedPDF.createZeroFunction().getSamplePdfFrequencyDomain();
		ISamplePDF tempPDF = ManagedPDF.createDiracImpulse().getSamplePdfFrequencyDomain();

		int pos = 0;
		for (Iterator<ISample> iter = iterations.getSamples().iterator(); iter
				.hasNext();) {
			ISample sample = iter.next();
			Integer nextPos = (Integer) sample.getValue();
			while (pos < nextPos) {
				tempPDF = (ISamplePDF)tempPDF.mult(innerPDF);
				pos++;
			}
			resultPDF = (ISamplePDF) resultPDF.add(tempPDF.scale(sample.getProbability()));
		}
		return new ManagedPDF(resultPDF, true);
	}

	public ManagedPDF computeAlternative(ManagedPDF leftRU, double leftProbability,
			ManagedPDF rightRU, double rightProbability)
			throws ProbabilityFunctionException {
		return performOperation(BinaryOperation.ALTERNATIVE, leftRU,
				leftProbability, rightRU, rightProbability);
	}

	public ManagedPDF computeSequence(ManagedPDF leftRU, ManagedPDF rightRU)
			throws ProbabilityFunctionException {
		return performOperation(BinaryOperation.SEQUENCE, leftRU, 0, rightRU, 0);
	}

	public ManagedPDF computeParallel(ManagedPDF leftRU, ManagedPDF rightRU)
			throws ProbabilityFunctionException {
		return performOperation(BinaryOperation.PARALLEL, leftRU, 0, rightRU, 0);
	}


	protected ManagedPDF performOperation(BinaryOperation op,
			ManagedPDF leftRU, double leftProbability,
			ManagedPDF rightRU, double rightProbability)
			throws ProbabilityFunctionException {

		IProbabilityDensityFunction resultPDF = null;
		IProbabilityDensityFunction leftPDF = leftRU.getPdfFrequencyDomain();
		IProbabilityDensityFunction rightPDF = rightRU.getPdfFrequencyDomain();

		switch (op) {
		case SEQUENCE:
			resultPDF = leftPDF.mult(rightPDF); 
			break;
		case ALTERNATIVE:
			resultPDF = leftPDF.scale(leftProbability).add(rightPDF.scale(rightProbability));
			break;
		case PARALLEL:
			// TODO add correct computation for parallel
			resultPDF = leftPDF.mult(rightPDF); 
			break;
		default:
			break;
		}

		return new ManagedPDF(resultPDF, true);
	}

}
