/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.parts.BasicComponentSEFFCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

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
	 * @generated NOT
	 */
	private class CreateResourceDemandingSEFF_2002Command extends
			CreateElementCommand {

		private Signature signature;
		private Shell shell;


		/**
		 * @generated NOT
		 */
		public CreateResourceDemandingSEFF_2002Command(CreateElementRequest req) {
			super(req);
			this.shell = BasicComponentSEFFCompartmentItemSemanticEditPolicy.this.getHost().getRoot().getViewer().getControl().getShell();
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
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doDefaultElementCreation()
		 */
		@Override
		protected EObject doDefaultElementCreation() {
			EObject result = super.doDefaultElementCreation();
			((ServiceEffectSpecification) result)
					.setDescribedService__SEFF(signature);
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ArrayList filterList = new ArrayList();
			filterList.add(ProvidedRole.class);
			filterList.add(Interface.class);
			filterList.add(Signature.class);
			ArrayList additionalReferences = new ArrayList();
			additionalReferences.add(RepositoryPackage.eINSTANCE.getProvidedRole_ProvidedInterface__ProvidedRole());
			PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
					shell,
					filterList, 
					additionalReferences,
					((View)((BasicComponentSEFFCompartmentEditPart)BasicComponentSEFFCompartmentItemSemanticEditPolicy.this.getHost()).getModel()).getElement());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof Signature))
				return CommandResult.newCancelledCommandResult();
			this.signature = (Signature) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}
	}

}
