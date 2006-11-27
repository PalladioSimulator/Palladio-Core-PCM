/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.dialogs.selection.VariableUsageEditDialog;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;

/**
 * @author Snowball
 *
 */
public class VariableReferenceDialogEditPolicy extends OpenEditPolicy {

	private VariableUsage namedReference;

	/**
	 * 
	 */
	public VariableReferenceDialogEditPolicy(VariableUsage characterisation) {
		this.namedReference = characterisation;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy#getOpenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		VariableUsageEditDialog dialog = new VariableUsageEditDialog(getHost().getRoot().getViewer().getControl().getShell());
		dialog.setInitialExpression(namedReference.getNamedReference_VariableUsage());
		dialog.open();
		if (dialog.getResult() != null) {
			final AbstractNamedReference result = dialog.getResult();
			SetValueCommand cmd = new SetValueCommand(
					new SetRequest(namedReference, ParameterPackage.eINSTANCE.getVariableUsage_NamedReference_VariableUsage(), result)) {

						/* (non-Javadoc)
						 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecute(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
						 */
						@Override
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							IStatus s = super.doExecute(monitor, info);
							getHost().refresh();
							return s;
						}
				
			};
			return new ICommandProxy(cmd);
		}
		return null;
	}
}
