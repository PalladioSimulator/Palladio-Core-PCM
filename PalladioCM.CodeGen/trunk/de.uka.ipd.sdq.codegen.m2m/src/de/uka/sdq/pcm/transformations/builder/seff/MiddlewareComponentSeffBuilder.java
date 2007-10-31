package de.uka.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class MiddlewareComponentSeffBuilder extends DelegatorComponentSeffBuilder {

	protected RequiredRole middlewareRole;

	public MiddlewareComponentSeffBuilder(
			ProvidedRole domainProvRole,
			RequiredRole domainReqRole,
			RequiredRole middlewareReqRole) {
		super(domainProvRole, domainReqRole);
		this.middlewareRole = middlewareReqRole;
	}

	public void appendPreMiddlewareCall(Signature preSignature) {
		this.appendPreAction(
				new ExternalCallActionDescriptor(
						preSignature,
						this.middlewareRole,
						createMiddlewareParameter(),
						createOutParameter()));
	}

	public void appendPostMiddlewareCall(Signature postSignature) {
		this.appendPostAction(
				new ExternalCallActionDescriptor(
						postSignature,
						this.middlewareRole,
						createMiddlewareParameter(),
						createOutParameter()));
	}

	protected Collection<VariableUsage> createMiddlewareParameter() {
		Collection<VariableUsage> result = new ArrayList<VariableUsage>();
		result.add(createVariableUsage("stream", VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE"));
		return result; 
	}
	
	protected VariableUsage createVariableUsage(String variableName, VariableCharacterisationType type, String spec) {
		VariableUsage usage = ParameterFactory.eINSTANCE.createVariableUsage();
		VariableCharacterisation characterisation = ParameterFactory.eINSTANCE.createVariableCharacterisation();
		VariableReference name = StoexFactory.eINSTANCE.createVariableReference();
		name.setReferenceName(variableName);
		characterisation.setSpecification_VariableCharacterisation(CoreFactory.eINSTANCE.createPCMRandomVariable());
		characterisation.getSpecification_VariableCharacterisation().setSpecification(spec);
		characterisation.setType(type);
		usage.setNamedReference_VariableUsage(name);
		usage.getVariableCharacterisation_VariableUsage().add(characterisation);
		
		return usage;
	}
	
	private Collection<VariableUsage> createOutParameter() {
		Collection<VariableUsage> result = new ArrayList<VariableUsage>();
		result.add(createVariableUsage("stream", VariableCharacterisationType.BYTESIZE, "RETURN.BYTESIZE"));
		return result; 
	}	
}
