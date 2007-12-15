package de.uka.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.sdq.pcm.transformations.BytesizeComputationForSignature;
import de.uka.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;
import de.uka.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder.MarshallerSide;
import de.uka.sdq.pcm.transformations.builder.util.NumberOfElementsComputationForSignature;

public class MarshallerComponentSeffBuilder extends
		MiddlewareComponentSeffBuilder {

	PrimitiveTypeEnum[] primitiveTypes = new PrimitiveTypeEnum[]{PrimitiveTypeEnum.INT};

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
				new SignatureDependentExternalCallActionDescriptor(
						marshallSignature,
						this.middlewareRole){

							@Override
							protected Collection<VariableUsage> getSignatureDependentInputParameter(
									Signature currentSignature) {
								ArrayList<VariableUsage> result = new ArrayList<VariableUsage>();
								for (PrimitiveTypeEnum type : primitiveTypes){
									VariableUsage usage = createInputParameterFor(currentSignature, type, BytesizeComputationForSignature.Modifier.IN);
									if (usage != null)
										result.add(usage);
								}
								return result;
							}

							@Override
							protected Collection<VariableUsage> getSignatureDependentOutputParameter(
									Signature currentSignature) {
								return createMarshallOutParameter();
							}
			
		});
		this.appendPostAction(
				new ExternalCallActionDescriptor(
						demarshallSignature,
						this.middlewareRole,
						createMiddlewareParameter()));
	}

	private void prepareServer() {
		this.appendPreAction(
				new ExternalCallActionDescriptor(
						demarshallSignature,
						this.middlewareRole,
						createMiddlewareParameter()));
		this.appendPostAction(
				new SignatureDependentExternalCallActionDescriptor(
						marshallSignature,
						this.middlewareRole){

							@Override
							protected Collection<VariableUsage> getSignatureDependentInputParameter(
									Signature currentSignature) {
								ArrayList<VariableUsage> result = new ArrayList<VariableUsage>();
								for (PrimitiveTypeEnum type : primitiveTypes) {
									VariableUsage usage = createInputParameterFor(currentSignature, type, BytesizeComputationForSignature.Modifier.OUT);
									if (usage != null)
										result.add(usage);
								}
								return result;
							}

							@Override
							protected Collection<VariableUsage> getSignatureDependentOutputParameter(
									Signature currentSignature) {
								return createMarshallOutParameter();
							}
			
		});
		this.appendPostAction(new SetVariableActionDescriptor(
				createVariableUsage("stream", VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE")));
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

	protected VariableUsage createInputParameterFor(Signature currentSignature,
			PrimitiveTypeEnum type, Modifier in) {
		String specification = NumberOfElementsComputationForSignature.countAmount(currentSignature,type,in);
		if (specification != null)
			return createVariableUsage(type.getLiteral().toLowerCase()+"s", VariableCharacterisationType.NUMBER_OF_ELEMENTS, 
				specification);
		else
			return createVariableUsage(type.getLiteral().toLowerCase()+"s", VariableCharacterisationType.NUMBER_OF_ELEMENTS, 
					"0");
	}

	
}
