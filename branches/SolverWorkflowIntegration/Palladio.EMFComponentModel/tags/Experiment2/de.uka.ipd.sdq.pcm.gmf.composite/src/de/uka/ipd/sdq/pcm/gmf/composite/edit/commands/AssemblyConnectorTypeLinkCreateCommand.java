/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class AssemblyConnectorTypeLinkCreateCommand extends
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
	private ProvidedRole myTarget;

	/**
	 * @generated
	 */
	public AssemblyConnectorTypeLinkCreateCommand(
			CreateRelationshipRequest req, ComposedStructure container,
			RequiredRole source, ProvidedRole target) {
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
		AssemblyConnector newElement = (AssemblyConnector) super
				.doDefaultElementCreation();
		if (newElement != null) {
			newElement.setProvidedRole_CompositeAssemblyConnector(myTarget);
			newElement.setRequiredRole_CompositeAssemblyConnector(mySource);
			CreateRelationshipRequest req = (CreateRelationshipRequest) this.getRequest();
			newElement.setRequiringChildComponentContext_CompositeAssemblyConnector((AssemblyContext) req.getParameter("REQ_CHILD_CONTEXT"));
			newElement.setProvidingChildComponentContext_CompositeAssemblyConnector((AssemblyContext) req.getParameter("PROV_CHILD_CONTEXT"));
		}
		return newElement;
	}

}
