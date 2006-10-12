/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler;

import java.util.Hashtable;
import java.util.Iterator;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.LoopHandler;
import de.uka.ipd.sdq.model.analysis.expression.Loop;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.model.math.probfunction.EProbabilityMassFunction;
import de.uka.ipd.sdq.model.math.probfunction.ESample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.impl.SamplePDFImpl;

/**
 * @author Ihssane
 * 
 */
public class PerformanceLoopHandler implements LoopHandler {

	private Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable;

	private IProbabilityFunctionFactory factory = IProbabilityFunctionFactory.eINSTANCE;

	protected PerformanceLoopHandler(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		super();
		this.pdfTable = pdfTable;
	}

	/**
	 * the iterations of a loop have to be specified as a probability mass
	 * functions whose samples are integer values (type Integer)
	 * @throws UnknownPDFTypeException 
	 * @throws FunctionNotInTimeDomainException 
	 * @throws FunctionsInDifferenDomainsException 
	 */
	public void handle(Loop loop) throws UnknownPDFTypeException, FunctionNotInTimeDomainException, FunctionsInDifferenDomainsException {
		ISamplePDF innerPDF = factory.transformToSamplePDF(pdfTable.get(loop
				.getRegExp()));
		int numSamplingPoints = innerPDF.getValuesAsDouble().size();
		double distance = innerPDF.getDistance();

		ISamplePDF result = factory.createZeroFunction(numSamplingPoints,
				distance);

		ISamplePDF dirac = factory.createDiracImpulse(numSamplingPoints,
				distance, pfFactory.createDefaultUnit());

		IProbabilityDensityFunction tmp = dirac.getFourierTransform();

		EProbabilityMassFunction iterations = loop.getIterations();

		int pos = 0;
		for (Iterator iter = iterations.getSamples().iterator(); iter.hasNext();) {
			ESample sample = (ESample) iter.next();
			Integer nextPos = (Integer) sample.getValue(); // or EInt ??
			while (pos < nextPos) {
				tmp = tmp.mult(innerPDF);
				pos++;
			}
			result = (SamplePDFImpl) result.add(tmp.scale(sample.getProbability()));
		}

		pdfTable.put(loop, result);

	}

	public Hashtable<RegularExpression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}

	public void setPdfTable(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	protected PerformanceLoopHandler() {
		super();
	}

}
