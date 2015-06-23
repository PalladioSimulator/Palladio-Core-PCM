package de.uka.ipd.sdq.pcm.gmf.repository.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureSignature;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.Signature;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffFactory;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;

/**
 * Command class to create the new SEFF.
 * 
 * @author Benjamin Klatt (only documentation)
 * 
 */
class CreateLinkedSeffCommand extends ConfigureElementCommand {

    /**
     * A service signature.
     */
    private final Signature service;

    /**
     * A configuration request.
     */
    private final ConfigureRequest myRequest;

    /**
     * Constructor to initialize the element creation command.
     * 
     * @param request
     *            The request about the element configuration
     * @param service
     *            The signature to be created
     */
    public CreateLinkedSeffCommand(ConfigureRequest request, Signature service) {
        super(request);
        this.service = service;
        myRequest = request;
    }

    /**
     * Execute the command and create the seff including the minimum setup with a StartAction and a
     * StopAction.
     * 
     * @param monitor
     *            The monitor to report the progress to
     * @param info
     *            Adaptable object for the environment
     * 
     * @throws ExecutionException
     *             An Exception
     * 
     * @return a CommandResult
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

        CommandResult commandResult = createSEFF(
                ElementTypeRegistry.getInstance().getType(
                        "de.uka.ipd.sdq.pcm.gmf.repository.helper.InitialisedResourceDemandingSEFF_4201"), monitor);
        if (!isOK(commandResult)) {
            return CommandResult.newErrorCommandResult("Create StartAction for the new SEFF failed!");
        }
        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) commandResult.getReturnValue();
        SetRequest setter = new SetRequest(seff,
                SeffPackage.eINSTANCE.getServiceEffectSpecification_DescribedService__SEFF(), service);
        SetValueCommand setCommand = new SetValueCommand(setter);
        setCommand.execute(monitor, info);
        CommandResult result = setCommand.getCommandResult();
        if (!isOK(result)) {
            return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        StartAction start = SeffFactory.eINSTANCE.createStartAction();
        start.setEntityName("start");
        SetRequest setter2 = new SetRequest(seff,
                SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), start);
        SetValueCommand setCommand2 = new SetValueCommand(setter2);
        setCommand2.execute(monitor, info);
        result = setCommand2.getCommandResult();
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

    /**
     * Create the SEFF object and return the result information about the creation process.
     * 
     * @param typeId
     *            The class to created an instance of.
     * @param monitor
     *            The monitor to report the progress.
     * @return The Seff creation result information.
     * @throws ExecutionException
     *             An Exception
     */
    private CommandResult createSEFF(IElementType typeId, IProgressMonitor monitor) throws ExecutionException {
        CreateElementRequest seffRequest = new CreateElementRequest(myRequest.getElementToConfigure(), typeId,
                RepositoryPackage.eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent());
        seffRequest.setLabel("Create SEFF");
        CreateElementCommand createStartCommand = new CreateElementCommand(seffRequest);
        createStartCommand.execute(monitor, null);
        CommandResult commandResult = createStartCommand.getCommandResult();
        return commandResult;
    }

}

/**
 * The interface EditHelper Advice.
 */
public class InterfaceEditHelperAdvice extends AbstractEditHelperAdvice implements IEditHelperAdvice {

    /**
     * If a new ProvidedRole relation ship is created, create the according SEFFs in the basic
     * component. This applies for OperationProvidedRoles as well as for event SinkRoles.
     * 
     * @param request
     *            The request to create the relationship
     * @return The command for any further processing
     */
    @Override
    protected ICommand getAfterCreateRelationshipCommand(CreateRelationshipRequest request) {

        // create seff for operation interface
        if (request.getTarget() != null && request.getTarget() instanceof OperationInterface) {
            if (request.getElementType().getEClass() == RepositoryPackage.eINSTANCE.getOperationProvidedRole()) {
                OperationInterface target = (OperationInterface) request.getTarget();
                if (extractSignatures(target).size() > 0) {
                    if (request.getSource() instanceof BasicComponent) {
                        BasicComponent source = (BasicComponent) request.getSource();
                        CompositeCommand createSEFFs = createOperationSEFFsForOperationInterface(target, source);
                        return createSEFFs;
                    }
                }
            }
        } else if (request.getTarget() != null && request.getTarget() instanceof EventGroup) { // create
                                                                                               // seff
                                                                                               // for
                                                                                               // event
                                                                                               // group
            if (request.getElementType().getEClass() == RepositoryPackage.eINSTANCE.getSinkRole()) {
                EventGroup target = (EventGroup) request.getTarget();
                if (target.getEventTypes__EventGroup().size() > 0) {
                    BasicComponent source = (BasicComponent) request.getSource();
                    CompositeCommand createSEFFs = new CompositeCommand("Create SEFFs");
                    for (EventType t : target.getEventTypes__EventGroup()) {
                        ConfigureRequest ceRequest = new ConfigureRequest(source, ElementTypeRegistry.getInstance()
                                .getType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"));
                        CreateLinkedSeffCommand cmd = new CreateLinkedSeffCommand(ceRequest, t);
                        createSEFFs.add(cmd);
                    }
                    return createSEFFs;
                }
            }
        } else if (request.getTarget() != null && request.getTarget() instanceof InfrastructureInterface) { // create
                                                                                                            // SEFF
                                                                                                            // for
                                                                                                            // infrastructure
                                                                                                            // interface
            if (request.getElementType().getEClass() == RepositoryPackage.eINSTANCE.getInfrastructureProvidedRole()) {
                InfrastructureInterface target = (InfrastructureInterface) request.getTarget();
                if (target.getInfrastructureSignatures__InfrastructureInterface().size() > 0) {
                    if (request.getSource() instanceof BasicComponent) {
                        BasicComponent source = (BasicComponent) request.getSource();
                        CompositeCommand createSEFFs = new CompositeCommand("Create SEFFs");
                        for (InfrastructureSignature s : target.getInfrastructureSignatures__InfrastructureInterface()) {
                            ConfigureRequest ceRequest = new ConfigureRequest(source, ElementTypeRegistry.getInstance()
                                    .getType("de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"));
                            CreateLinkedSeffCommand cmd = new CreateLinkedSeffCommand(ceRequest, s);
                            createSEFFs.add(cmd);
                        }
                        return createSEFFs;
                    }
                }
            }
        }
        return super.getAfterCreateRelationshipCommand(request);
    }

    /**
     * creates an operation SEFF.
     * 
     * @param target
     *            an Operation Interface
     * @param source
     *            a Basic Component
     * @return a Composite Command
     */
    private CompositeCommand createOperationSEFFsForOperationInterface(OperationInterface target, BasicComponent source) {
        CompositeCommand createSEFFs = new CompositeCommand("Create SEFFs");
        List<OperationSignature> signatures = new ArrayList<OperationSignature>();
        signatures.addAll(extractSignatures(target));
        for (OperationSignature s : signatures) {
            ConfigureRequest ceRequest = new ConfigureRequest(source, ElementTypeRegistry.getInstance().getType(
                    "de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"));
            CreateLinkedSeffCommand cmd = new CreateLinkedSeffCommand(ceRequest, s);
            createSEFFs.add(cmd);
        }
        return createSEFFs;
    }

    /**
     * Extracts signatures.
     * 
     * @param target
     *            an Operation Interface
     * @return a List of Operation Interfaces
     */
    private List<OperationSignature> extractSignatures(OperationInterface target) {
        List<OperationSignature> signatures = new ArrayList<OperationSignature>();
        signatures.addAll(target.getSignatures__OperationInterface());
        for (Interface pi : target.getParentInterfaces__Interface()) {
            if (pi instanceof OperationInterface) {
                signatures.addAll(extractSignatures((OperationInterface) pi));
            }
        }
        return signatures;
    }

}
