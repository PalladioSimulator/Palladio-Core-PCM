package de.uka.ipd.sdq.pcm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.diagram.edit.commands.ProcessingResourceSpecificationCreateCommand;
import de.uka.ipd.sdq.pcm.diagram.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * @generated
 */
public class ResourceContainerResourceContainerCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(ResourceenvironmentPackage.eINSTANCE
								.getResourceContainer_ActiveResourceSpecifications_ResourceContainer());
			}
			return getGEFWrapper(new ProcessingResourceSpecificationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
