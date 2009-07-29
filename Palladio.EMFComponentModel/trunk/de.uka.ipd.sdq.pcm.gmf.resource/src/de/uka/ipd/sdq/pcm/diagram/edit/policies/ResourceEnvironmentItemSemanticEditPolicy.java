package de.uka.ipd.sdq.pcm.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.pcm.diagram.edit.commands.CommunicationLinkResourceSpecificationCreateCommand;
import de.uka.ipd.sdq.pcm.diagram.edit.commands.ResourceContainerCreateCommand;
import de.uka.ipd.sdq.pcm.diagram.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * @generated
 */
public class ResourceEnvironmentItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.ResourceContainer_2001 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(ResourceenvironmentPackage.eINSTANCE
						.getResourceEnvironment_ResourceContainer_ResourceEnvironment());
			}
			return getGEFWrapper(new ResourceContainerCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.CommunicationLinkResourceSpecification_2002 == req
				.getElementType()) {
			return getGEFWrapper(new CommunicationLinkResourceSpecificationCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
