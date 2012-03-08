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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/** @author roman */
public class ParametricResourceDemandConfigureCommand extends
		ConfigureElementCommand {

	private ConfigureRequest request = null;
	
	public ParametricResourceDemandConfigureCommand(ConfigureRequest request){
		super(request);
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		CommandResult commandResult = setRequiredResource_ParametricResourceDemand(
				monitor, info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set RequiredResource for the ParametricResourceDemand failed!");
		}
		commandResult = setSpecification_ParametricResourceDemand(monitor, info);
		if (!isOK(commandResult)) {
			return CommandResult
					.newErrorCommandResult("Set Action for the ParametricResourceDemand failed!");
		}
		return CommandResult.newOKCommandResult();
	}

	private CommandResult setRequiredResource_ParametricResourceDemand(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		EObject resource = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ResourceRepository.class);
		filterList.add(ProcessingResourceType.class);

		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, request.getEditingDomain()
						.getResourceSet());
		dialog.setProvidedService(ProcessingResourceType.class);
		dialog.open();
		if (dialog.getResult() == null)
			return CommandResult.newCancelledCommandResult();
		if (!(dialog.getResult() instanceof ProcessingResourceType))
			return CommandResult.newCancelledCommandResult();
		resource = (ProcessingResourceType) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(),
						SeffPerformancePackage.eINSTANCE
								.getParametricResourceDemand_RequiredResource_ParametricResourceDemand(),
						resource));
		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}

	private CommandResult setSpecification_ParametricResourceDemand(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {

		StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				TypeEnum.DOUBLE, request.getElementToConfigure());
		dialog.open();

		if (dialog.getReturnCode() == Dialog.CANCEL)
			return CommandResult.newCancelledCommandResult();

		ICommand cmd = new SetValueCommand(
				new SetRequest(((ParametricResourceDemand)request
					.getElementToConfigure()).getSpecification_ParametericResourceDemand(),
				StoexPackage.eINSTANCE
					.getRandomVariable_Specification(),
				dialog.getResultText()));
		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}
}
