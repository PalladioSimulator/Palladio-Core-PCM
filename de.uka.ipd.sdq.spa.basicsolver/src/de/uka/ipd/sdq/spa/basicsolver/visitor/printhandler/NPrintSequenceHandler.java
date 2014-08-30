/**
 * 
 */
package de.uka.ipd.sdq.spa.basicsolver.visitor.printhandler;

import de.uka.ipd.sdq.spa.basicsolver.visitor.SequenceHandler;
import de.uka.ipd.sdq.spa.expression.Sequence;


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
