package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

public class OutgoingAssemblyConnectorAdjuster implements ConnectorAdjuster {
	
	public OutgoingAssemblyConnectorAdjuster(AssemblyConnector connector,
			OperationRequiredRole role) {
		super();
		this.connector = connector;
		this.role = role;
	}

	private AssemblyConnector connector;
	private OperationRequiredRole role;

	@Override
	public void build() {
		this.connector.setRequiredRole_AssemblyConnector(role);
	}

}
