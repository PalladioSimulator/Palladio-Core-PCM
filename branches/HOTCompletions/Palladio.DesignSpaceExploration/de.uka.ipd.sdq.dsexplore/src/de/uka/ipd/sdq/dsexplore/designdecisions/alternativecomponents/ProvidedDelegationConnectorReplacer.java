package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;

public class ProvidedDelegationConnectorReplacer implements ConnectorAdjuster {
	
	public ProvidedDelegationConnectorReplacer(
			ProvidedDelegationConnector connector, ProvidedRole role) {
		super();
		this.connector = connector;
		this.role = role;
	}


	private ProvidedDelegationConnector connector;
	private ProvidedRole role;


	@Override
	public void build() {
		connector.setInnerProvidedRole_ProvidedDelegationConnector(role);
	}

}
