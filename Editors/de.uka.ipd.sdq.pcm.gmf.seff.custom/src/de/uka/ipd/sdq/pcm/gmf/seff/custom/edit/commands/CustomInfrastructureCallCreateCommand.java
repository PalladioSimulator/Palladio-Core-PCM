/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InfrastructureCallCreateCommand;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;


public class CustomInfrastructureCallCreateCommand extends InfrastructureCallCreateCommand {

	// Default number of calls to use for a infrastructure call.
	private static final String DEFAULT_NUMBER_OF_CALLS = "1";

	public CustomInfrastructureCallCreateCommand(CreateElementRequest req) {
		super(req);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall newElement = de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory.eINSTANCE
				.createInfrastructureCall();
		// add empty random variable
		PCMRandomVariable numberOfCalls = CoreFactory.eINSTANCE
				.createPCMRandomVariable();
		numberOfCalls.setSpecification(DEFAULT_NUMBER_OF_CALLS);
		newElement.setNumberOfCalls__InfrastructureCall(numberOfCalls);

		AbstractInternalControlFlowAction owner = (AbstractInternalControlFlowAction) getElementToEdit();
		owner.getInfrastructureCall__Action().add(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

}
