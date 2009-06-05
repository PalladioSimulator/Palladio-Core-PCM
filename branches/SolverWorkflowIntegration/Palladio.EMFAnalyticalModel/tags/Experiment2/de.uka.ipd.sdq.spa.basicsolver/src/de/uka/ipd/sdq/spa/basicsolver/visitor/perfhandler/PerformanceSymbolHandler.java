package de.uka.ipd.sdq.spa.basicsolver.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.spa.basicsolver.visitor.SymbolHandler;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

/**
 * @author Ihssane
 * 
 */
public class PerformanceSymbolHandler implements SymbolHandler {

	private Hashtable<Expression, IProbabilityDensityFunction> pdfTable;

	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private int domainSize;

	protected PerformanceSymbolHandler(
			Hashtable<Expression, IProbabilityDensityFunction> pdfTable, int domainSize) {
		this(domainSize);
		this.pdfTable = pdfTable;
	}

	protected PerformanceSymbolHandler(int domainSize) {
		super();
		this.domainSize = domainSize;
	}

	public void handle(Symbol symbol) {

		try {
			ResourceUsage resourceUsage = (ResourceUsage) symbol.getResourceUsages().get(0);
			IProbabilityDensityFunction pdf = pfFactory.transformToPDF(resourceUsage.getUsageTime());
			ISamplePDF spdf = pfFactory.transformToSamplePDF(pdf);
			spdf.expand(domainSize);
			IProbabilityDensityFunction fftPDF = spdf.getFourierTransform();
			pdfTable.put(symbol, fftPDF);
		} catch (ProbabilityFunctionException e) {
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

}
