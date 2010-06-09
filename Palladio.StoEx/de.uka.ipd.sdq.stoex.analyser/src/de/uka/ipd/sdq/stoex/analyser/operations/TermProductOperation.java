package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * An interface for term (+,-) and product (*,/,%) operations.  
 * @author koziolek
 */
public interface TermProductOperation {

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException;
	
	public int compute(int left, int right);
	
	public double compute(double left, double right);
	
	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			double right) throws DomainNotNumbersException;

	public IProbabilityDensityFunction compute(
			IProbabilityDensityFunction leftPDF,
			IProbabilityDensityFunction rightPDF)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException;

	public IProbabilityDensityFunction compute(
			IProbabilityDensityFunction left, double right)
			throws DomainNotNumbersException;
	
}
