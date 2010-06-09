package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder.MarshallerSide;
import de.uka.ipd.sdq.pcm.transformations.builder.util.NumberOfElementsComputationForSignature;

public class MarshallerComponentSeffBuilder extends
		MiddlewareComponentSeffBuilder {

	/*TODO: Formerly, the PrimitiveTypeEnum.INT has been in this set. 
	 * Find a suitable replacement from the Palladio datatype repository, 
	 * possibly by doing a String comparison. As of now, no primitive type 
	 * is considered in this transformation.  
	 */
	PrimitiveDataType[] primitiveTypes = new PrimitiveDataType[]{};

	private OperationSignature marshallSignature;
	private OperationSignature demarshallSignature;

	public MarshallerComponentSeffBuilder(OperationProvidedRole domainProvRole,
			OperationRequiredRole domainReqRole, OperationRequiredRole middlewareReqRole, MarshallerSide side) {
		super(domainProvRole, domainReqRole, middlewareReqRole);
		this.marshallSignature = findService(middlewareRole.getRequiredInterface__OperationRequiredRole(), "marshall");
		this.demarshallSignature = findService(middlewareRole.getRequiredInterface__OperationRequiredRole(), "demarshall");
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
							protected Collection<VariableSetter> getSignatureDependentInputParameter(
									OperationSignature currentSignature) {
								ArrayList<VariableSetter> result = new ArrayList<VariableSetter>();
								for (PrimitiveDataType type : primitiveTypes){
									VariableSetter usage = createInputParameterFor(currentSignature, type, BytesizeComputationForSignature.Modifier.IN);
									if (usage != null)
										result.add(usage);
								}
								
//								// add bytesize characterisations
//								String bytesizeSpecification = BytesizeComputationForSignature.getBytesizeForSignature(currentSignature, BytesizeComputationForSignature.Modifier.IN);
//								if (bytesizeSpecification != null && bytesizeSpecification.length() > 0){
//									VariableSetter usage = createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, bytesizeSpecification+" + stream.BYTESIZE");
//									if (usage != null)
//										result.add(usage);
//								}
//								System.out.println("added bytesize.");
								
								return result;
							}

							@Override
							protected Collection<VariableSetter> getSignatureDependentOutputParameter(
									OperationSignature currentSignature) {
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
							protected Collection<VariableSetter> getSignatureDependentInputParameter(
									OperationSignature currentSignature) {
								ArrayList<VariableSetter> result = new ArrayList<VariableSetter>();
								for (PrimitiveDataType type : primitiveTypes) {
									VariableSetter usage = createInputParameterFor(currentSignature, type, BytesizeComputationForSignature.Modifier.OUT);
									if (usage != null)
										result.add(usage);
								}
								return result;
							}

							@Override
							protected Collection<VariableSetter> getSignatureDependentOutputParameter(
									OperationSignature currentSignature) {
								return createMarshallOutParameter();
							}
			
		});
		this.appendPostAction(new SetVariableActionDescriptor(
				createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE")));
	}

	private OperationSignature findService(OperationInterface middlewareInterface,
			String preServiceName) {
		for (OperationSignature sig : middlewareInterface.getSignatures__OperationInterface()){
			if (sig.getEntityName().equals(preServiceName))
				return sig;
		}
		throw new RuntimeException("Required middleware service not found in middleware interface");
	}	

	private Collection<VariableSetter> createMarshallOutParameter() {
		Collection<VariableSetter> result = new ArrayList<VariableSetter>();
		result.add(createVariableSetter("stream", VariableCharacterisationType.BYTESIZE, "RETURN.BYTESIZE"));
		return result; 
	}

	/**
	 * This method is responsible for creating the variable characterizations ints.NUMBER_OF_ELEMENTS that appear in the simulation code of connector completions. 
	 * TODO: document me properly
	 * 
	 * @param currentSignature
	 * @param type
	 * @param in
	 * @return
	 */
	protected VariableSetter createInputParameterFor(OperationSignature currentSignature,
			PrimitiveDataType type, Modifier in) {
		String specification = NumberOfElementsComputationForSignature.countAmount(currentSignature,type,in);
		if (specification != null)
			return createVariableSetter(type.getEntityName().toLowerCase()+"s", VariableCharacterisationType.NUMBER_OF_ELEMENTS, 
				specification);
		else
			return createVariableSetter(type.getEntityName().toLowerCase()+"s", VariableCharacterisationType.NUMBER_OF_ELEMENTS, 
					"0");
	}
	
}
