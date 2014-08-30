/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands;

/**
 * @generated
 */
public class ResourceContainerCreateCommand extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {

		/**
 * @generated
 */
	public ResourceContainerCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

		/**
 * FIXME: replace with setElementToEdit()
 * @generated
 */
protected org.eclipse.emf.ecore.EObject getElementToEdit() {
	org.eclipse.emf.ecore.EObject container = ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer();
	if (container instanceof org.eclipse.gmf.runtime.notation.View) {
		container = ((org.eclipse.gmf.runtime.notation.View) container).getElement();
	}
	return container;
}

		/**
 * @generated
 */
	public boolean canExecute() {
		return true;
	}

		/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
			// Uncomment to put "phantom" objects into the diagram file.		
	// org.eclipse.emf.ecore.resource.Resource resource = 
	// 		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer().eResource();
	// if (resource == null) {
	// 	return null;
	// }
	org.eclipse.emf.ecore.resource.Resource resource = getElementToEdit().eResource();
	de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer newElement = de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory.eINSTANCE.createResourceContainer();

	resource.getContents().add(newElement);


		
		doConfigure(newElement, monitor, info);

		((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).setNewElement(newElement);
		return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(newElement);
	}


		/**
 * @generated
 */
	protected void doConfigure(de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer newElement, org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
		org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = ((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getElementType();
		org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest configureRequest = new org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		org.eclipse.gmf.runtime.common.core.command.ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
	
}
