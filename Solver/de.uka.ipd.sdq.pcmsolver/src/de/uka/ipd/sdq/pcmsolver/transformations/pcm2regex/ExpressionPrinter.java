package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Loop;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.expression.util.ExpressionSwitch;

public class ExpressionPrinter extends ExpressionSwitch{
	
	private static String newline = System.getProperty("line.separator");
	
	private StringBuilder outputStr = new StringBuilder();
	
	public ExpressionPrinter(){
	}
	
	public String getOutput(){
		return outputStr.toString();
	}
	
	@Override
	public Object caseAlternative(Alternative object) {
		//System.out.print("(");
		outputStr.append("(");
		doSwitch(object.getLeftOption().getRegexp());
		outputStr.append("|");
		doSwitch(object.getRightOption().getRegexp());
		outputStr.append(")");
		return object;

	}

	@Override
	public Object caseLoop(Loop object) {
		outputStr.append("(");
		doSwitch(object.getRegExp());
		outputStr.append(")*");
		return object;
	}

	@Override
	public Object caseSequence(Sequence object) {
		doSwitch(object.getLeftRegExp());
		outputStr.append("");
		doSwitch(object.getRightRegExp());
		return object;
	}

	@Override
	public Object doSwitch(EObject theEObject) {
		if (theEObject == null){
			outputStr.append("!null!");
			return null;
		} else {
			return super.doSwitch(theEObject);
		}
	}

	@Override
	public Object caseSymbol(Symbol object) {
//		outputStr.append("0");
		
		if (object.getName() == null || object.getName().equals("")){
			//System.out.print("0");
			outputStr.append("0");
		} else {
			//System.out.print(object.getName());
			outputStr.append(object.getName());
		}
		return object;
	}

	
	
}
