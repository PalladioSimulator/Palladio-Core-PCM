package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Parallel;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;

public class SimplificationVisitor {

	List<Expression> expressionList;

	Expression currentExpression;

	private Resource currentResource;

	ExpressionFactory eFactory = ExpressionFactory.eINSTANCE;

	private ExpressionSwitch exprswitch = new ExpressionSwitch() {

		@Override
		public Object caseAcquire(Acquire object) {
			addCurrentExpressionToList();
			expressionList.add(object);
			return object;
		}

		@Override
		public Object caseAlternative(Alternative object) {
			addNode(object);
			return object;
		}

		@Override
		public Object caseLoop(Loop object) {
			addNode(object);
			return object;
		}

		@Override
		public Object caseParallel(Parallel object) {
			addNode(object);
			return object;
		}

		@Override
		public Object caseRelease(Release object) {
			addCurrentExpressionToList();
			expressionList.add(object);
			return object;
		}

		@Override
		public Object caseSequence(Sequence object) {
			doSwitch(object.getLeftRegExp());
			doSwitch(object.getRightRegExp());
			return object;
		}

		@Override
		public Object caseSymbol(Symbol object) {
			if (sameResource(object)) {
				addNode(object);
			} else {
				addCurrentExpressionToList();
				expressionList.add(object);
			}
			return object;
		}

	};

	public SimplificationVisitor() {
		super();
		this.currentExpression = null;
		this.expressionList = new ArrayList<Expression>();
	}

	protected boolean sameResource(Symbol symbol) {
		//TODO kommt mehrfach vor!! vergleich aller Resourcen!
		ResourceUsage resourceUsage = (ResourceUsage) symbol.getResourceUsages().get(0);
		boolean result = true;;
		if (currentResource != null) {
			if (!resourceUsage.getResource().equals(currentResource)){
				result = false;
			}
		} else {
			currentResource = resourceUsage.getResource();
		}
		return result;
	}

	public void visit(Expression expr) {
		exprswitch.doSwitch(expr);
	}

	private void addCurrentExpressionToList() {
		if (currentExpression != null) {
			expressionList.add(currentExpression);
			currentExpression = null;
			currentResource = null;
		}
	}

	private void addNode(Expression expr) {
		if (currentExpression == null) {
			currentExpression = expr;
		} else {
			Sequence result = eFactory.createSequence();
			result.setLeftRegExp(currentExpression);
			result.setRightRegExp(expr);
			currentExpression = result;
		}
	}

	public List<Expression> getResultList() {
		return expressionList;
	}

}
