/**
 * 
 */
package de.uka.ipd.sdq.pcmsolver.handler;

import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

/**
 * @author Koziolek
 * 
 */
public class GuardedBranchTransitionHandler extends AbstractBranchTransitionHandler{

	private static Logger logger = Logger.getLogger(GuardedBranchTransitionHandler.class.getName());

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public GuardedBranchTransitionHandler(SeffVisitor seffVisitor) {
		super(seffVisitor);
	}

	public void handle(GuardedBranchTransition bt){
		double solvedBranchProb = getBranchProbFromExpression(bt);
		logger.debug("SolvedBranchProb:" + solvedBranchProb);
		
		storeToUsageContext(bt, solvedBranchProb);

		// Don't solve branch transitions that can never be reached. This
		// releases the modeler from the duty to provide all character
		// parameterizations for branches that are never reached (see Bug 615)
		if (solvedBranchProb > 0.0) {
			visitChildBehaviour(bt);
		}
		
// TODO: recognise scopes
//		int lastElement = visitor.getContextWrapper().getCurrentEvaluatedBranchConditions().size()-1;
//		visitor.getContextWrapper().getCurrentEvaluatedBranchConditions().remove(lastElement);
	}
	
	/**
	 * @param bt
	 * @param solvedBranchProb
	 * @return
	 */
	private double getBranchProbFromExpression(GuardedBranchTransition bt) {
		String specification = bt.getBranchCondition_GuardedBranchTransition().getSpecification(); 
		Expression solvedExpression = ExpressionHelper.getSolvedExpression(specification,visitor.getContextWrapper());

		ProbabilityFunctionLiteral pfl = (ProbabilityFunctionLiteral)solvedExpression;
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)pfl.getFunction_ProbabilityFunctionLiteral();

		double solvedBranchProb = 1.0;
		List<Sample> points = pmf.getSamples();
		for (Sample point : points) {
			String bool = point.getValue().toString();
			if (bool.toLowerCase().equals("true")) {
				solvedBranchProb = point.getProbability();
			}
		}

		// integrate already evaluated branch conditions
		solvedBranchProb = adjustToScope(solvedBranchProb);

//		visitor.getContextWrapper().getCurrentEvaluatedBranchConditions().add(solvedBranchProb);
		return solvedBranchProb;
	}

	/**
	 * Include already evaluated branch conditions.
	 * 
	 * @param solvedBranchProb
	 * @return
	 */
	private double adjustToScope(double solvedBranchProb) {
		//TODO
//		ArrayList list = myContext.getCurrentEvaluatedBranchConditions(); 
//		for (Object o : list) solvedBranchProb /= (Double)o;
		return solvedBranchProb;
	}

}
