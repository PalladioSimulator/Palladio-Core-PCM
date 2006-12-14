/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.helper.ExpressionHelper;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.seff.LoopAction;

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
		String specification = loop.getIterations_LoopAction().getSpecification();
		String solvedSpecification = 
			ExpressionHelper.getSolvedExpressionAsString(specification, visitor.getMyContext());

		if (solvedSpecification == null){
			logger.error("Skipping execution of loop body!");
			return;
		}
		
		storeToUsageContext(loop, solvedSpecification);
		
		visitLoopBody(loop, solvedSpecification);
	}




}
