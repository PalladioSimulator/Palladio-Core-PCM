/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.SequenceHandler;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Sequence;

/**
 * @author Ihssane
 * 
 */
public class PerformanceSequenceHandler implements SequenceHandler {

	private Hashtable<Expression, IProbabilityDensityFunction> pdfTable;

	protected PerformanceSequenceHandler(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable) {
		super();
		this.pdfTable = pdfTable;
	}

	public void handle(Sequence seq) {
		try {
			IProbabilityDensityFunction leftDF = pdfTable.get(seq
					.getLeftRegExp());
			IProbabilityDensityFunction rightDF = pdfTable.get(seq
					.getRightRegExp());
			IProbabilityDensityFunction seqPDF = leftDF.mult(rightDF);
			pdfTable.put(seq, seqPDF);
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

	protected PerformanceSequenceHandler() {
		super();
	}

}
