/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;

import de.uka.ipd.sdq.model.analysis.expression.Loop;


/**
 * A Loop handler is responsible for handling Loop instances.
 * 
 * @author Ihssane
 *
 */
public interface LoopHandler {
	
	public void handle(Loop loop) throws Exception;
	
}
