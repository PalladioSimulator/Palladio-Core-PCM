/**
 * 
 */
package de.uka.ipd.sdq.analyticalmodel.analysis.visitor.printhandler;

import de.uka.ipd.sdq.analyticalmodel.analysis.visitor.SequenceHandler;
import de.uka.ipd.sdq.model.analysis.expression.Sequence;


/**
 * @author Ihssane
 *
 */
public class NPrintSequenceHandler implements SequenceHandler{

	public void handle(Sequence seq) {
//		seq.setResult(seq.getLeftRegExp().getResult()+ seq
//				.getRightRegExp().getResult());
		System.out.print(".");
	}

}
