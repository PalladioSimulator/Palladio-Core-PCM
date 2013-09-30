/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ComposedProvidingRequiringEntityCreateCommand;
import de.uka.ipd.sdq.pcm.system.SystemFactory;

/**
 * The Class CustomComposedProvidingRequiringEntityCreateCommand.
 */
public class CustomComposedProvidingRequiringEntityCreateCommand extends ComposedProvidingRequiringEntityCreateCommand {

    /**
     * Instantiates a new custom composed providing requiring entity create command.
     * 
     * @param req
     *            the req
     */
    public CustomComposedProvidingRequiringEntityCreateCommand(CreateElementRequest req) {
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
     * @generated NOT
     */
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
        // Uncomment to put "phantom" objects into the diagram file.
        // org.eclipse.emf.ecore.resource.Resource resource =
        // ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
        // getRequest()).getContainer().eResource();
        // if (resource == null) {
        // return null;
        // }
        Resource resource = getElementToEdit().eResource();

        // ComposedProvidingRequiringEntity newElement =
        // EntityFactory.eINSTANCE.createComposedProvidingRequiringEntity();
        // Replaced the previous line with the following line:
        ComposedProvidingRequiringEntity newElement = SystemFactory.eINSTANCE.createSystem();

        resource.getContents().add(newElement);

        doConfigure(newElement, monitor, info);

        ((CreateElementRequest) getRequest()).setNewElement(newElement);
        return CommandResult.newOKCommandResult(newElement);
    }
}
