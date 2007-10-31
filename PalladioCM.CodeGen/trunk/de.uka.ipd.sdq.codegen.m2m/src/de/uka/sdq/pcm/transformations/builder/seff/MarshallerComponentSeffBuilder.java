package de.uka.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder.MarshallerSide;

public class MarshallerComponentSeffBuilder extends
		MiddlewareComponentSeffBuilder {

	private Signature marshallSignature;
	private Signature demarshallSignature;

	public MarshallerComponentSeffBuilder(ProvidedRole domainProvRole,
			RequiredRole domainReqRole, RequiredRole middlewareReqRole, MarshallerSide side) {
		super(domainProvRole, domainReqRole, middlewareReqRole);
		this.marshallSignature = findService(middlewareRole.getRequiredInterface__RequiredRole(), "marshall");
		this.demarshallSignature = findService(middlewareRole.getRequiredInterface__RequiredRole(), "demarshall");
		switch(side) {
		case CLIENT:
			prepareClient();
			break;
		case SERVER:
			prepareServer();
			break;
		}
	}
	
	private void prepareClient() {
		this.appendPreAction(
				new ExternalCallActionDescriptor(
						marshallSignature,
						this.middlewareRole,
						Collections.EMPTY_LIST,
						createMarshallOutParameter()));
		this.appendPostAction(
				new ExternalCallActionDescriptor(
						demarshallSignature,
						this.middlewareRole,
						Collections.EMPTY_LIST));
	}

	private void prepareServer() {
		this.appendPreAction(
				new ExternalCallActionDescriptor(
						demarshallSignature,
						this.middlewareRole,
						Collections.EMPTY_LIST));
		this.appendPostAction(
				new ExternalCallActionDescriptor(
						marshallSignature,
						this.middlewareRole,
						Collections.EMPTY_LIST,
						createMarshallOutParameter()));
	}

	private Signature findService(Interface middlewareInterface,
			String preServiceName) {
		for (Signature sig : middlewareInterface.getSignatures__Interface()){
			if (sig.getServiceName().equals(preServiceName))
				return sig;
		}
		throw new RuntimeException("Required middleware service not found in middleware interface");
	}	

	private Collection<VariableUsage> createMarshallOutParameter() {
		Collection<VariableUsage> result = new ArrayList<VariableUsage>();
		result.add(createVariableUsage("stream", VariableCharacterisationType.BYTESIZE, "RETURN.BYTESIZE"));
		return result; 
	}
		
}
