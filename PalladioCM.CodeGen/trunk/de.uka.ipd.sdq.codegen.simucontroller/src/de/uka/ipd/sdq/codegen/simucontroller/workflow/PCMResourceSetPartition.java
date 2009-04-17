package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.emf.ecore.resource.Resource;

import de.uka.ipd.sdq.pcm.repository.Repository;

public class PCMResourceSetPartition extends ResourceSetPartition {
	
	public Repository getRepository() {
		for (Resource r : this.rs.getResources()) {
			if (r.getContents().get(0) instanceof Repository) {
				return (Repository) r.getContents().get(0);
			}
		}
		return null;
	}
	
}
