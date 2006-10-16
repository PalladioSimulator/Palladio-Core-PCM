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
import de.uka.ipd.sdq.dsolver.visitors.SeffSwitchDSolver;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
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

	private SeffSwitchDSolver visitor;

	private Context myContext;

	/**
	 * @param context
	 * @param _visitor
	 * @param nextHandler
	 */
	public BranchActionHandler(Context context, SeffSwitchDSolver _visitor,
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

			BranchProbability prob = usageFactory.createBranchProbability();
			String branchCondition = bt.getBranchCondition();
			// TODO: store scope of branch conditions
			myContext.getCurrentEvaluatedBranchConditions()
					.add(branchCondition);

//			CompareExpression exp = parseBranchCondition(branchCondition);

			
//			CompareOperations op = exp.getOperation();
//			if (op.getValue() == CompareOperations.LESS) {
//				int foo = 0;
//				double bar = 0.0;
//				if (exp.getLeft() instanceof IntLiteral) {
//					foo = ((IntLiteral) exp.getLeft()).getValue();
//				}
//				if (exp.getRight() instanceof DoubleLiteral) {
//					bar = ((DoubleLiteral) exp.getRight()).getValue();
//				}
//				if (foo < bar) {
//					prob.setProbability(1.0);
//				} else {
//					prob.setProbability(0.0);
//				}
//			}

			// TODO: solve dependency
			prob.setBranchtransition_BranchProbability(bt);
			prob.setProbability(0.5);

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
