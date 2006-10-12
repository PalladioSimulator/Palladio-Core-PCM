/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;

import de.uka.ipd.sdq.model.analysis.expression.Symbol;


/**
 * A Terminal handler is responsible for handling Terminal instances.
 * 
 * @author Ihssane
 *
 */
public interface SymbolHandler {
	
	public void handle(Symbol symbol) throws Exception;
}
