/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

/**
 * @generated
 */
public class ProvidedRoleTypeLinkCreateCommand extends
		CreateRelationshipCommand {

	/**
	 * @generated
	 */
	private InterfaceProvidingEntity mySource;

	/**
	 * @generated
	 */
	private Interface myTarget;

	/**
	 * @generated
	 */
	public ProvidedRoleTypeLinkCreateCommand(CreateRelationshipRequest req,
			InterfaceProvidingEntity source, Interface target) {
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
		return EntityPackage.eINSTANCE.getInterfaceProvidingEntity();
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
		ProvidedRole newElement = (ProvidedRole) super
				.doDefaultElementCreation();
		if (newElement != null) {
			newElement.setProvidedInterface__ProvidedRole(myTarget);
		}
		return newElement;
	}

}
