/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.eventsim;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventsimPackage
 * @generated
 */
public interface EventsimFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsimFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.eventsim.impl.EventsimFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Event Sim Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Sim Configuration</em>'.
	 * @generated
	 */
	EventSimConfiguration createEventSimConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventsimPackage getEventsimPackage();

} //EventsimFactory
