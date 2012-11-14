/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler;

import java.util.Hashtable;
import java.util.Iterator;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.LoopHandler;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;

/**
 * @author Ihssane
 * 
 */
public class PerformanceLoopHandler implements LoopHandler {

	private Hashtable<Expression, IProbabilityDensityFunction> pdfTable;

	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	protected PerformanceLoopHandler(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		super();
		this.pdfTable = pdfTable;
	}

	/**
	 * the iterations of a loop have to be specified as a probability mass
	 * functions whose samples are integer values (type Integer)
	 * 
	 * @throws UnknownPDFTypeException
	 * @throws FunctionNotInTimeDomainException
	 * @throws FunctionsInDifferenDomainsException
	 */
	public void handle(Loop loop) {
		try {
			
			ISamplePDF innerPDF = pfFactory.transformToSamplePDF(pdfTable
					.get(loop.getRegExp()));
			IProbabilityMassFunction iterations = pfFactory.transformToPMF(loop.getIterationsPMF());
			ISamplePDF result = solveIterative(iterations, innerPDF);
			pdfTable.put(loop, result);
			
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static ISamplePDF solveIterative(IProbabilityMassFunction iterations, ISamplePDF innerFourier) throws ProbabilityFunctionException {
		int numSamplingPoints = innerFourier.getValuesAsDouble().size();
		double distance = innerFourier.getDistance();
		IUnit unit = innerFourier.getUnit();

		ISamplePDF result = (ISamplePDF)pfFactory.createZeroFunction(numSamplingPoints,
				distance, unit).getFourierTransform();

		ISamplePDF dirac = pfFactory.createDiracImpulse(numSamplingPoints,
				distance, unit);

		IProbabilityDensityFunction tmp = dirac.getFourierTransform();


		int pos = 0;
		for (Iterator<ISample> iter = iterations.getSamples().iterator(); iter
				.hasNext();) {
			ISample sample = iter.next();
			Integer nextPos = (Integer) sample.getValue();
			while (pos < nextPos) {
				tmp = tmp.mult(innerFourier);
				pos++;
			}
			result = (ISamplePDF) result.add(tmp.scale(sample
					.getProbability()));
		}
		return result;
	}

	public Hashtable<Expression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}

	public void setPdfTable(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	protected PerformanceLoopHandler() {
		super();
	}

}
