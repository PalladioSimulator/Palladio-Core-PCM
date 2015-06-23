/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyContextCreateCommand;

/**
 * The Class CustomAssemblyContextCreateCommand.
 */
public class CustomAssemblyContextCreateCommand extends AssemblyContextCreateCommand {

    /**
     * Instantiates a new custom assembly context create command.
     * 
     * @param req
     *            the req
     */
    public CustomAssemblyContextCreateCommand(CreateElementRequest req) {
        super(req);
    }

    /**
     * Do execute with result.
     * 
     * @param monitor
     *            the monitor
     * @param info
     *            the info
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated not
     */
    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        AssemblyContext newElement = CompositionFactory.eINSTANCE.createAssemblyContext();

        // InterfaceProvidingEntity owner = (InterfaceProvidingEntity) getElementToEdit();
        // owner.getProvidedRoles_InterfaceProvidingEntity().add(newElement);
        // Replaced previous lines with the following line:
        newElement.setParentStructure__AssemblyContext((ComposedStructure) getElementToEdit());

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }
}
