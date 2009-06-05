/*
 *copyright 2006, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * @generated NOT
 */
public class ResourceContainerAllocationCompartmentItemSemanticEditPolicy
		extends PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.AllocationContext_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(AllocationPackage.eINSTANCE
						.getAllocation_AllocationContexts_Allocation());
			}
			return getMSLWrapper(new CreateAllocationContext_2001Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private class CreateAllocationContext_2001Command extends
			CreateElementCommand {

		private AssemblyContext assemblyContext;

		/**
		 * @generated
		 */
		public CreateAllocationContext_2001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated NOT
		 */
		protected EClass getEClassToEdit() {
			return AllocationPackage.eINSTANCE.getAllocation();
		};

		/**
		 * @generated NOT
		 */
		protected EObject getElementToEdit() {
			EObject container = (EObject) ResourceContainerAllocationCompartmentItemSemanticEditPolicy.this.getHost().getParent().getParent().getModel();
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
			((AllocationContext) result)
				.setAssemblyContext_AllocationContext(assemblyContext);
			((AllocationContext) result)
				.setResourceContainer_AllocationContext((ResourceContainer)
						((View)ResourceContainerAllocationCompartmentItemSemanticEditPolicy.this.getHost().getModel()).getElement());
			return result;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Shell shell = ResourceContainerAllocationCompartmentItemSemanticEditPolicy.this.getHost().getRoot().getViewer().getControl().getShell();
			Allocation alloc = (Allocation)((View)ResourceContainerAllocationCompartmentItemSemanticEditPolicy.this.getHost().getParent().getParent().getModel()).getElement();
			
			ArrayList filterList = new ArrayList();
			filterList.add(ComposedStructure.class);
			filterList.add(AssemblyContext.class);
			PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
					shell,
					filterList,
					alloc.getSystem_Allocation());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof AssemblyContext))
				return CommandResult.newCancelledCommandResult();
			this.assemblyContext = (AssemblyContext) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}
	
	}

}
