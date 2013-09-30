/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor;

import de.uka.ipd.sdq.spa.expression.Sequence;


/**
 * A Sequence handler is responsible for handling Sequence instances.
 * 
 * @author Ihssane
 *
 */
public interface SequenceHandler {
	
	public void handle(Sequence seq) throws Exception;

}
