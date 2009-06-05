/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.printhandler;

import de.uka.ipd.sdq.spa.basicsolver.visitor.SymbolHandler;
import de.uka.ipd.sdq.spa.expression.Symbol;


/**
 * @author Ihssane
 *
 */
public class NPrintSymbolHandler implements SymbolHandler{

	public void handle(Symbol symbol) {
//		terminal.setResult(terminal.getSymbol());
		System.out.print(symbol.getName());
	}

}
