/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author Ihssane
 * 
 */
public class BoxedPDFImpl extends ProbabilityDensityFunctionImpl implements
		IBoxedPDF {

	private List<IContinuousSample> samples;

	protected BoxedPDFImpl() {
		super();
		samples = new ArrayList<IContinuousSample>();
	}

	protected BoxedPDFImpl(List<IContinuousSample> samples) {
		this();
		this.samples = samples;
	}

	public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.add(pdf);
	}

	public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.mult(pdf);
	}

	public IProbabilityDensityFunction scale(double scalar) {
		List<IContinuousSample> list = new ArrayList<IContinuousSample>();
		for (IContinuousSample s : this.samples)
			list.add(pfFactory.createContinuousSample(s.getValue(), s
					.getProbability()
					* scalar));

		return pfFactory.createBoxedPDF(list);
	}

	public List<IContinuousSample> getSamples() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSamples(List<IContinuousSample> samples) {
		// TODO Auto-generated method stub

	}

	public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException {
		// TODO Auto-generated method stub
		return null;
	}

	public double drawSample() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IProbabilityDensityFunction getFourierTransform()
			throws FunctionNotInTimeDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public IProbabilityDensityFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public double getLowerDomainBorder() {
		// TODO Auto-generated method stub
		return 0;
	}

	public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException {
		// TODO Auto-generated method stub
		return null;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getMedian() throws UnorderedDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isInFrequencyDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTimeDomain() {
		// TODO Auto-generated method stub
		return false;
	}

}
