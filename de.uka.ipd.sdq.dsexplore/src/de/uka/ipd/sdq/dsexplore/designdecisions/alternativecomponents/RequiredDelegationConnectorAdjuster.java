package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

public class RequiredDelegationConnectorAdjuster implements ConnectorAdjuster {
	
	public RequiredDelegationConnectorAdjuster(
			RequiredDelegationConnector connector, OperationRequiredRole role) {
		super();
		this.connector = connector;
		this.role = role;
	}

	private RequiredDelegationConnector connector;
	private OperationRequiredRole role;

	@Override
	public void build() {
		connector.setInnerRequiredRole_RequiredDelegationConnector(role);

	}

}
