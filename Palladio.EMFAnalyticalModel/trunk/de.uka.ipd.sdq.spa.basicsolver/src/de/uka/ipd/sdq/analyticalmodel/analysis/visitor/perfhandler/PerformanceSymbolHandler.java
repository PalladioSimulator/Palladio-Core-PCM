package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SymbolHandler;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.model.analysis.expression.Symbol;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * @author Ihssane
 * 
 */
public class PerformanceSymbolHandler implements SymbolHandler {
	
	private Hashtable<RegularExpression,IProbabilityDensityFunction> pdfTable;
	private IProbabilityFunctionFactory factory = IProbabilityFunctionFactory.eINSTANCE;


	protected PerformanceSymbolHandler(Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		super();
		this.pdfTable = pdfTable;
	}


	protected PerformanceSymbolHandler() {
		super();
	}


	public void handle(Symbol symbol) throws UnknownPDFTypeException, FunctionNotInTimeDomainException {
		IProbabilityDensityFunction pdf = factory.transformToPDF(symbol.getInputValue());
		IProbabilityDensityFunction fftPDF = pdf.getFourierTransform();
		pdfTable.put(symbol,fftPDF);		
	}


	public Hashtable<RegularExpression, IProbabilityDensityFunction> getPdfTable() {
		return pdfTable;
	}


	public void setPdfTable(
			Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable) {
		this.pdfTable = pdfTable;
	}

}
