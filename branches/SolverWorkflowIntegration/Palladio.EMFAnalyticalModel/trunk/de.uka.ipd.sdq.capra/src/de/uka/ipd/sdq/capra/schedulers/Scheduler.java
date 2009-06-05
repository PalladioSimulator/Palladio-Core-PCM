/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getAssignment <em>Assignment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getSelectionpolicy <em>Selectionpolicy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getTimeconsumption <em>Timeconsumption</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getLoadBalancing <em>Load Balancing</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler()
 * @model
 * @generated
 */
public interface Scheduler extends EObject {
	/**
	 * Returns the value of the '<em><b>Assignment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignment</em>' containment reference.
	 * @see #setAssignment(Assignment)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler_Assignment()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Assignment getAssignment();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getAssignment <em>Assignment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignment</em>' containment reference.
	 * @see #getAssignment()
	 * @generated
	 */
	void setAssignment(Assignment value);

	/**
	 * Returns the value of the '<em><b>Selectionpolicy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selectionpolicy</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selectionpolicy</em>' containment reference.
	 * @see #setSelectionpolicy(SelectionPolicy)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler_Selectionpolicy()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	SelectionPolicy getSelectionpolicy();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getSelectionpolicy <em>Selectionpolicy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selectionpolicy</em>' containment reference.
	 * @see #getSelectionpolicy()
	 * @generated
	 */
	void setSelectionpolicy(SelectionPolicy value);

	/**
	 * Returns the value of the '<em><b>Timeconsumption</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeconsumption</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeconsumption</em>' containment reference.
	 * @see #setTimeconsumption(TimeConsumption)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler_Timeconsumption()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeConsumption getTimeconsumption();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getTimeconsumption <em>Timeconsumption</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeconsumption</em>' containment reference.
	 * @see #getTimeconsumption()
	 * @generated
	 */
	void setTimeconsumption(TimeConsumption value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Load Balancing</b></em>' attribute.
	 * The default value is <code>"OnIdle"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.capra.schedulers.LoadBalancing}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Load Balancing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Load Balancing</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.LoadBalancing
	 * @see #setLoadBalancing(LoadBalancing)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getScheduler_LoadBalancing()
	 * @model default="OnIdle" required="true" ordered="false"
	 * @generated
	 */
	LoadBalancing getLoadBalancing();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Scheduler#getLoadBalancing <em>Load Balancing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Load Balancing</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.LoadBalancing
	 * @see #getLoadBalancing()
	 * @generated
	 */
	void setLoadBalancing(LoadBalancing value);

} // Scheduler
