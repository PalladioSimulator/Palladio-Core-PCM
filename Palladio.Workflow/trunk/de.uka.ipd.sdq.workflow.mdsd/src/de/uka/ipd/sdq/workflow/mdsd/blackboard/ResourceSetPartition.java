package de.uka.ipd.sdq.workflow.mdsd.blackboard;

import java.util.ArrayList;

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
	
	/**
	 * @return Returns the internal used resource set of this blackboard partition
	 */
	public ResourceSet getResourceSet() {
		return rs;
	}
	
	/**
	 * Initialise the EPackages of the models to be stored in this blackboard partition
	 * @param ePackages The list of EPackages which form the meta-model of the model stored in this model partition
	 */
	public void initialiseResourceSetEPackages(EPackage[] ePackages) {
		for (EPackage ePackage : ePackages) {
			rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		}
	}
	
	/**
	 * Load the model with the given URI into this blackboard partition
	 * @param modelURI The URI of the model to be loaded
	 */
	public void loadModel(String modelURI) {
		Resource r;
		if (URI.createURI(modelURI).isPlatform() || modelURI.indexOf("://") >= 0) { 
			r = rs.getResource(URI.createURI(modelURI), true);
		} else {
			r = rs.getResource(URI.createFileURI(modelURI), true);
		}
		EcoreUtil.resolveAll(r);
	}

	/**
	 * Resolve all model proxies, i.e., load all dependent models
	 */
	public void resolveAllProxies() {
		ArrayList<Resource> currentResources = null; 
		do {
			// Copy list to avoid concurrent modification exceptions
			currentResources = new ArrayList<Resource>(this.rs.getResources());
			for (Resource r : currentResources) {
				EcoreUtil.resolveAll(r);
			}
		} while (currentResources.size() != this.rs.getResources().size());
	}
}
