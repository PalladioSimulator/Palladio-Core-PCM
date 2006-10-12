/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SequenceHandler;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.model.analysis.expression.Sequence;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityDensityFunctionImpl;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;


/**
 * @author Ihssane
 * 
 */
public class PerformanceSequenceHandler implements SequenceHandler {

	private Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable;
	
	protected PerformanceSequenceHandler(Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		super();
		this.pdfTable = pdfTable;
	}

	public void handle(Sequence seq) throws FunctionsInDifferenDomainsException, UnknownPDFTypeException {
		IProbabilityDensityFunction leftDF = pdfTable.get(seq.getLeftRegExp());
		IProbabilityDensityFunction rightDF = pdfTable.get(seq.getRightRegExp());
		IProbabilityDensityFunction seqPDF = leftDF.mult(rightDF);
		pdfTable.put(seq, seqPDF);
	}

	public Hashtable<RegularExpression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}

	public void setPdfTable(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

	protected PerformanceSequenceHandler() {
		super();
	}

}
