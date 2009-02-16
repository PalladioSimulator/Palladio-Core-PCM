/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.commands;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class VariableCharacterisationCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public VariableCharacterisationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return ParameterPackage.eINSTANCE.getVariableUsage();
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

}
