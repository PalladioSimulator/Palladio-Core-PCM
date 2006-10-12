/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.AlternativeHandler;
import de.uka.ipd.sdq.model.analysis.expression.Alternative;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * @author Ihssane
 * 
 */
public class PerformanceAlternativeHandler implements AlternativeHandler {

	private Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable;

	protected PerformanceAlternativeHandler(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
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
		}
	}

	public Hashtable<RegularExpression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}

	public void setPdfTable(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	public PerformanceAlternativeHandler() {
		super();
	}

}
