package de.uka.ipd.sdq.simucomframework.resources;

public interface IResourceContainerFactory {
	String[] getResourceContainerIDList();
	void fillResourceContainer(SimulatedResourceContainer container);
	String[] getLinkingResourceContainerIDList();
	void fillLinkingResourceContainer(SimulatedLinkingResourceContainer container);
}
