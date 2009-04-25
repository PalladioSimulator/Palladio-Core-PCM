package de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public class ComponentReplacer {
	
	private List<ConnectorAdjuster> connectorAdjuster;

	private Map<ProvidedRole, ProvidedRole> providedMapping;
	private Map<RequiredRole, RequiredRole> requiredMapping;

	public ComponentReplacer(
			Map<ProvidedRole, ProvidedRole> providedMapping,
			Map<RequiredRole, RequiredRole> requiredMapping) {
		this.providedMapping = providedMapping;
		this.requiredMapping = requiredMapping;
	}

	public Map<ProvidedRole, ProvidedRole> getProvidedMapping() {
		return providedMapping;
	}

	public void setProvidedMapping(Map<ProvidedRole, ProvidedRole> providedMapping) {
		this.providedMapping = providedMapping;
	}

	public Map<RequiredRole, RequiredRole> getRequiredMapping() {
		return requiredMapping;
	}

	public void setRequiredMapping(Map<RequiredRole, RequiredRole> requiredMapping) {
		this.requiredMapping = requiredMapping;
	}
	
	public void replace(){
		
	}

}
