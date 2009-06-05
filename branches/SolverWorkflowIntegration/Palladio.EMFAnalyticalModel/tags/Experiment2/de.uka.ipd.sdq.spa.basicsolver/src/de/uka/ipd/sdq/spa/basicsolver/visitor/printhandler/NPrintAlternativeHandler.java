/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.printhandler;

import de.uka.ipd.sdq.spa.basicsolver.visitor.AlternativeHandler;
import de.uka.ipd.sdq.spa.expression.Alternative;


/**
 * @author Ihssane
 *
 */
public class NPrintAlternativeHandler implements AlternativeHandler{

	public void handle(Alternative alt) {
//		alt.setResult("(" + alt.getLeftRegExp().getResult()+ alt
//				.getRightRegExp().getResult()
//				+ ")");
		System.out.print("|");
	}

}
