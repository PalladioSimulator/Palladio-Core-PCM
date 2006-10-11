/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public abstract class ProbabilityDensityFunctionImpl extends
		ProbabilityFunctionImpl implements IProbabilityDensityFunction {

	protected ProbabilityDensityFunctionImpl(IUnit unit,
			boolean isInFrequencyDomain) {
		super(unit, true, isInFrequencyDomain);
	}

	// hide constructor
	protected ProbabilityDensityFunctionImpl() {
	}

	/**
	 * Creates two functions with an equal distance, if both functions are in
	 * the time domain. Precondition: Functions are in the same domain.
	 * 
	 * @param pdf1
	 * @param pdf2
	 * @return
	 * @throws FunctionNotInTimeDomainException
	 * @throws NegativeDistanceException
	 * @throws FunctionNotInTimeDomainException
	 *             Thrown if one of the input pdfs is not in the time domain.
	 */
	protected static List<ISamplePDF> createFunctionsWithEqualDistance(
			ISamplePDF pdf1, ISamplePDF pdf2) {

		ArrayList<ISamplePDF> resultList = new ArrayList<ISamplePDF>();

		try {
			if (!MathTools.equalsDouble(pdf1.getDistance(), pdf2.getDistance())) {
				boolean inTimeDomain = pdf1.isInTimeDomain();

				if (!inTimeDomain) {
					pdf1 = (ISamplePDF) pdf1.getInverseFourierTransform();
					pdf2 = (ISamplePDF) pdf2.getInverseFourierTransform();
				}

				double distance = MathTools.gcd(pdf1.getDistance(), pdf2
						.getDistance());

				pdf1 = pdf1.getFunctionWithNewDistance(distance);
				pdf2 = pdf2.getFunctionWithNewDistance(distance);

				if (!inTimeDomain) {
					pdf1 = (ISamplePDF) pdf1.getFourierTransform();
					pdf2 = (ISamplePDF) pdf2.getFourierTransform();
				}

			}

			resultList.add(pdf1);
			resultList.add(pdf2);
		} catch (FunctionNotInFrequencyDomainException e) {
			// should never happen
			e.printStackTrace();
			System.exit(1);
		} catch (NegativeDistanceException e) {
			// should never happen
			e.printStackTrace();
			System.exit(1);
		} catch (FunctionNotInTimeDomainException e) {
			// should never happen
			e.printStackTrace();
			System.exit(1);
		}
		return resultList;
	}


}
