package de.uka.ipd.sdq.stoex.analyser.visitors;

import org.palladiosimulator.commons.stoex.adapter.StoExSerializer;

import de.uka.ipd.sdq.stoex.Expression;

class TypeInferenceFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3349723314768810885L;

	public TypeInferenceFailedException(Expression expr) {
		super(new StoExSerializer().prettyPrint(expr)+" - Inference of Type failed");
	}
	
	public TypeInferenceFailedException(Expression expr, String msg){
		super(new StoExSerializer().prettyPrint(expr)+" - Inference of Type failed: "+msg);
	}

}
