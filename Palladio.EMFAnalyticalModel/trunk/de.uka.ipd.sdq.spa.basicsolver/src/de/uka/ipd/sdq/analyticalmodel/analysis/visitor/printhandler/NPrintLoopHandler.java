/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.printhandler;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.LoopHandler;
import de.uka.ipd.sdq.model.analysis.expression.Loop;


/**
 * @author Ihssane
 *
 */
public class NPrintLoopHandler implements LoopHandler{

	public void handle(Loop loop) {
//		loop.setResult("(" + loop.getRegExp().getResult() + ")*");
		System.out.print("*");
	}

}
