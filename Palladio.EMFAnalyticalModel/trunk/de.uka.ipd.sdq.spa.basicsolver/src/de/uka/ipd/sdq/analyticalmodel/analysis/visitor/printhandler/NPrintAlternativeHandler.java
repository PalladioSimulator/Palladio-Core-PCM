/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.printhandler;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.AlternativeHandler;
import de.uka.ipd.sdq.model.analysis.expression.Alternative;


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
