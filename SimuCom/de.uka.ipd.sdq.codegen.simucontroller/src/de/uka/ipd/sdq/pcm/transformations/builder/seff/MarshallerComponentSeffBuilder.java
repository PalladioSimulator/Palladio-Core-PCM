package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature;
import de.uka.ipd.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder.MarshallerSide;
import de.uka.ipd.sdq.pcm.transformations.builder.util.NumberOfElementsComputationForSignature;

public class MarshallerComponentSeffBuilder extends MiddlewareComponentSeffBuilder {

    PrimitiveTypeEnum[] primitiveTypes = new PrimitiveTypeEnum[] {
        PrimitiveTypeEnum.INT
    };

    private OperationSignature marshallSignature;
    private OperationSignature demarshallSignature;

    public MarshallerComponentSeffBuilder(OperationProvidedRole domainProvRole, OperationRequiredRole domainReqRole,
            OperationRequiredRole middlewareReqRole, MarshallerSide side) {
        super(domainProvRole, domainReqRole, middlewareReqRole);
        this.marshallSignature = findService(middlewareRole.getRequiredInterface__OperationRequiredRole(), "marshall");
        this.demarshallSignature = findService(middlewareRole.getRequiredInterface__OperationRequiredRole(),
                "demarshall");

        switch (side) {
        case CLIENT:
            prepareClient();
            break;
        case SERVER:
            prepareServer();
            break;
        }
    }

    private void prepareClient() {

        this.appendPreAction(new SignatureDependentExternalCallActionDescriptor(marshallSignature, this.middlewareRole) {

            @Override
            protected Collection<VariableUsage> getSignatureDependentInputParameter(OperationSignature currentSignature) {
                ArrayList<VariableUsage> result = new ArrayList<VariableUsage>();
                for (PrimitiveTypeEnum type : primitiveTypes) {
                    VariableUsage usage = createInputParameterFor(currentSignature, type,
                            BytesizeComputationForSignature.Modifier.IN);
                    if (usage != null)
                        result.add(usage);
                }
                return result;
            }

            @Override
            protected Collection<VariableUsage> getSignatureDependentOutputParameter(OperationSignature currentSignature) {
                // add size of input parameters to stream
                return createMarshallOutParameter(currentSignature, Modifier.IN);
            }

        });

        this.appendPreAction(new BytesizeAddingSetVariableActionDescriptor(createVariableUsage("stream",
                VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE"), Modifier.IN));

        this.appendPostAction(new ExternalCallActionDescriptor(demarshallSignature, this.middlewareRole,
                createMiddlewareParameter()));
    }

    private void prepareServer() {
        this.appendPreAction(new ExternalCallActionDescriptor(demarshallSignature, this.middlewareRole,
                createMiddlewareParameter()));
        this.appendPostAction(new SignatureDependentExternalCallActionDescriptor(marshallSignature, this.middlewareRole) {

            @Override
            protected Collection<VariableUsage> getSignatureDependentInputParameter(OperationSignature currentSignature) {
                ArrayList<VariableUsage> result = new ArrayList<VariableUsage>();
                for (PrimitiveTypeEnum type : primitiveTypes) {
                    VariableUsage usage = createInputParameterFor(currentSignature, type,
                            BytesizeComputationForSignature.Modifier.OUT);
                    if (usage != null)
                        result.add(usage);
                }
                return result;
            }

            @Override
            protected Collection<VariableUsage> getSignatureDependentOutputParameter(OperationSignature currentSignature) {
                // add size of return parameters to stream
                return createMarshallOutParameter(currentSignature, Modifier.OUT);
            }
        });
        this.appendPostAction(new BytesizeAddingSetVariableActionDescriptor(createVariableUsage("stream",
                VariableCharacterisationType.BYTESIZE, "stream.BYTESIZE"), Modifier.OUT));
    }

    private OperationSignature findService(OperationInterface middlewareInterface, String preServiceName) {
        for (OperationSignature sig : middlewareInterface.getSignatures__OperationInterface()) {
            if (sig.getEntityName().equals(preServiceName))
                return sig;
        }
        throw new RuntimeException("Required middleware service not found in middleware interface");
    }

    /**
     * This method is responsible to determine the size of the stream that has to be sent over the
     * network after marshalling (i.e. the marshall out data).
     * 
     * @param currentSignature
     * @return
     */
    private Collection<VariableUsage> createMarshallOutParameter(OperationSignature currentSignature, Modifier modifier) {
        Collection<VariableUsage> result = new ArrayList<VariableUsage>();

        result.add(createVariableUsage("stream", VariableCharacterisationType.BYTESIZE, "RETURN.BYTESIZE"));

        return result;
    }

    /**
     * This method is responsible for creating the variable characterizations
     * ints.NUMBER_OF_ELEMENTS that appear in the simulation code of connector completions. This
     * data is input to the middleware component configured in the models, and can be used by the
     * middleware component to calculate the size of the passed stream. For example, in the default
     * Glassfish component, ints.NUMBER_OF_ELEMENTS is then transformed to a BYTESIZE
     * characterisation with 2 bytes for each int (see default glassfish model).
     * 
     * 
     * @param currentSignature
     * @param type
     * @param in
     * @return
     */
    protected VariableUsage createInputParameterFor(OperationSignature currentSignature, PrimitiveTypeEnum type,
            Modifier in) {
        String specification = NumberOfElementsComputationForSignature.countAmount(currentSignature, type, in);

        if (specification != null)
            return createVariableUsage(type.getLiteral().toLowerCase() + "s",
                    VariableCharacterisationType.NUMBER_OF_ELEMENTS, specification);
        else
            return createVariableUsage(type.getLiteral().toLowerCase() + "s",
                    VariableCharacterisationType.NUMBER_OF_ELEMENTS, "0");
    }

}
