/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

/**
 * @generated
 */
public class RequiredRoleTypeLinkCreateCommand extends
		CreateRelationshipCommand {

	/**
	 * @generated
	 */
	private InterfaceRequiringEntity mySource;

	/**
	 * @generated
	 */
	private Interface myTarget;

	/**
	 * @generated
	 */
	public RequiredRoleTypeLinkCreateCommand(CreateRelationshipRequest req,
			InterfaceRequiringEntity source, Interface target) {
		super(req);
		super.setElementToEdit(source);
		mySource = source;
		myTarget = target;
	}

	/**
	 * @generated
	 */
	public EObject getSource() {
		return mySource;
	}

	/**
	 * @generated
	 */
	public EObject getTarget() {
		return myTarget;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return EntityPackage.eINSTANCE.getInterfaceRequiringEntity();
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
	protected EObject doDefaultElementCreation() {
		RequiredRole newElement = (RequiredRole) super
				.doDefaultElementCreation();
		if (newElement != null) {
			newElement.setRequiredInterface__RequiredRole(myTarget);
		}
		return newElement;
	}

}
