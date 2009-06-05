/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

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

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class RoleItemSemanticEditPolicy extends PcmBaseItemSemanticEditPolicy {

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
		if (PcmElementTypes.ProvidedDelegationConnector_3002 == req
				.getElementType()) {
			return req.getSource() == null ? null
					: getCreateCompleteIncomingProvidedDelegationConnector(req);
		}
		if (PcmElementTypes.AssemblyConnector_3001 == req.getElementType()) {
			return req.getSource() == null ? null
					: getCreateCompleteIncomingAssemblyConnector(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	protected Command getCreateCompleteIncomingProvidedDelegationConnector(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof ProvidedRole)
				|| !(req.getTarget() instanceof ProvidedRole)) {
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
		AssemblyContext ctx = (AssemblyContext) ((View) getHost().getParent()
				.getModel()).getElement();

		return getMSLWrapper(new CreateIncomingProvidedDelegationConnector(req,
				ctx) {

			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	protected Command getCreateCompleteIncomingAssemblyConnector(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof RequiredRole)
				|| !(req.getTarget() instanceof ProvidedRole)) {
			return UnexecutableCommand.INSTANCE;
		}
		final ComposedStructure element = (ComposedStructure) ((View) getHost()
				.getParent().getParent().getModel()).getElement();
		if (element == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (req.getContainmentFeature() == null) {
			req
					.setContainmentFeature(CompositionPackage.eINSTANCE
							.getComposedStructure_CompositeAssemblyConnectors_ComposedStructure());
		}
		AssemblyContext ctx = (AssemblyContext) ((View) getHost().getParent()
				.getModel()).getElement();

		return getMSLWrapper(new CreateIncomingAssemblyConnector(req, ctx,
				(AssemblyContext) req.getParameter("source assembly context")) {

			protected EObject getElementToEdit() {
				return element;
			}
		});
	}

	private static class CreateIncomingProvidedDelegationConnector extends
			CreateRelationshipCommand {

		private AssemblyContext clientContext;

		public CreateIncomingProvidedDelegationConnector(
				CreateRelationshipRequest req, AssemblyContext ctx) {
			super(req);
			this.clientContext = ctx;
		}

		protected EClass getEClassToEdit() {
			return CompositionPackage.eINSTANCE.getComposedStructure();
		};

		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		protected EObject doDefaultElementCreation() {
			ProvidedDelegationConnector newElement = (ProvidedDelegationConnector) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setOuterProvidedRole_ProvidedDelegationConnector((ProvidedRole) getSource());
				newElement
						.setInnerProvidedRole_ProvidedDelegationConnector((ProvidedRole) getTarget());
				newElement
						.setChildComponentContext_ProvidedDelegationConnector(clientContext);
			}
			return newElement;
		}
	}

	private static class CreateIncomingAssemblyConnector extends
			CreateRelationshipCommand {

		private AssemblyContext targetClientContext;

		private AssemblyContext sourceClientContext;

		public CreateIncomingAssemblyConnector(CreateRelationshipRequest req,
				AssemblyContext ctx, AssemblyContext sourceContext) {
			super(req);
			this.targetClientContext = ctx;
			this.sourceClientContext = sourceContext;
		}

		protected EClass getEClassToEdit() {
			return CompositionPackage.eINSTANCE.getComposedStructure();
		};

		protected void setElementToEdit(EObject element) {
			throw new UnsupportedOperationException();
		}

		protected EObject doDefaultElementCreation() {
			AssemblyConnector newElement = (AssemblyConnector) super
					.doDefaultElementCreation();
			if (newElement != null) {
				newElement
						.setProvidedRole_CompositeAssemblyConnector((ProvidedRole) getTarget());
				newElement
						.setRequiredRole_CompositeAssemblyConnector((RequiredRole) getSource());
				newElement
						.setProvidingChildComponentContext_CompositeAssemblyConnector(targetClientContext);
				newElement
						.setRequiringChildComponentContext_CompositeAssemblyConnector(sourceClientContext);
			}
			return newElement;
		}
	}

}
