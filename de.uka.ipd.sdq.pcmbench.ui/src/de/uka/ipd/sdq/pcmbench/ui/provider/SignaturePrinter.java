package de.uka.ipd.sdq.pcmbench.ui.provider;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;

public class SignaturePrinter extends RepositorySwitch<String> {


	@Override
	public String caseCollectionDataType(CollectionDataType object) {
		return this.doSwitch(object.getInnerDataType__CollectionDataType())+"[]";
	}

	@Override
	public String caseCompositeDataType(CompositeDataType object) {
		return object.getEntityName();
	}

	@Override
	public String casePrimitiveDataType(PrimitiveDataType object) {
		//return object.getType().getLiteral().toLowerCase();
		return object.getEntityName();
	}

//	@Override cas
//	public String caseOperationSignature(OperationSignature object) {
//		String result = "";
//		if (object.getReturntype__OperationSignature() != null){
//			result += this.doSwitch(object.getReturntype__OperationSignature());
//		} else {
//			result += "void";
//		}
//		result += " " + object.getEntityName();
//		return result;
//		if (object.getgetDatatype__Parameter() != null){
//			result += this.doSwitch(object.getDatatype__Parameter());
//		} else {
//			result += "void";
//		}
//		result += " " + object.getParameterName();
//		return result;
//	}

	@Override 
	public String caseOperationSignature(OperationSignature object) {
		
		String result = "";
		if (object.getReturntype__OperationSignature() != null)
			result += this.doSwitch(object.getReturntype__OperationSignature());
		else
			result += "void";
		result += " " + object.getEntityName() + "(";
		for (Variable p : object.getParameters__OperationSignature()) {
			result += this.doSwitch(p) + ", ";
		}
		if (object.getParameters__OperationSignature().size() > 0)
			result = result.substring(0, result.length()-2);
		result += ")";
		return result;
	}

	
}
