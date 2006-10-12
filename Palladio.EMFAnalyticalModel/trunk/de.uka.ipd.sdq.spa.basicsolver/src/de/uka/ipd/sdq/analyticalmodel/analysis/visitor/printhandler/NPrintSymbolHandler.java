/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.printhandler;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SymbolHandler;
import de.uka.ipd.sdq.model.analysis.expression.Symbol;


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
