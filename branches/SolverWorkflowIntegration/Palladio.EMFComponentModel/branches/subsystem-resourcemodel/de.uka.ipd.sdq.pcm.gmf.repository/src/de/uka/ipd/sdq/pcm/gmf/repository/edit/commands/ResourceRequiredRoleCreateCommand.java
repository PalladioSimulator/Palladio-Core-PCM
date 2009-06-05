/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;

/**
 * @generated
 */
public class ResourceRequiredRoleCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	public ResourceRequiredRoleCreateCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(EntityPackage.eINSTANCE
					.getResourceInterfaceRequiringEntity_ResourceRequiredRoles_ResourceInterfaceRequiringEntity());
		}

		super.setElementToEdit(source);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null
				&& !(source instanceof ResourceInterfaceRequiringEntity)) {
			return false;
		}
		if (target != null && !(target instanceof ResourceInterface)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateResourceRequiredRole_4106(getSource(), getTarget());
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		// de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole newElement = (de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole) super.doDefaultElementCreation();
		ResourceRequiredRole newElement = ResourcetypeFactory.eINSTANCE
				.createResourceRequiredRole();
		getSource().getResourceRequiredRoles_ResourceInterfaceRequiringEntity()
				.add(newElement);
		newElement
				.setRequiredResourceInterface_ResourceRequiredRole(getTarget());
		return newElement;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return EntityPackage.eINSTANCE.getResourceInterfaceRequiringEntity();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected ResourceInterfaceRequiringEntity getSource() {
		return (ResourceInterfaceRequiringEntity) source;
	}

	/**
	 * @generated
	 */
	protected ResourceInterface getTarget() {
		return (ResourceInterface) target;
	}
}
