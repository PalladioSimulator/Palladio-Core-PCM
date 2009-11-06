/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements.scheduler.util;

import java.util.Map;

import measurements.scheduler.SchedulerPackage;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		SchedulerPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the SchedulerResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new SchedulerResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new SchedulerResourceFactoryImpl());
		}
		return registrations;
	}

} //SchedulerXMLProcessor
