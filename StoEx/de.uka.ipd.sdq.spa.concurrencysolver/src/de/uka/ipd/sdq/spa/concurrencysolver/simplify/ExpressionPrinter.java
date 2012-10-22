package de.uka.ipd.sdq.spa.concurrencysolver.simplify;

import de.uka.ipd.sdq.spa.expression.Acquire;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Parallel;
import de.uka.ipd.sdq.spa.expression.Release;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;

public class ExpressionPrinter {
	

	private ExpressionSwitch exprswitch = new ExpressionSwitch() {

		@Override
		public Object caseAcquire(Acquire object) {
			return "ac(" + object.getResource().getName() + ")";
		}

		@Override
		public Object caseAlternative(Alternative object) {
			return "("+doSwitch(object.getLeftOption().getRegexp()) + " + " + doSwitch(object.getRightOption().getRegexp()) +")";
		}

		@Override
		public Object caseLoop(Loop object) {
			return "(" + doSwitch(object.getRegExp()) + ")*";
		}

		@Override
		public Object caseParallel(Parallel object) {
			return "(" + doSwitch(object.getLeftTask()) + "||" + doSwitch(object.getRightTask()) + ")";
		}

		@Override
		public Object caseRelease(Release object) {
			return "rel(" + object.getResource().getName() + ")";
		}

		@Override
		public Object caseSequence(Sequence object) {
			return doSwitch(object.getLeftRegExp()) + ";" + doSwitch(object.getRightRegExp());
		}

		@Override
		public Object caseSymbol(Symbol object) {
			return object.getName();
		}
	};

	public ExpressionPrinter() {
		super();
	}

	public String toString(Expression expr) {
		return (String) exprswitch.doSwitch(expr);
	}

	

}
