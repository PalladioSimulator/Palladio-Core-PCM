package de.uka.ipd.sdq.measurements.configurator;

import java.security.AccessControlException;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;

public class MeasurementScriptHelper {
	
	private static Logger logger = Logger.getLogger(MeasurementScriptHelper.class);

	public static MeasurementScript loadMeasurementScript(String filePath) {
		try {
			MeasurementsPackage.eINSTANCE.eClass();
		} catch (Throwable e) {
			if (e.getCause() != null) {
				if (e.getCause().getClass()
						.equals(AccessControlException.class)) {
					logger.error("Access control exception during EMF intialization. Check policy file.");
				}
				return null;
			}
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("workloadscript", new XMIResourceFactoryImpl());
		URI fileURI = URI.createFileURI(filePath);
		Resource resource = null;
		try {
			resource = resourceSet.getResource(fileURI, true);
		} catch (RuntimeException e) {
			e.printStackTrace();
			logger.error("Failed to load resource for file " + fileURI.path());
			return null;
		}

		EList<EObject> objects = resource.getContents();
		if ((objects == null) || (objects.size() < 1)) {
			logger
					.error("Failed to load measruement script element from EMF resource.");
			return null;
		}
		MeasurementScript measurementScript = null;
		try {
			measurementScript = (MeasurementScript) objects.get(0);
		} catch (ClassCastException e) {
			logger
					.error("Failed to load MeasurementScript element from EMF resource.");
			return null;
		}

		return measurementScript;
		
	}
	
}
