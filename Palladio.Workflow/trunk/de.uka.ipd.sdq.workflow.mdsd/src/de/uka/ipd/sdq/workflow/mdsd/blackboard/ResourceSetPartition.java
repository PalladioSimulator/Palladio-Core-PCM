package de.uka.ipd.sdq.workflow.mdsd.blackboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
	private static final Logger logger = Logger.getLogger(ResourceSetPartition.class);
	
	protected ResourceSet rs = new ResourceSetImpl();
	
	/**
	 * @return Returns the internal used resource set of this blackboard partition
	 */
	public ResourceSet getResourceSet() {
		return rs;
	}
	
	/**
	 * Initialize the EPackages of the models to be stored in this blackboard partition
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
	 * @return The loaded resource
	 */
	public Resource loadModel(URI modelURI) {
		return rs.getResource(modelURI, true);
	}
	
	/**
	 * Returns all top level EObjects of the given model stored under the given URI. The model has to be
	 * created first and it has to have at least one top level element
	 * @param modelURI The model URI
	 * @return All top level elements of the model
	 */
	public List<EObject> getContents(URI modelURI) {
		Resource r = rs.getResource(modelURI, false);
		if (r == null) {
			throw new IllegalArgumentException("Model with URI "+modelURI+" must be loaded first");
		}
		if (r.getContents().size() == 0) {
			throw new IllegalArgumentException("Model does not contain any model elements yet");
		}
		return r.getContents();
	}

	/**
	 * Returns the first top level EObject of the given model stored under the given URI. The model has to be
	 * created first and it has to have at least one top level element
	 * @param modelURI The model URI
	 * @return The first top level element of the model
	 */
	public EObject getFirstContentElement(URI modelURI) {
		return getContents(modelURI).get(0);
	}
	
	/**
	 * Load the model with the given URI into this blackboard partition
	 * @param modelURI The URI of the model to be loaded
	 * @return The loaded resource
	 * @deprecated Use loadModel taking a URI instead
	 */
	@Deprecated
	public Resource loadModel(String modelURI) {
		Resource r;
		if (URI.createURI(modelURI).isPlatform() || modelURI.indexOf("://") >= 0) { 
			r = loadModel(URI.createURI(modelURI));
		} else {
			r = loadModel(URI.createFileURI(modelURI));
		}
		return r;
//BRG 07.12.09
//		java.util.Map<EObject,Collection<EStructuralFeature.Setting>> map = EcoreUtil.CrossReferencer.find(Collections.singleton(r.getContents().get(0)));
//		EcoreUtil.resolveAll(r);

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

	/**
	 * Replaces the contents of the given model with newContents
	 * @param modelID The model extent whose contents get replaced
	 * @param newContents The new contents
	 */
	public void setContents(URI modelID, List<EObject> newContents) {
		if (!hasModel(modelID)) {
			getResourceSet().createResource(modelID);
		}
		Resource r = getResourceSet().getResource(modelID, false);
		if (newContents != r.getContents()) {
			r.getContents().clear();
			r.getContents().addAll(newContents);
		}
	}

	public boolean hasModel(URI modelURI) {
		return rs.getResource(modelURI, false) != null;
	}

	public void storeAllResources() throws IOException {
		for (Resource r : rs.getResources()) {
			logger.debug("Save resource "+r.getURI());
			if (r.getURI().isFile()) {
				r.save(new HashMap());
			}
		}
	}
}
