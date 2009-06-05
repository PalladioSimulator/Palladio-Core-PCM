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
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.dialogs.selection.VariableCharacterisationEditDialog;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * @author Snowball
 *
 */
public class VariableCharacterisationDialogEditPolicy extends OpenEditPolicy {

	private VariableCharacterisation characterisation;

	/**
	 * 
	 */
	public VariableCharacterisationDialogEditPolicy(VariableCharacterisation characterisation) {
		this.characterisation = characterisation;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy#getOpenCommand(org.eclipse.gef.Request)
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		VariableCharacterisationEditDialog dialog = new VariableCharacterisationEditDialog(getHost().getRoot().getViewer().getControl().getShell());
		dialog.setInitialExpression(characterisation);
		dialog.open();
		if (dialog.getResult() != null) {
			final VariableCharacterisation result = dialog.getResult();
			SetValueCommand cmd = new SetValueCommand(
					new SetRequest(characterisation, ParameterPackage.eINSTANCE.getVariableCharacterisation_Type(), result.getType())) {

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
			SetValueCommand cmd2 = new SetValueCommand(
					new SetRequest(characterisation, StoexPackage.eINSTANCE.getRandomVariable_Specification(), result.getSpecification())) {

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
			CompositeCommand cmd3 = new CompositeCommand("Update Variable Usage");
			cmd3.compose(cmd);
			cmd3.compose(cmd2);
			return new ICommandProxy(cmd3);
		}
		return null;
	}
}
