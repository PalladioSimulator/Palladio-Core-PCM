/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage
 * @generated
 */
public interface SchedulersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulersFactory eINSTANCE = de.uka.ipd.sdq.capra.schedulers.impl.SchedulersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scheduler</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduler</em>'.
	 * @generated
	 */
	Scheduler createScheduler();

	/**
	 * Returns a new object of class '<em>Time Consumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Consumption</em>'.
	 * @generated
	 */
	TimeConsumption createTimeConsumption();

	/**
	 * Returns a new object of class '<em>Non Preemptive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Preemptive</em>'.
	 * @generated
	 */
	NonPreemptive createNonPreemptive();

	/**
	 * Returns a new object of class '<em>Preemptive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Preemptive</em>'.
	 * @generated
	 */
	Preemptive createPreemptive();

	/**
	 * Returns a new object of class '<em>Quantum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quantum</em>'.
	 * @generated
	 */
	Quantum createQuantum();

	/**
	 * Returns a new object of class '<em>Waiting Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Waiting Time</em>'.
	 * @generated
	 */
	WaitingTime createWaitingTime();

	/**
	 * Returns a new object of class '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority</em>'.
	 * @generated
	 */
	Priority createPriority();

	/**
	 * Returns a new object of class '<em>Priorty Quantums</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priorty Quantums</em>'.
	 * @generated
	 */
	PriortyQuantums createPriortyQuantums();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SchedulersPackage getSchedulersPackage();

} //SchedulersFactory
