/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.perfhandler;

import java.util.Hashtable;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.HandlerFactory;
import de.uka.ipd.sdq.model.analysis.expression.RegularExpression;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;

/**
 * @author Ihssane
 * 
 */
public class PerformanceHandlerFactory implements HandlerFactory {

	private Hashtable<RegularExpression, IProbabilityDensityFunction> pdfTable;

	public PerformanceHandlerFactory() {
		super();
		this.pdfTable = new Hashtable<RegularExpression, IProbabilityDensityFunction>();
	}

	public PerformanceSymbolHandler createSymbolHandler() {
		return new PerformanceSymbolHandler(pdfTable);
	}

	public PerformanceSequenceHandler createSequenceHandler() {
		return new PerformanceSequenceHandler(pdfTable);
	}

	public PerformanceAlternativeHandler createAlternativeHandler() {
		return new PerformanceAlternativeHandler(pdfTable);
	}

	public PerformanceLoopHandler createLoopHandler() {
		return new PerformanceLoopHandler(pdfTable);
	}
}
