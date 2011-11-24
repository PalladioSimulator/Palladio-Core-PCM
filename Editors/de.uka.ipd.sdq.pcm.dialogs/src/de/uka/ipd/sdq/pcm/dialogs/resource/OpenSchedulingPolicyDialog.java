package de.uka.ipd.sdq.pcm.dialogs.resource;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

public class OpenSchedulingPolicyDialog extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		SchedulingPolicy policy;
		
		SelectSchedulingPolicyElementDialog dialog = new SelectSchedulingPolicyElementDialog(
							PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.open();
		if (dialog.getResult() == null) {
			return null;
		}

		if (!(dialog.getResult() instanceof SchedulingPolicy)){
			return null;
		}
		policy = dialog.getResult();
		
		ProcessingResourceSpecification specification = (ProcessingResourceSpecification)(((View) ((IGraphicalEditPart) getHost()).getModel()).getElement());
		ICommand icmd = new SetValueCommand(
				new SetRequest(
						specification, 
						ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_SchedulingPolicy(),
						policy));
		return new ICommandProxy(icmd);
	}

}
