package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

public class IncomingAssemblyConnectorAdjuster implements ConnectorAdjuster {
	
	public IncomingAssemblyConnectorAdjuster(AssemblyConnector connector,
			ProvidedRole role) {
		super();
		this.connector = connector;
		this.role = role;
	}

	private AssemblyConnector connector;
	private ProvidedRole role;

	@Override
	public void build() {
		this.connector.setProvidedRole_AssemblyConnector(role);
	}


}
