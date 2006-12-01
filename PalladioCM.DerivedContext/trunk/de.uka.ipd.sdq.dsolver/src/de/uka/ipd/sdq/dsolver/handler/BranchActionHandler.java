/**
 * 
 */
package de.uka.ipd.sdq.dsolver.handler;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.context.usage.BranchProbability;
import de.uka.ipd.sdq.context.usage.UsageFactory;
import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.helper.ExpressionHelper;
import de.uka.ipd.sdq.dsolver.visitors.ExpressionParameterSolverVisitor;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.BranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionSolveVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParser;

/**
 * @author Koziolek
 * 
 */
public class BranchActionHandler extends AbstractHandler {

	private static Logger logger = Logger.getLogger(BranchActionHandler.class.getName());

	private UsageFactory usageFactory = UsageFactory.eINSTANCE;

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

			double solvedBranchProb = 0.0;
			if (bt.getBranchCondition_BranchTransition() != null){
				solvedBranchProb = getBranchProbFromExpression(bt, solvedBranchProb);
			} else {
				solvedBranchProb = bt.getBranchProbability();
			}
			logger.debug("SolvedBranchProb:" + solvedBranchProb);
			
			BranchProbability prob = usageFactory.createBranchProbability();
			prob.setBranchtransition_BranchProbability(bt);
			prob.setProbability(solvedBranchProb);

			myContext.getUsageContext().getBranchprobabilities_UsageContext()
					.add(prob);

			ResourceDemandingBehaviour rdb = bt
					.getBranchBehaviour_BranchTransition();
			visitor.doSwitch(rdb);
		}
	}

	/**
	 * @param bt
	 * @param solvedBranchProb
	 * @return
	 */
	private double getBranchProbFromExpression(BranchTransition bt, double solvedBranchProb) {
		String specification = bt.getBranchCondition_BranchTransition().getSpecification(); 
		Expression solvedExpression = ExpressionHelper.getSolvedExpression(specification,myContext);
		
		// TODO: integrate already evaluated branch conditions
		myContext.getCurrentEvaluatedBranchConditions().add(solvedExpression);
		
		ProbabilityFunctionLiteral pfl = (ProbabilityFunctionLiteral)solvedExpression;
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)pfl.getFunction_ProbabilityFunctionLiteral();

		List<Sample> points = pmf.getSamples();
		for (Sample point : points) {
			String bool = (String) point.getValue();
			if (bool.toLowerCase().equals("true")) {
				solvedBranchProb = point.getProbability();
				
			}
		}
		return solvedBranchProb;
	}
}
