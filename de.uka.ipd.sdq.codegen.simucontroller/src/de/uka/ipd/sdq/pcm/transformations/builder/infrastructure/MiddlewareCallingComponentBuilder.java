package de.uka.ipd.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.MiddlewareComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.SetVariableActionDescriptor;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.VariableReference;

public class MiddlewareCallingComponentBuilder extends
		BasicMiddlewareComponentBuilder {

	private OperationSignature preSignature;
	private OperationSignature postSignature;
	
	public MiddlewareCallingComponentBuilder(
			PCMAndCompletionModelHolder models, 
			OperationInterface providedIf,
			OperationInterface requiredIf, 
			OperationInterface middlewareInterface,
			ResourceContainer container,
			String preServiceName,
			String postServiceName) {
		super(models, providedIf, requiredIf, middlewareInterface, container);
		this.preSignature = preServiceName == null ? null : findService(middlewareInterface,preServiceName);
		this.postSignature = postServiceName == null ? null : findService(middlewareInterface,postServiceName);
	}

	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		MiddlewareComponentSeffBuilder builder = (MiddlewareComponentSeffBuilder) super.getSeffBuilder();
		if (preSignature != null)
			builder.appendPreMiddlewareCall(
				preSignature);
		if (postSignature != null)
			builder.appendPostMiddlewareCall(
				postSignature);
		builder.appendPostAction(new SetVariableActionDescriptor(
				createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE")));

		return builder;
	}

	private OperationSignature findService(OperationInterface middlewareInterface,
			String preServiceName) {
		for (OperationSignature sig : middlewareInterface.getSignatures__OperationInterface()){
			if (sig.getEntityName().equals(preServiceName))
				return sig;
		}
		throw new RuntimeException("Required middleware service not found in middleware interface");
	}

	protected VariableSetter createVariableSetter(Variable variableDef, String variableName, VariableCharacterisationType type, String spec) {
		VariableSetter usage = ParameterFactory.eINSTANCE.createVariableSetter();
		
		VariableReference name = StoexFactory.eINSTANCE.createVariableReference();
		name.setReferenceName(variableName);
		
		VariableCharacteristic characterisation = ParameterFactory.eINSTANCE.createVariableCharacteristic();
		characterisation.setCharacterisationDefinition__VariableCharacteristic(type);
		characterisation.setId_Variable(name);
		
		//FIXME: Create a Variable instance first!
		characterisation.setVariable__VariableCharacteristic(variableDef);

		usage.setSpecification__VariableSetter(CoreFactory.eINSTANCE.createPCMRandomVariable());
		usage.getSpecification__VariableSetter().setSpecification(spec);
		
		
		
		usage.setVariableCharacteristic__VariableSetter(characterisation);
		//usage.setNamedReference_VariableSetter(name);
		//usage.getVariableCharacterisation__SetVariable().add(characterisation);
		
		return usage;
	}	
}
