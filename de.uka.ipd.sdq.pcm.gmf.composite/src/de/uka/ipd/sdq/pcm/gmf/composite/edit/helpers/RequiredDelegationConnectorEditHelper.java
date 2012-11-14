/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * The Class RequiredDelegationConnectorEditHelper.
 *
 * @generated not
 */
public class RequiredDelegationConnectorEditHelper extends
		PalladioComponentModelBaseEditHelper {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		RequiredDelegationConnector con = (RequiredDelegationConnector) req
				.getElementToConfigure();
		String name = "ReqDelegation ";
		name += con.getInnerRequiredRole_RequiredDelegationConnector() == null ? ""
				: con.getInnerRequiredRole_RequiredDelegationConnector()
						.getEntityName();
		name += " -> ";
		name += con.getOuterRequiredRole_RequiredDelegationConnector() == null ? ""
				: con.getOuterRequiredRole_RequiredDelegationConnector()
						.getEntityName();

		ICommand cmd2 = new SetValueCommand(new SetRequest(req
				.getElementToConfigure(), EntityPackage.eINSTANCE
				.getNamedElement_EntityName(), name));
		return cmd2;
	}
}