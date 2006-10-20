/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.AlternativeHandler;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;

/**
 * @author Ihssane
 * 
 */
public class PerformanceAlternativeHandler implements AlternativeHandler {

	private Hashtable<Expression, IProbabilityDensityFunction> pdfTable;

	protected PerformanceAlternativeHandler(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	public void handle(Alternative alt) {
			try {
				IProbabilityDensityFunction leftDF = pdfTable.get(alt.getLeftOption()
						.getRegexp());
				IProbabilityDensityFunction rightDF = pdfTable.get(alt.getRightOption()
						.getRegexp());
				double rightProb = alt.getRightOption().getProbability();
				double leftProb = alt.getLeftOption().getProbability();

				IProbabilityDensityFunction altPDF = leftDF.scale(leftProb).add(
						rightDF.scale(rightProb));
				pdfTable.put(alt, altPDF);
			} catch (FunctionsInDifferenDomainsException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (IncompatibleUnitsException e) {
				e.printStackTrace();
				System.exit(1);
			}
	}

	public Hashtable<Expression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}

	public void setPdfTable(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	public PerformanceAlternativeHandler() {
		super();
	}

}
