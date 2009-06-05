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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

/**
 * @generated
 */
public class SystemRequiredRoleItemSemanticEditPolicy extends
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
	 * @generated NOT
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PcmElementTypes.RequiredDelegationConnector_3003 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingRequiredDelegationConnector3003Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingAssemblyConnector3001Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingRequiredDelegationConnector3003Command(
			CreateRelationshipRequest req) {
		return new Command() {
		};
	}

	/**
	 * @generated NOT
	 */
	protected Command getCreateCompleteIncomingRequiredDelegationConnector3003Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof RequiredRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		final ComposedStructure element = (ComposedStructure) ((View) getHost()
				.getParent().getModel()).getElement();
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_RequiredDelegationConnectors_ComposedStructure());
		}
		return getMSLWrapper(new CreateIncomingRequiredDelegationConnector3003Command(
				req, (AssemblyContext) req
						.getParameter("source assembly context")) {

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
	private static class CreateIncomingRequiredDelegationConnector3003Command
			extends CreateRelationshipCommand {

		/**
		 * @generated
		 */
		public CreateIncomingRequiredDelegationConnector3003Command(
				CreateRelationshipRequest req) {
			super(req);
		}

		private AssemblyContext sourceContext;

		/**
		 * @generated NOT
		 */
		public CreateIncomingRequiredDelegationConnector3003Command(
				CreateRelationshipRequest req, AssemblyContext ctx) {
			super(req);
			this.sourceContext = ctx;
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
		 * @generated NOT
		 */
		protected EObject doDefaultElementCreation() {
			RequiredDelegationConnector newElement = (RequiredDelegationConnector) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setOuterRequiredRole_RequiredDelegationConnector((RequiredRole) getTarget());
				newElement
						.setInnerRequiredRole_RequiredDelegationConnector((RequiredRole) getSource());
				newElement
						.setChildComponentContext_RequiredDelegationConnector(sourceContext);
			}
			return newElement;
		}
	}
}
