package de.uka.ipd.sdq.stoex.analyser.visitors;

import de.uka.ipd.sdq.stoex.Expression;

public class TypeInferenceFailedException extends RuntimeException {

	public TypeInferenceFailedException(Expression expr) {
		super(new StoExPrettyPrintVisitor().prettyPrint(expr)+" - Inference of Type failed");
	}

}
