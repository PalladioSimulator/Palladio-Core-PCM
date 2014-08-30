package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * An edit helper advice.
 */
public class AddCommunicationLinkResourceSpecificationEditHelperAdvice extends AbstractEditHelperAdvice implements
        IEditHelperAdvice {

    /**
     * A resource communication link resource specification.
     */
    private static final String RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION = "de.uka.ipd.sdq.pcm.gmf.resource.CommunicationLinkResourceSpecification_3004";

    @Override
    public ICommand getBeforeConfigureCommand(ConfigureRequest request) {
        IElementType elementType = ElementTypeRegistry.getInstance().getType(
                RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION);

        CreateElementRequest createElementRequest = new CreateElementRequest(request.getElementToConfigure(),
                elementType);
        createElementRequest.setContainmentFeature(ResourceenvironmentPackage.eINSTANCE
                .getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource());
        CreateElementCommand createElementCommand = new CreateElementCommand(createElementRequest);

        // edited object should be a single element
        if (request.getElementsToEdit().size() != 1) {
            throw new RuntimeException("Did not expect more than one element in request.");
        }

        CompositeCommand compositeCommand = new CompositeCommand("");
        compositeCommand.add(createElementCommand);
        compositeCommand.add(new SetLatencyThroughputAndLanTypeCommand(request));

        return compositeCommand;
    }

}
