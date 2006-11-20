/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.io.StringBufferInputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.context.usage.BranchProbability;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;

/**
 * @author Koziolek
 * 
 */
public class BranchActionHandler extends AbstractHandler {

	private static Logger logger = Logger.getLogger(BranchActionHandler.class.getName());

	private UsageFactory usageFactory;

	private SeffVisitor visitor;

	private Context myContext;

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public BranchActionHandler(Context context, SeffVisitor _visitor,
			AbstractHandler nextHandler) {
		myContext = context;
		visitor = _visitor;
		successor = nextHandler;
		usageFactory = UsageFactory.eINSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.dsolver.handler.AbstractHandler#handle(org.eclipse.emf.ecore.EObject)
	 */
	public void handle(EObject object) {
		if (object instanceof BranchAction) {
			handle((BranchAction) object);
		} else {
			if (successor != null)
				successor.handle(object);
		}
	}

	/**
	 * @param branch
	 */
	private void handle(BranchAction branch) {
		EList btList = branch.getBranches_Branch();
		for (Iterator i = btList.iterator(); i.hasNext();) {
			BranchTransition bt = (BranchTransition) i.next();

//			String branchCondition = bt.getBranchCondition();
//			bt.getBranchCondition_BranchTransition().g
//			// TODO: store scope of branch conditions
//			myContext.getCurrentEvaluatedBranchConditions()
//					.add(branchCondition);
//
//			CompareExpression compExpr = parseBranchCondition(branchCondition);
//			
			
			Expression compExpr = bt.getBranchCondition_BranchTransition().getSpecification_RandomVariable();
			ExpressionSolveVisitor branchConditionVisitor = new ExpressionSolveVisitor(
					compExpr,myContext);
			Double solvedBranchProb = (Double) branchConditionVisitor
					.doSwitch(compExpr);
logger.debug("SolvedBranchProb:"+solvedBranchProb);
			BranchProbability prob = usageFactory.createBranchProbability();
			prob.setBranchtransition_BranchProbability(bt);
			prob.setProbability(solvedBranchProb.doubleValue());

			myContext.getUsageContext().getBranchprobabilities_UsageContext()
					.add(prob);

			ResourceDemandingBehaviour rdb = bt
					.getBranchBehaviour_BranchTransition();
			visitor.doSwitch(rdb);
		}
	}

	/**
	 * @param branchCondition
	 * @return
	 */
	private CompareExpression parseBranchCondition(String branchCondition) {
		EObject value = null;

		try {
			StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
					new StringBufferInputStream(branchCondition));
			StochasticExpressionsParser parser = new StochasticExpressionsParser(
					lexer);
			value = parser.expression();
		} catch (RecognitionException e) {
			logger.error("ParserError: " + e.getMessage());
			return null;
		} catch (TokenStreamException e) {
			logger.error("ParserError: " + e.getMessage());
			return null;
		}
		return (CompareExpression) value;
	}
}
