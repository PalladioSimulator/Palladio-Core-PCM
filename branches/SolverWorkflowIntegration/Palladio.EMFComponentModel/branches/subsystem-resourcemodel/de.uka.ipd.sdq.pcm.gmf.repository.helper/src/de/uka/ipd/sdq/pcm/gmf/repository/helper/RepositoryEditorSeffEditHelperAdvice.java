package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.AbstractInterface;
import de.uka.ipd.sdq.pcm.repository.AbstractService;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

class ConfigureSEFFCommand extends ConfigureElementCommand {
	private ConfigureRequest myRequest;

	public ConfigureSEFFCommand(ConfigureRequest request) {
		super(request);
		myRequest = request;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) myRequest.getElementToConfigure();
        StartAction start = SeffFactory.eINSTANCE.createStartAction(); 
        SetRequest setter2 = new SetRequest(seff,
        		SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), 
        		start);
        SetValueCommand setCommand2 = new SetValueCommand(setter2);
        setCommand2.execute(monitor, info);
        CommandResult result = setCommand2.getCommandResult();
        if (!isOK(result))
        {
        	return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        StopAction stop = SeffFactory.eINSTANCE.createStopAction(); 
        SetRequest setter3 = new SetRequest(seff,
        		SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), 
        		stop);
        SetValueCommand setCommand3 = new SetValueCommand(setter3);
        setCommand3.execute(monitor, info);
        result = setCommand3.getCommandResult();
        if (!isOK(result))
        {
        	return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        SetRequest setter4 = new SetRequest(start,
        		SeffPackage.eINSTANCE.getAbstractAction_Successor_AbstractAction(), 
        		stop);
        SetValueCommand setCommand4 = new SetValueCommand(setter4);
        setCommand4.execute(monitor, info);
        result = setCommand4.getCommandResult();
        if (!isOK(result))
        {
        	return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        return CommandResult.newOKCommandResult();
	}
}

public class RepositoryEditorSeffEditHelperAdvice extends AbstractEditHelperAdvice implements
		IEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject signature = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ProvidedRole.class);
		filterList.add(AbstractInterface.class);
		filterList.add(AbstractService.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		additionalReferences.add(RepositoryPackage.eINSTANCE.getProvidedRole_ProvidedInterface__ProvidedRole());
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				request.getElementToConfigure().eContainer());
		dialog.setProvidedService(AbstractService.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof AbstractService))
			return new CanceledCommand();
		signature = (AbstractService) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						SeffPackage.eINSTANCE.getServiceEffectSpecification_DescribedService__SEFF(),
						signature));
		CompositeCommand cc = new CompositeCommand("Configure SEFF");
		cc.add(cmd);
		cc.add(new ConfigureSEFFCommand(request));
		return cc;
	}	
	
}
