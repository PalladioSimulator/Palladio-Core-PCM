/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class InterfaceItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		});
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PcmElementTypes.ProvidedRole_3001 == req.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingProvidedRole3001Command(req);
		}
		if (PcmElementTypes.RequiredRole_3002 == req.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingRequiredRole3002Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingProvidedRole3001Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof InterfaceProvidingEntity)) {
			return UnexecutableCommand.INSTANCE;
		}
		final InterfaceProvidingEntity element = (InterfaceProvidingEntity) req
				.getSource();
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(EntityPackage.eINSTANCE
							.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
		}
		return getMSLWrapper(new CreateIncomingProvidedRole3001Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingProvidedRole3001Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingProvidedRole3001Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EntityPackage.eINSTANCE.getInterfaceProvidingEntity();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			ProvidedRole newElement = (ProvidedRole) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setProvidedInterface__ProvidedRole((Interface) getTarget());
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingRequiredRole3002Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof InterfaceRequiringEntity)) {
			return UnexecutableCommand.INSTANCE;
		}
		final InterfaceRequiringEntity element = (InterfaceRequiringEntity) req
				.getSource();
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(EntityPackage.eINSTANCE
							.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity());
		}
		return getMSLWrapper(new CreateIncomingRequiredRole3002Command(req) {

			/**
			 * @generated
			 */
			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	/**
	 * @generated
	 */
	private static class CreateIncomingRequiredRole3002Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingRequiredRole3002Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return EntityPackage.eINSTANCE.getInterfaceRequiringEntity();
		};

		/**
		 * @generated
		 */
		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @generated
		 */
		protected EObject doDefaultElementCreation() {
			RequiredRole newElement = (RequiredRole) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setRequiredInterface__RequiredRole((Interface) getTarget());
			}
			return newElement;
		}
	}
}
