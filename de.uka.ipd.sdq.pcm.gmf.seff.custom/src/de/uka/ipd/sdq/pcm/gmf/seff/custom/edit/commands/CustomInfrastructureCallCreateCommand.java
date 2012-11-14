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

/**
 * The customized infrastructure call create command class.
 */
public class CustomInfrastructureCallCreateCommand extends InfrastructureCallCreateCommand {

    /** Default number of calls to use for a infrastructure call. */
    private static final String DEFAULT_NUMBER_OF_CALLS = "1";

    /**
     * Instantiates a new customized infrastructure call create command.
     * 
     * @param req
     *            the req
     */
    public CustomInfrastructureCallCreateCommand(final CreateElementRequest req) {
        super(req);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InfrastructureCallCreateCommand#doExecuteWithResult
     * (org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    /**
     * Do execute with result.
     *
     * @param monitor the monitor
     * @param info the info
     * @return the command result
     * @throws ExecutionException the execution exception
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InfrastructureCallCreateCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
     */
    @Override
    protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info)
            throws ExecutionException {
        final de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall newElement = de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformanceFactory.eINSTANCE
                .createInfrastructureCall();
        // add empty random variable
        final PCMRandomVariable numberOfCalls = CoreFactory.eINSTANCE.createPCMRandomVariable();
        numberOfCalls.setSpecification(DEFAULT_NUMBER_OF_CALLS);
        newElement.setNumberOfCalls__InfrastructureCall(numberOfCalls);

        final AbstractInternalControlFlowAction owner = (AbstractInternalControlFlowAction) this.getElementToEdit();
        owner.getInfrastructureCall__Action().add(newElement);

        this.doConfigure(newElement, monitor, info);

        ((CreateElementRequest) this.getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }

}
