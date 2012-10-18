package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

/**
 * Configure SEFF Command.
 */
class ConfigureSEFFCommand extends ConfigureElementCommand {
    
    /**
     * A configure request.
     */
    private final ConfigureRequest myRequest;

    /**
     * The constructor.
     * @param request a ConfigureRequest
     */
    public ConfigureSEFFCommand(ConfigureRequest request) {
        super(request);
        myRequest = request;
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) myRequest.getElementToConfigure();
        StartAction start = SeffFactory.eINSTANCE.createStartAction();
        start.setEntityName("start");
        SetRequest setter2 = new SetRequest(seff,
                SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), start);
        SetValueCommand setCommand2 = new SetValueCommand(setter2);
        setCommand2.execute(monitor, info);
        CommandResult result = setCommand2.getCommandResult();
        if (!isOK(result)) {
            return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        StopAction stop = SeffFactory.eINSTANCE.createStopAction();
        stop.setEntityName("stop");
        SetRequest setter3 = new SetRequest(seff,
                SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), stop);
        SetValueCommand setCommand3 = new SetValueCommand(setter3);
        setCommand3.execute(monitor, info);
        result = setCommand3.getCommandResult();
        if (!isOK(result)) {
            return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        SetRequest setter4 = new SetRequest(start, SeffPackage.eINSTANCE.getAbstractAction_Successor_AbstractAction(),
                stop);
        SetValueCommand setCommand4 = new SetValueCommand(setter4);
        setCommand4.execute(monitor, info);
        result = setCommand4.getCommandResult();
        if (!isOK(result)) {
            return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        return CommandResult.newOKCommandResult();
    }
}

/**
 * The repository editor SEFF EditHelperAdvice.
 */
public class RepositoryEditorSeffEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    
    
    @Override
    /**
     * Sets signature of a provided role
     */
    protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
        EObject signature = null;
        ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
        // Set types to show and their super types
        filterList.add(ProvidedRole.class);
        filterList.add(Interface.class);
        filterList.add(Signature.class);
        ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
        // set EReference that should be set (in this case: provided role)
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getOperationProvidedRole_ProvidedInterface__OperationProvidedRole());
        additionalReferences.add(RepositoryPackage.eINSTANCE
                .getInterface_ParentInterfaces__Interface());
        
        PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench()
                .getActiveWorkbenchWindow().getShell(), filterList, additionalReferences, request
                .getElementToConfigure().eContainer());
        dialog.setProvidedService(Signature.class);
        dialog.open();
        if (dialog.getResult() == null) {
            return new CanceledCommand();
        }
        if (!(dialog.getResult() instanceof Signature)) {
            return new CanceledCommand();
        }
        signature = dialog.getResult();

        ICommand cmd = new SetValueCommand(new SetRequest(request.getElementToConfigure(),
                SeffPackage.eINSTANCE.getServiceEffectSpecification_DescribedService__SEFF(), signature));
        CompositeCommand cc = new CompositeCommand("Configure SEFF");
        cc.add(cmd);
        cc.add(new ConfigureSEFFCommand(request));
        return cc;
    }

}
