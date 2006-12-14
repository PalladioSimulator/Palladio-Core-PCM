package de.uka.ipd.sdq.dsolver.pcm2regex;

import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;

public class ExpressionPrinter extends ExpressionSwitch{

	public ExpressionPrinter(){
		System.out.println();
	}
	
	@Override
	public Object caseAlternative(Alternative object) {
		System.out.print("(");
		doSwitch(object.getLeftOption().getRegexp());
		System.out.print("|");
		doSwitch(object.getRightOption().getRegexp());
		System.out.print(")");
		return object;

	}

	@Override
	public Object caseLoop(Loop object) {
		System.out.print("(");
		doSwitch(object.getRegExp());
		System.out.print(")*");
		return object;
	}

	@Override
	public Object caseSequence(Sequence object) {
		doSwitch(object.getLeftRegExp());
		System.out.print("");
		doSwitch(object.getRightRegExp());
		return object;
	}

	@Override
	public Object caseSymbol(Symbol object) {
		System.out.print("0");
		
//		if (object.getName() == null || object.getName().equals("")){
//			System.out.print("0");
//		} else {
//			System.out.print(object.getName());
//		}
		return object;
	}

	
	
}
