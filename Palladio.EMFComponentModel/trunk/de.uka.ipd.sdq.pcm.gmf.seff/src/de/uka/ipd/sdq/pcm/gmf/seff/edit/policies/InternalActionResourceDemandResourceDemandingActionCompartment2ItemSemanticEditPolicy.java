/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class InternalActionResourceDemandResourceDemandingActionCompartment2ItemSemanticEditPolicy
		extends PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.ParametricResourceDemand_2008 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getAbstractResourceDemandingAction_ResourceDemand_Action());
			}
			return getMSLWrapper(new CreateParametricResourceDemand_2008Command(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT
	 */
	private class CreateParametricResourceDemand_2008Command extends
			CreateElementCommand {

		private ProcessingResourceType resourceType;

		/**
		 * @generated
		 */
		public CreateParametricResourceDemand_2008Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getInternalAction();
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
			((ParametricResourceDemand) result)
					.setRequiredResource_ParametricResourceDemand(resourceType);
			((ParametricResourceDemand) result).setSpecification("=0");
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Shell shell = InternalActionResourceDemandResourceDemandingActionCompartment2ItemSemanticEditPolicy.this
					.getHost().getRoot().getViewer().getControl().getShell();

			ArrayList filterList = new ArrayList();
			filterList.add(ProcessingResourceType.class);
			filterList.add(ResourceRepository.class);
			PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
					shell,
					filterList,
					((GraphicalEditPart) InternalActionResourceDemandResourceDemandingActionCompartment2ItemSemanticEditPolicy.this
							.getHost()).getEditingDomain().getResourceSet());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof ResourceType))
				return CommandResult.newCancelledCommandResult();
			this.resourceType = (ProcessingResourceType) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}

	}

}
