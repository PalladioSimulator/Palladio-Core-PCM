package de.uka.ipd.sdq.pcm.gmf.repository.helper;

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

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

class CreateLinkedSeffCommand extends ConfigureElementCommand {

	private Signature service;
	private ConfigureRequest myRequest;

	public CreateLinkedSeffCommand(ConfigureRequest request,
			Signature service) {
		super(request);
		this.service = service;
		myRequest = request;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		CommandResult commandResult = createSEFF(
				ElementTypeRegistry.getInstance().getType("de.uka.ipd.sdq.pcm.gmf.repository.helper.InitialisedResourceDemandingSEFF_4201"),monitor);
        if (!isOK(commandResult))
        {
        	return CommandResult.newErrorCommandResult("Create StartAction for the new SEFF failed!");
        }
        ResourceDemandingSEFF seff = (ResourceDemandingSEFF) commandResult.getReturnValue();
        SetRequest setter = new SetRequest(seff,
        		SeffPackage.eINSTANCE.getServiceEffectSpecification_DescribedService__SEFF(), 
        		service);
        SetValueCommand setCommand = new SetValueCommand(setter);
        setCommand.execute(monitor, info);
        CommandResult result = setCommand.getCommandResult();
        if (!isOK(result))
        {
        	return CommandResult.newErrorCommandResult("Create SEFF failed!");
        }
        StartAction start = SeffFactory.eINSTANCE.createStartAction(); 
        SetRequest setter2 = new SetRequest(seff,
        		SeffPackage.eINSTANCE.getResourceDemandingBehaviour_Steps_Behaviour(), 
        		start);
        SetValueCommand setCommand2 = new SetValueCommand(setter2);
        setCommand2.execute(monitor, info);
        result = setCommand2.getCommandResult();
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

	private CommandResult createSEFF(
			IElementType typeId,
			IProgressMonitor monitor) throws ExecutionException {
		CreateElementRequest seffRequest = new CreateElementRequest(
				myRequest.getElementToConfigure(), 
				typeId, 
				RepositoryPackage.eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent()
				);
		seffRequest.setLabel("Create SEFF");
		CreateElementCommand createStartCommand = new CreateElementCommand(seffRequest);
        createStartCommand.execute(monitor, null);
        CommandResult commandResult = createStartCommand.getCommandResult();
		return commandResult;
	}

}

public class BasicComponentEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {

	@Override
	protected ICommand getAfterCreateRelationshipCommand(
			CreateRelationshipRequest request) {
		if (request.getTarget() != null
				&& request.getTarget() instanceof Interface) {
			if (request.getElementType().getEClass() == RepositoryPackage.eINSTANCE.getProvidedRole()) {
				Interface target = (Interface) request.getTarget();
				if (target.getSignatures__Interface().size() > 0){
					BasicComponent source = (BasicComponent) request.getSource();
					CompositeCommand createSEFFs = new CompositeCommand(
							"Create SEFFs");
					for (Signature s : target.getSignatures__Interface()) {
						ConfigureRequest ceRequest = new ConfigureRequest(
								source,
								ElementTypeRegistry
										.getInstance()
										.getType(
												"de.uka.ipd.sdq.pcm.gmf.seff.ResourceDemandingSEFF_1000"));
						CreateLinkedSeffCommand cmd = new CreateLinkedSeffCommand(
								ceRequest, s);
						createSEFFs.add(cmd);
					}
					return createSEFFs;
				}
			}
		}
		return super.getAfterCreateRelationshipCommand(request);
	}

}
