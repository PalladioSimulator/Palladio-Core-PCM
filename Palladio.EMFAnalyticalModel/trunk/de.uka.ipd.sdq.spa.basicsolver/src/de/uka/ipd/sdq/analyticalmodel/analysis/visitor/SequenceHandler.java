/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;

import de.uka.ipd.sdq.model.analysis.expression.Sequence;


/**
 * A Sequence handler is responsible for handling Sequence instances.
 * 
 * @author Ihssane
 *
 */
public interface SequenceHandler {
	
	public void handle(Sequence seq) throws Exception;

}
