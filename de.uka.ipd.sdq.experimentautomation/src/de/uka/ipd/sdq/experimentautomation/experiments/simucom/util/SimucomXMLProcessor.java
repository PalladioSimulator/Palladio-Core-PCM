/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom.util;

import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimucomPackage;

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
public class SimucomXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimucomXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		SimucomPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the SimucomResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new SimucomResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new SimucomResourceFactoryImpl());
		}
		return registrations;
	}

} //SimucomXMLProcessor
