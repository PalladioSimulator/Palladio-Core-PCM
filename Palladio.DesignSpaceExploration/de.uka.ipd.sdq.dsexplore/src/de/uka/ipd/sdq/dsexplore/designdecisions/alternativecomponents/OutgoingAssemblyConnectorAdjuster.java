package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public class OutgoingAssemblyConnectorAdjuster implements ConnectorAdjuster {
	
	private AssemblyConnector connector;
	private RequiredRole role;

	@Override
	public void build() {
		this.connector.setRequiredRole_AssemblyConnector(role);
	}

}
