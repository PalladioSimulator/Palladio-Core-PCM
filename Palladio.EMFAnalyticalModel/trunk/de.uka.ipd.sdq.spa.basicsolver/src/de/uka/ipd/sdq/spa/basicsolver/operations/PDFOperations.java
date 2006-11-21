package de.uka.ipd.sdq.spa.basicsolver.operations;

import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

public class PDFOperations {
	
	private final IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private int numSamplingPoints;


	public PDFOperations(int numSamplingPoints) {
		super();
		this.numSamplingPoints = numSamplingPoints;
	}
	
	public IProbabilityDensityFunction computeIteration(
			IProbabilityDensityFunction innerTimePDF,
			IProbabilityMassFunction iterations)
			throws ProbabilityFunctionException {

		ISamplePDF innerSamplePDF = pfFactory.transformToSamplePDF(innerTimePDF);
		double distance = innerSamplePDF.getDistance();
		IUnit unit = innerSamplePDF.getUnit();

		IProbabilityDensityFunction result = (ISamplePDF) pfFactory
				.createZeroFunction(numSamplingPoints, distance, unit)
				.getFourierTransform();

		ISamplePDF dirac = pfFactory.createDiracImpulse(
				numSamplingPoints, distance, unit);

		IProbabilityDensityFunction tmp = dirac.getFourierTransform();

		int pos = 0;
		for (Iterator<ISample> iter = iterations.getSamples().iterator(); iter
				.hasNext();) {
			ISample sample = iter.next();
			Integer nextPos = (Integer) sample.getValue();
			while (pos < nextPos) {
				tmp = tmp.mult(innerSamplePDF);
				pos++;
			}
			result = (IProbabilityDensityFunction) result
					.add(tmp.scale(sample.getProbability()));
		}
		return result;
	}

	public IProbabilityDensityFunction computeParallel(
			IProbabilityDensityFunction leftPDF,
			IProbabilityDensityFunction rightPDF)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {

		return computeSequence(leftPDF, rightPDF); // Just for testing!!
	}

	public IProbabilityDensityFunction computeSequence(
			IProbabilityDensityFunction leftDF,
			IProbabilityDensityFunction rightDF)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {

		return leftDF.mult(rightDF);
	}

	public IProbabilityDensityFunction computeAlternative(
			IProbabilityDensityFunction leftDF, double leftProb,
			IProbabilityDensityFunction rightDF, double rightProb)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {

		return leftDF.scale(leftProb).add(rightDF.scale(rightProb));
	}

	public int getNumSamplingPoints() {
		return numSamplingPoints;
	}


}
