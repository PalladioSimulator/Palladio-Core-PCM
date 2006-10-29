/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class BasicComponentSEFFCompartmentItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.ResourceDemandingSEFF_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(RepositoryPackage.eINSTANCE
								.getBasicComponent_ServiceEffectSpecifications__BasicComponent());
			}
			return getMSLWrapper(new CreateResourceDemandingSEFF_2002Command(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateResourceDemandingSEFF_2002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateResourceDemandingSEFF_2002Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return RepositoryPackage.eINSTANCE.getBasicComponent();
		};

		/**
		 * @generated
		 */
		protected EObject getElementToEdit() {
			EObject container = ((CreateElementRequest) getRequest())
					.getContainer();
			if (container instanceof View) {
				container = ((View) container).getElement();
			}
			return container;
		}
	}

}
