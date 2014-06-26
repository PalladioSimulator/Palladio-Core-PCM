/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventsimFactoryImpl extends EFactoryImpl implements EventsimFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsimFactory init() {
		try {
			EventsimFactory theEventsimFactory = (EventsimFactory)EPackage.Registry.INSTANCE.getEFactory(EventsimPackage.eNS_URI);
			if (theEventsimFactory != null) {
				return theEventsimFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventsimFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsimFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventsimPackage.EVENT_SIM_CONFIGURATION: return createEventSimConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventSimConfiguration createEventSimConfiguration() {
		EventSimConfigurationImpl eventSimConfiguration = new EventSimConfigurationImpl();
		return eventSimConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsimPackage getEventsimPackage() {
		return (EventsimPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventsimPackage getPackage() {
		return EventsimPackage.eINSTANCE;
	}

} //EventsimFactoryImpl
