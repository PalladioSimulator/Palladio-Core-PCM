package de.uka.ipd.sdq.workflow.mdsd.blackboard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Implementation of a blackboard partition based on EMF Resource Sets. Each partition has
 * a resource set configured for the given EPackages. It can load a set of model resources. 
 * Inter-Model links are resolved up to the boundaries of the underlying resource set
 * @author Steffen Becker
 */
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
		Resource r;
		if (modelURI.indexOf("://") >= 0) { 
			r = rs.getResource(URI.createURI(modelURI), true);
		} else {
			r = rs.getResource(URI.createFileURI(modelURI), true);
		}
		EcoreUtil.resolveAll(r);
	}

	public void resolveAllProxies() {
		for (Resource r : this.rs.getResources()) {
			EcoreUtil.resolveAll(r);
		}
	}
}
