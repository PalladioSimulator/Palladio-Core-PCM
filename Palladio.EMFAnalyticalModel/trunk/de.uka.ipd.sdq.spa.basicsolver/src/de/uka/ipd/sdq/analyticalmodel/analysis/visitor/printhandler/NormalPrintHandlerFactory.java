/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.printhandler;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.AlternativeHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.HandlerFactory;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.LoopHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SequenceHandler;
import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SymbolHandler;


/**
 * @author Ihssane
 *
 */
public class NormalPrintHandlerFactory implements HandlerFactory{
	
	public SymbolHandler createSymbolHandler() {
		return new NPrintSymbolHandler();
	}

	public SequenceHandler createSequenceHandler() {
		return new NPrintSequenceHandler();
	}

	public AlternativeHandler createAlternativeHandler() {
		return new NPrintAlternativeHandler();
	}

	public LoopHandler createLoopHandler() {
		return new NPrintLoopHandler();
	}
	

}
