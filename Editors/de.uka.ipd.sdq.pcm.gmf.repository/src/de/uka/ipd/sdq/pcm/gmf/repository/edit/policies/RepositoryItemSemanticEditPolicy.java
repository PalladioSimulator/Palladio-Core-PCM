/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.BasicComponentCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompositeComponentCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InterfaceCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidesComponentTypeCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * @generated
 */
public class RepositoryItemSemanticEditPolicy extends
		PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.Interface_2101 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getRepository_Interfaces__Repository());
			}
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.BasicComponent_2102 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getRepository_Components__Repository());
			}
			return getGEFWrapper(new BasicComponentCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.CompleteComponentType_2103 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getRepository_Components__Repository());
			}
			return getGEFWrapper(new CompleteComponentTypeCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ProvidesComponentType_2104 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getRepository_Components__Repository());
			}
			return getGEFWrapper(new ProvidesComponentTypeCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.CompositeComponent_2105 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(RepositoryPackage.eINSTANCE
						.getRepository_Components__Repository());
			}
			return getGEFWrapper(new CompositeComponentCreateCommand(req));
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
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}
	}
}
