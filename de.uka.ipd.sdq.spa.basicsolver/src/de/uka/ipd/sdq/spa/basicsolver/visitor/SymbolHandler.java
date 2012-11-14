/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor;

import de.uka.ipd.sdq.spa.expression.Symbol;


/**
 * A Terminal handler is responsible for handling Terminal instances.
 * 
 * @author Ihssane
 *
 */
public interface SymbolHandler {
	
	public void handle(Symbol symbol) throws Exception;
}
