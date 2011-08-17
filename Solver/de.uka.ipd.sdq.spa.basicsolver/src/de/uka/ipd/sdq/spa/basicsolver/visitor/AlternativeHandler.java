/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor;

import de.uka.ipd.sdq.spa.expression.Alternative;



/**
 * An Alternative handler is responsible for handling Alternative instances.
 * 
 * @author Ihssane
 *
 */
public interface AlternativeHandler {
	
	public void handle(Alternative alt) throws Exception;
}
