/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor;

import de.uka.ipd.sdq.model.analysis.expression.Alternative;



/**
 * An Alternative handler is responsible for handling Alternative instances.
 * 
 * @author Ihssane
 *
 */
public interface AlternativeHandler {
	
	public void handle(Alternative alt) throws Exception;
}
