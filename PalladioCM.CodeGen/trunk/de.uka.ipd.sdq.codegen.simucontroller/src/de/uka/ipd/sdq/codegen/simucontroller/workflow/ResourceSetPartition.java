package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class ResourceSetPartition {
	protected ResourceSet rs = new ResourceSetImpl();
	
	public ResourceSet getResourceSet() {
		return rs;
	}
	
	public void initialiseResourceSetEPackages(EPackage[] ePackages) {
		for (EPackage ePackage : ePackages) {
			rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		}
	}
	
	public void loadModel(String modelURI) {
		if (modelURI.indexOf("://") >= 0) { 
			rs.getResource(URI.createURI(modelURI), true);
		} else {
			rs.getResource(URI.createFileURI(modelURI), true);
		}
	}
}
