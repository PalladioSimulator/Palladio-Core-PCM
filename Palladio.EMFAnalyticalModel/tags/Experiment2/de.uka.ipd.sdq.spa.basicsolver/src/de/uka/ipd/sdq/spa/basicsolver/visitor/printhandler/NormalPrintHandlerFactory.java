/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.printhandler;

import de.uka.ipd.sdq.spa.basicsolver.visitor.AlternativeHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.HandlerFactory;
import de.uka.ipd.sdq.spa.basicsolver.visitor.LoopHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.SequenceHandler;
import de.uka.ipd.sdq.spa.basicsolver.visitor.SymbolHandler;


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
