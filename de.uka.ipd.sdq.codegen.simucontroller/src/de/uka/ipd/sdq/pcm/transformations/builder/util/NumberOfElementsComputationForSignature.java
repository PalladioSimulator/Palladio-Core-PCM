package de.uka.ipd.sdq.pcm.transformations.builder.util;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;

public class NumberOfElementsComputationForSignature {

	public static String countAmount(
			OperationSignature currentSignature,
			PrimitiveDataType type, 
			Modifier modifier) {
		
		String result = null;
		if (modifier == Modifier.IN){
			for (Variable p : currentSignature.getParameters__OperationSignature()) {
				String stoex = countForParameter(p, type);
				result = appendStoEx(result, stoex);
			}
		}
		if (modifier == Modifier.OUT){
			if (currentSignature.getReturntype__OperationSignature() != null && modifier == Modifier.OUT){
				TypesCountingVisitor visitor = new TypesCountingVisitor("RETURN",type);
				String stoex = visitor.doSwitch(currentSignature.getReturntype__OperationSignature().getDataType__Variable());
				result = appendStoEx(result, stoex);
			}
		}
		return result;
	}

	private static String appendStoEx(String result, String stoex) {
		if (stoex != null){
			if (result == null) {
				result = stoex;
			} else {
				result += " + (" + stoex + ")";
			}
		}
		return result;
	}
	
	/*private static boolean matchesModifier(Variable p, Modifier modifier) {
		ParameterModifier parMod = p.getModifier__Parameter();
		switch(modifier){
		case IN:
			if (parMod == ParameterModifier.IN || 
					parMod == ParameterModifier.INOUT || 
					parMod == ParameterModifier.NONE)
				return true;
			break;
		case OUT:
			if (parMod == ParameterModifier.INOUT || 
					parMod == ParameterModifier.OUT)
				return true;
			break;
		}
		return false;
	}*/

	private static String countForParameter(Variable p, PrimitiveDataType type) {
		TypesCountingVisitor visitor = new TypesCountingVisitor(p,type);
		return visitor.doSwitch(p.getDataType__Variable());
	}

}
