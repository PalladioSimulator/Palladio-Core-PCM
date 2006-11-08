/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;

import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

/**
 * @generated
 */
public class SystemProvidedRoleItemSemanticEditPolicy extends
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
		if (PcmElementTypes.AssemblyConnector_3001 == req.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingAssemblyConnector3001Command(req);
		}
		if (PcmElementTypes.ProvidedDelegationConnector_3002 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingProvidedDelegationConnector3002Command(req)
					: getCreateCompleteIncomingProvidedDelegationConnector3002Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingAssemblyConnector3001Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof RequiredRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		final ComposedStructure element = (ComposedStructure) getRelationshipContainer(
				req.getSource(), CompositionPackage.eINSTANCE
						.getComposedStructure(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_CompositeAssemblyConnectors_ComposedStructure());
		}
		return getMSLWrapper(new CreateIncomingAssemblyConnector3001Command(req) {

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
	private static class CreateIncomingAssemblyConnector3001Command extends
			CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingAssemblyConnector3001Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return CompositionPackage.eINSTANCE.getComposedStructure();
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
			AssemblyConnector newElement = (AssemblyConnector) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setProvidedRole_CompositeAssemblyConnector((ProvidedRole) getTarget());
				newElement
						.setRequiredRole_CompositeAssemblyConnector((RequiredRole) getSource());
			}
			return newElement;
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingProvidedDelegationConnector3002Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingProvidedDelegationConnector3002Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof ProvidedRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		final ComposedStructure element = (ComposedStructure) getRelationshipContainer(
				req.getSource(), CompositionPackage.eINSTANCE
						.getComposedStructure(), req.getElementType());
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_ProvidedDelegationConnectors_ComposedStructure());
		}
		return getMSLWrapper(new CreateIncomingProvidedDelegationConnector3002Command(
				req) {

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
	private static class CreateIncomingProvidedDelegationConnector3002Command
			extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingProvidedDelegationConnector3002Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return CompositionPackage.eINSTANCE.getComposedStructure();
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
			ProvidedDelegationConnector newElement = (ProvidedDelegationConnector) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole) getTarget());
				newElement
						.setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole) getSource());
			}
			return newElement;
		}
	}
}
