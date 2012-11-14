/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver.handler;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;

/**
 * @author Koziolek
 *
 */
public class LoopActionHandler extends AbstractLoopActionHandler {
	
	private static Logger logger = Logger.getLogger(LoopActionHandler.class.getName());

	public LoopActionHandler(SeffVisitor seffVisitor) {
		super(seffVisitor);
	}

	public void handle(LoopAction loop) {
		String specification = loop.getIterationCount_LoopAction().getSpecification();
		String solvedSpecification = 
			ExpressionHelper.getSolvedExpressionAsString(specification, visitor.getContextWrapper());

		if (solvedSpecification == null){
			logger.error("Could not determine iterations specification. Skipping execution of loop body!");
			return;
		}
		
		logger.debug("NumberOfIterations: "+solvedSpecification);
		
		storeToUsageContext(loop, solvedSpecification);
		
		visitLoopBody(loop, solvedSpecification);
	}




}
