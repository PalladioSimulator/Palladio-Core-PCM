package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import java.util.ArrayList;
import java.util.List;

public class ComponentReplacer {
	
	private List<ConnectorAdjuster> connectorAdjusters;

	public ComponentReplacer(){
		this.connectorAdjusters = new ArrayList<ConnectorAdjuster>();
	}
	
	public void addConnectorAdjuster(ConnectorAdjuster ca){
		this.connectorAdjusters.add(ca);
	}
	
	public void replace(){
		for (ConnectorAdjuster connectorAdjuster : connectorAdjusters) {
			connectorAdjuster.build();
		}
	}

	public void addAllConnectorAdjuster(List<ConnectorAdjuster> cas) {
		if (cas != null){
			this.connectorAdjusters.addAll(cas);
		}
		
	}

}
