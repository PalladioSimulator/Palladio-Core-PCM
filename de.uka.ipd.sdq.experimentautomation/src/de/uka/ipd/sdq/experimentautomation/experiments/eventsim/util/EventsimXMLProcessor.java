/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim.util;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventsimPackage;

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
public class EventsimXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsimXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		EventsimPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the EventsimResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new EventsimResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new EventsimResourceFactoryImpl());
		}
		return registrations;
	}

} //EventsimXMLProcessor
