/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class RequiredDelegationConnectorTypeLinkCreateCommand extends
		CreateRelationshipCommand {

	/**
	 * @generated
	 */
	private ComposedStructure myContainer;

	/**
	 * @generated
	 */
	private RequiredRole mySource;

	/**
	 * @generated
	 */
	private RequiredRole myTarget;

	/**
	 * @generated
	 */
	public RequiredDelegationConnectorTypeLinkCreateCommand(
			CreateRelationshipRequest req, ComposedStructure container,
			RequiredRole source, RequiredRole target) {
		super(req);
		super.setElementToEdit(container);
		myContainer = container;
		mySource = source;
		myTarget = target;
	}

	/**
	 * @generated
	 */
	public ComposedStructure getContainer() {
		return myContainer;
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
		return CompositionPackage.eINSTANCE.getComposedStructure();
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated not
	 */
	protected EObject doDefaultElementCreation() {
		RequiredDelegationConnector newElement = (RequiredDelegationConnector) super
				.doDefaultElementCreation();
		if (newElement != null) {
			newElement
					.setOuterRequiredRole_RequiredDelegationConnector(myTarget);
			newElement
					.setInnerRequiredRole_RequiredDelegationConnector(mySource);
			CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
			newElement.setAssemblyContext_RequiredDelegationConnector((AssemblyContext) req.getParameter("CHILD_CONTEXT"));
		}
		return newElement;
	}

}
