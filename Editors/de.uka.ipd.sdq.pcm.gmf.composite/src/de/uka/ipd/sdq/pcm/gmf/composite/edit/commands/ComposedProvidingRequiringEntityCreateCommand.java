/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity;
import de.uka.ipd.sdq.pcm.system.SystemFactory;

/**
 * The Class ComposedProvidingRequiringEntityCreateCommand.
 *
 * @generated
 */
public class ComposedProvidingRequiringEntityCreateCommand extends
		EditElementCommand {

	/**
	 * Instantiates a new composed providing requiring entity create command.
	 *
	 * @param req the req
	 * @generated
	 */
	public ComposedProvidingRequiringEntityCreateCommand(
			CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit().
	 *
	 * @return the element to edit
	 * @generated
	 */
	@Override
    protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * Can execute.
	 *
	 * @return true, if successful
	 * @generated
	 */
	@Override
    public boolean canExecute() {
		return true;
	}

	/**
	 * Do execute with result.
	 *
	 * @param monitor the monitor
	 * @param info the info
	 * @return the command result
	 * @throws ExecutionException the execution exception
	 * @generated NOT
	 */
	@Override
    protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		// Uncomment to put "phantom" objects into the diagram file.
		// org.eclipse.emf.ecore.resource.Resource resource =
		// ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest)
		// getRequest()).getContainer().eResource();
		// if (resource == null) {
		// return null;
		// }
		Resource resource = getElementToEdit().eResource();
		ComposedProvidingRequiringEntity newElement = SystemFactory.eINSTANCE
				.createSystem();

		resource.getContents().add(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * Do configure.
	 *
	 * @param newElement the new element
	 * @param monitor the monitor
	 * @param info the info
	 * @throws ExecutionException the execution exception
	 * @generated
	 */
	protected void doConfigure(ComposedProvidingRequiringEntity newElement,
			IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest())
				.getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(
				getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest())
				.getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType
				.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

}
