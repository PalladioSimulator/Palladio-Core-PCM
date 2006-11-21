package de.uka.ipd.sdq.spa.basicsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public class RUOperations {

	private PDFOperations pdfOps;

	public RUOperations(PDFOperations pdfOps) {
		super();
		this.pdfOps = pdfOps;
	}
	
	public RUOperations(int numSamplingPoints) {
		this(new PDFOperations(numSamplingPoints));
	}

	public ManagedPDF computeIteration(ManagedPDF usage,
			IProbabilityMassFunction iterations)
			throws ProbabilityFunctionException {
		IProbabilityDensityFunction pdf = usage.getPdfFrequencyDomain();
		IProbabilityDensityFunction resultPDF = pdfOps.computeIteration(pdf,
				iterations);
		return new ManagedPDF(resultPDF);
	}

	public ManagedPDF computeAlternative(BinaryOperation op,
			ManagedPDF leftRU, double leftProbability,
			ManagedPDF rightRU, double rightProbability)
			throws ProbabilityFunctionException {
		return performOperation(BinaryOperation.ALTERNATIVE, leftRU,
				leftProbability, rightRU, rightProbability);
	}

	public ManagedPDF computeSequence(BinaryOperation op,
			ManagedPDF leftRU, ManagedPDF rightRU)
			throws ProbabilityFunctionException {
		return performOperation(BinaryOperation.SEQUENCE, leftRU, 0, rightRU, 0);
	}

	public ManagedPDF computeParallel(BinaryOperation op,
			ManagedPDF leftRU, ManagedPDF rightRU)
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
			resultPDF = pdfOps.computeSequence(leftPDF, rightPDF);
			break;
		case ALTERNATIVE:
			resultPDF = pdfOps.computeAlternative(leftPDF, leftProbability,
					rightPDF, rightProbability);
			break;
		case PARALLEL:
			resultPDF = pdfOps.computeParallel(leftPDF, rightPDF);
			break;
		default:
			break;
		}

		return new ManagedPDF(resultPDF);
	}

	public int getNumSamplingPoints() {
		return pdfOps.getNumSamplingPoints();
	}
	
}
