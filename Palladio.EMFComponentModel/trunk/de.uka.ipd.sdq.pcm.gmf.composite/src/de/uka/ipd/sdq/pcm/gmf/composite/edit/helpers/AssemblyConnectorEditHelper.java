/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * @generated not
 */
public class AssemblyConnectorEditHelper extends
		PalladioComponentModelBaseEditHelper {

	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		AssemblyConnector con = (AssemblyConnector) req.getElementToConfigure();
		String name = "Connector ";
		name += con.getRequiringChildComponentContext_CompositeAssemblyConnector() == null ? "" : 
			con.getRequiringChildComponentContext_CompositeAssemblyConnector().getEntityName();
		name += " -> ";
		name += con.getProvidingChildComponentContext_CompositeAssemblyConnector() == null ? "" : 
			con.getProvidingChildComponentContext_CompositeAssemblyConnector().getEntityName();
		
		ICommand cmd2 = new SetValueCommand(
				new SetRequest(
						req.getElementToConfigure(), 
						EntityPackage.eINSTANCE.getNamedElement_EntityName(),
						name));
		return cmd2;
	}
	
}