/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor;

import de.uka.ipd.sdq.spa.expression.Loop;


/**
 * A Loop handler is responsible for handling Loop instances.
 * 
 * @author Ihssane
 *
 */
public interface LoopHandler {
	
	public void handle(Loop loop) throws Exception;
	
}
