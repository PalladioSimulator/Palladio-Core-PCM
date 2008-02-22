/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * @author Roman Andrej
 */
public class LoopActionConfigureCommand extends ConfigureElementCommand {

	private ConfigureRequest request = null;
	
	public LoopActionConfigureCommand(ConfigureRequest request) {
		super(request);
		this.request = request;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
//		CommandResult commandResult = setRequiredResource_ParametricResourceDemand(
//				monitor, info);
//		if (!isOK(commandResult)) {
//			return CommandResult
//					.newErrorCommandResult("Set RequiredResource for the ParametricResourceDemand failed!");
//		}
//		commandResult = setSpecification_ParametricResourceDemand(monitor, info);
////		if (!isOK(commandResult)) {
////			return CommandResult
////					.newErrorCommandResult("Set Action for the ParametricResourceDemand failed!");
////		}
//		return CommandResult.newOKCommandResult();
		return null;
	}
	
	private CommandResult createPCMRandomVariable(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		IElementType elementType = PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014;

		CreateElementRequest createElementRequest = new CreateElementRequest(
				request.getElementToConfigure(), elementType);

		ICommand cmd = new CreateElementCommand(createElementRequest);

		return cmd.getCommandResult();
	}

	/** Set the specification of '1'. */
	private CommandResult setSpecification_ParametricResourceDemand(
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		RandomVariable randomVariable = StoexFactory.eINSTANCE.createRandomVariable();
		
		randomVariable.setSpecification("1");

		ICommand cmd = new SetValueCommand(new SetRequest(
				((LoopAction) request.getElementToConfigure()).getIterationCount_LoopAction(),
				SeffPackage.eINSTANCE.getLoopAction_IterationCount_LoopAction(), randomVariable));
		cmd.execute(monitor, info);

		return cmd.getCommandResult();
	}
}
