package de.uka.ipd.sdq.pcmbench.ui.provider;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;

public class SignaturePrinter extends RepositorySwitch<String> {


	@Override
	public String caseCollectionDataType(CollectionDataType object) {
		return this.doSwitch(object.getInnerType_CollectionDataType())+"[]";
	}

	@Override
	public String caseCompositeDataType(CompositeDataType object) {
		return object.getEntityName();
	}

	@Override
	public String casePrimitiveDataType(PrimitiveDataType object) {
		return object.getType().getLiteral().toLowerCase();
	}

	@Override
	public String caseParameter(Parameter object) {
		String result = "";
		if (object.getDatatype__Parameter() != null){
			result += this.doSwitch(object.getDatatype__Parameter());
		} else {
			result += "void";
		}
		result += " " + object.getParameterName();
		return result;
	}

	@Override
	public String caseSignature(Signature object) {
		String result = "";
		if (object.getReturntype__Signature() != null)
			result += this.doSwitch(object.getReturntype__Signature());
		else
			result += "void";
		result += " " + object.getServiceName() + "(";
		for (Parameter p : object.getParameters__Signature()) {
			result += this.doSwitch(p) + ", ";
		}
		if (object.getParameters__Signature().size() > 0)
			result = result.substring(0, result.length()-2);
		result += ")";
		return result;
	}

	
}
