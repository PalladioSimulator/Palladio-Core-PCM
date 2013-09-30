package de.uka.ipd.sdq.pcm.transformations.builder.util;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;

public class NumberOfElementsComputationForSignature {

	public static String countAmount(
			OperationSignature currentSignature,
			PrimitiveTypeEnum type, 
			Modifier modifier) {
		
		String result = null;
		for (Parameter p : currentSignature.getParameters__OperationSignature()) {
			if (matchesModifier(p,modifier)){
				String stoex = countForParameter(p, type);
				result = appendStoEx(result, stoex);
			}
		}
		if (currentSignature.getReturnType__OperationSignature() != null && modifier == Modifier.OUT){
			TypesCountingVisitor visitor = new TypesCountingVisitor("RETURN",type);
			String stoex = visitor.doSwitch(currentSignature.getReturnType__OperationSignature());
			result = appendStoEx(result, stoex);
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
	
	private static boolean matchesModifier(Parameter p, Modifier modifier) {
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
	}

	private static String countForParameter(Parameter p, PrimitiveTypeEnum type) {
		TypesCountingVisitor visitor = new TypesCountingVisitor(p,type);
		return visitor.doSwitch(p.getDataType__Parameter());
	}

}
