package de.uka.ipd.sdq.pcmbench.ui.provider;

import org.palladiosimulator.pcm.repository.CollectionDataType;
import org.palladiosimulator.pcm.repository.CompositeDataType;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.PrimitiveDataType;
import org.palladiosimulator.pcm.repository.util.RepositorySwitch;

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
		if (object.getDataType__Parameter() != null){
			result += this.doSwitch(object.getDataType__Parameter());
		} else {
			result += "void";
		}
		result += " " + object.getParameterName();
		return result;
	}

	@Override
	public String caseOperationSignature(OperationSignature object) {
		String result = "";
		if (object.getReturnType__OperationSignature() != null)
			result += this.doSwitch(object.getReturnType__OperationSignature());
		else
			result += "void";
		result += " " + object.getEntityName() + "(";
		for (Parameter p : object.getParameters__OperationSignature()) {
			result += this.doSwitch(p) + ", ";
		}
		if (object.getParameters__OperationSignature().size() > 0)
			result = result.substring(0, result.length()-2);
		result += ")";
		return result;
	}
	
	@Override
	public String caseInfrastructureSignature(InfrastructureSignature object) {
		String result = "";
		result += object.getEntityName() + "(";
		for (Parameter p : object.getParameters__InfrastructureSignature()) {
			result += this.doSwitch(p) + ", ";
		}
		if (object.getParameters__InfrastructureSignature().size() > 0)
			result = result.substring(0, result.length()-2);
		result += ")";
		return result;
	}	
}
