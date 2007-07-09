/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.printhandler;

import de.uka.ipd.sdq.spa.basicsolver.visitor.LoopHandler;
import de.uka.ipd.sdq.spa.expression.Loop;


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
