package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class MiddlewareComponentSeffBuilder extends DelegatorComponentSeffBuilder {

	protected OperationRequiredRole middlewareRole;

	public MiddlewareComponentSeffBuilder(
			OperationProvidedRole domainProvRole,
			OperationRequiredRole domainReqRole,
			OperationRequiredRole middlewareReqRole) {
		super(domainProvRole, domainReqRole);
		this.middlewareRole = middlewareReqRole;
	}

	public void appendPreMiddlewareCall(OperationSignature preSignature) {
		this.appendPreAction(
				new ExternalCallActionDescriptor(
						preSignature,
						this.middlewareRole,
						createMiddlewareParameter(),
						createOutParameter()));
	}

	public void appendPostMiddlewareCall(OperationSignature postSignature) {
		this.appendPostAction(
				new ExternalCallActionDescriptor(
						postSignature,
						this.middlewareRole,
						createMiddlewareParameter(),
						createOutParameter()));
	}

	protected Collection<VariableSetter> createMiddlewareParameter() {
		Collection<VariableSetter> result = new ArrayList<VariableSetter>();
		result.add(createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE"));
		return result; 
	}
	
	protected VariableSetter createVariableSetter(Variable variableDef, String variableName, VariableCharacterisationType type, String spec) {
		VariableSetter usage = ParameterFactory.eINSTANCE.createVariableSetter();
		//VariableCharacterisation characterisation = ParameterFactory.eINSTANCE.createVariableCharacterisation();
		VariableReference name = StoexFactory.eINSTANCE.createVariableReference();
		name.setReferenceName(variableName);
		usage.setSpecification__VariableSetter(CoreFactory.eINSTANCE.createPCMRandomVariable());
		usage.getSpecification__VariableSetter().setSpecification(spec);
		
		//FIXME: this needs to be contained in a Variable!! 		
		VariableCharacteristic charVar = ParameterFactory.eINSTANCE.createVariableCharacteristic();
		charVar.setId_Variable(name);
		charVar.setVariable__VariableCharacteristic(variableDef);
		
		charVar.setCharacterisationDefinition__VariableCharacteristic(type);
		
		usage.setVariableCharacteristic__VariableSetter(charVar);
		//usage.getVariableCharacterisation__SetVariable().add(characterisation);
		
		return usage;
	}
	
	private Collection<VariableSetter> createOutParameter() {
		Collection<VariableSetter> result = new ArrayList<VariableSetter>();
		result.add(createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, "RETURN.BYTESIZE"));
		return result; 
	}	
}
