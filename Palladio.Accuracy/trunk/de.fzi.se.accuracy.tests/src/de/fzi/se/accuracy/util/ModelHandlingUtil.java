/**
 *
 */
package de.fzi.se.accuracy.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**Utility class for loading and storing EMF model instance which reference each other.
 * @author groenda
 *
 */
public class ModelHandlingUtil {
	/** Logger of this class. */
	private static final Logger logger = Logger.getLogger(ModelHandlingUtil.class.getCanonicalName());
	/** ResourceSet used to access the EMF files. */
	protected static final ResourceSet resourceSet = new ResourceSetImpl();

	/**Helper method for stand-alone operation which initializes all necessary packages and factories for XML file access at the provided resource set.
	 * @param resourceSet The resource set for which the factories are initialized.
	 */
	public static void initializeEmfFactories(ResourceSet resourceSet) {
		// PCM packages
		RepositoryPackage.eINSTANCE.eClass();
		// Validation packages
		ParametersPackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();
		QualityAnnotationPackage.eINSTANCE.eClass();

		// PCM packages
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("repository", new XMIResourceFactoryImpl());
		// Validation packages
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("parameters", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pcm", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("qualityannotation", new XMIResourceFactoryImpl());

		// Fallback
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
	}

	/**Helper method for stand-alone operation which initializes all necessary EMF Factories at the resource set of this class.
	 */
	public static void initializeEmfFactories() {
		initializeEmfFactories(resourceSet);
	}

	/**Load the root element from a XMI file using the resource set of this class.
	 * @param relativePath Path to the file.
	 * @return The root element. <code>null</code> if the file does not exist.
	 */
	public static EObject loadFromFile(final String relativePath) {
		return loadFromFile(resourceSet, relativePath);
	}

	/**Load the root element from a XMI file.
	 * @param resourceSet The resource set to use for loading.
	 * @param relativePath Path to the file.
	 * @return The root element. <code>null</code> if the file does not exist.
	 */
	public static EObject loadFromFile(final ResourceSet resourceSet, final String relativePath) {
		File file = new File(relativePath);
		String path = file.getAbsolutePath();
		if (!file.exists()) {
			return null;
		}
		Resource resource = resourceSet.getResource(URI.createFileURI(path),
				true);
		// resolve the content of all resources until no new resources are found
		ArrayList<Resource> currentResources = null;
		do {
			// Copy list to avoid concurrent modification exceptions
			currentResources = new ArrayList<Resource>(resourceSet.getResources());
			for (Resource r : currentResources) {
				EcoreUtil.resolveAll(r);
			}
		} while (currentResources.size() != resourceSet.getResources().size());
		if (resource.getContents().size() != 1) {
			throw new IllegalStateException("Loaded XMI file must only contain one root element.");
		}
		boolean errors = false;
		for (Resource rsc : resourceSet.getResources()) {
			if (rsc.getErrors().size() != 0) {
				for (org.eclipse.emf.ecore.resource.Resource.Diagnostic diag : rsc.getErrors()) {
					if (diag.getMessage().equals("java.net.MalformedURLException: unknown protocol: pathmap")) {
						// ignore message
					} else {
						logger.log(Level.SEVERE, diag.getLocation() + "(" + diag.getLine() + "," + diag.getColumn() + "): " + diag.getMessage());
						errors = true;
					}
				}
			}
			if (rsc.getWarnings().size() != 0) {
				for (org.eclipse.emf.ecore.resource.Resource.Diagnostic diag : rsc.getWarnings()) {
					logger.log(Level.WARNING, diag.getLocation() + "(" + diag.getLine() + "," + diag.getColumn() + "): " + diag.getMessage());
					errors = true;
				}
			}
		}
		if (errors) {
			throw new IllegalStateException("Loading of EMF resources failed. Errors were written to log. A consistent state cannot be ensured.");
		}
		return resource.getContents().get(0);
	}

	/**Saves a root element to a XMI file using the resource set of this class.
	 * @param relativePath Path to the file. If it is <code>null</code> than a temporary file is created.
	 * @param eObject The root element.
	 */
	public static void saveToFile(final String relativePath, final EObject eObject) {
		saveToFile(resourceSet, relativePath, eObject);
	}

	/**Saves a root element to a XMI file.
	 * @param resourceSet The resource set to use for saving.
	 * @param relativePath Path to the file. If it is <code>null</code> than a temporary file is created.
	 * @param eObject The root element.
	 */
	public static void saveToFile(final ResourceSet resourceSet, final String relativePath, final EObject eObject) {
		try {
			File file;
			if (relativePath == null) {
				file = File.createTempFile("ModelComparison", ".xmi");
			} else {
				file = new File(relativePath);
			}
			String path = file.getAbsolutePath();
			Resource resource = resourceSet.createResource(URI.createFileURI(path));
			resource.getContents().add(eObject);
			resource.save(null);
		} catch (IOException e) {
			String msg = "Could not store model in file.";
			logger.log(Level.SEVERE, msg, e);
			throw new IllegalStateException(msg, e);
		}
	}
}
