/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simcomp.util;

import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimcompPackage;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SimcompXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimcompXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		SimcompPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the SimcompResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new SimcompResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new SimcompResourceFactoryImpl());
		}
		return registrations;
	}

} //SimcompXMLProcessor
