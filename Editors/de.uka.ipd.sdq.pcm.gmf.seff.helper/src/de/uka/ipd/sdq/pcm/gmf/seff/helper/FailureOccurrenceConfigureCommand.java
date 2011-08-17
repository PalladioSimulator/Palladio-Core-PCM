package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription;

public class FailureOccurrenceConfigureCommand extends ConfigureElementCommand {
	private ConfigureRequest request = null;
	
	public FailureOccurrenceConfigureCommand(ConfigureRequest request){
		super(request);
		this.request = request;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = setFailureType(monitor, info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set FailureType for the ParametricResourceDemand failed!");
		}
		
		return CommandResult.newOKCommandResult();
	}

	private CommandResult setFailureType(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		FailureType failureType = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(Repository.class);
		filterList.add(FailureOccurrenceDescription.class);

		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, request.getEditingDomain()
						.getResourceSet());
		dialog.setProvidedService(FailureType.class);
		dialog.open();
		if (dialog.getResult() == null)
			return CommandResult.newCancelledCommandResult();
		if (!(dialog.getResult() instanceof ProcessingResourceType))
			return CommandResult.newCancelledCommandResult();
		failureType = (FailureType) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(),
						RepositoryPackage.eINSTANCE.getFailureType_Repository(),
						failureType));
		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}

}
