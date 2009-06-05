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
 * A representation of the model object '<em><b>Priorty Quantums</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getPriority <em>Priority</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getNumberOfQuantums <em>Number Of Quantums</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriortyQuantums()
 * @model
 * @generated
 */
public interface PriortyQuantums extends EObject {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' reference.
	 * @see #setPriority(EObject)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriortyQuantums_Priority()
	 * @model required="true"
	 * @generated
	 */
	EObject getPriority();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getPriority <em>Priority</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' reference.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(EObject value);

	/**
	 * Returns the value of the '<em><b>Number Of Quantums</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Quantums</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Quantums</em>' reference.
	 * @see #setNumberOfQuantums(EObject)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriortyQuantums_NumberOfQuantums()
	 * @model required="true"
	 * @generated
	 */
	EObject getNumberOfQuantums();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getNumberOfQuantums <em>Number Of Quantums</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Quantums</em>' reference.
	 * @see #getNumberOfQuantums()
	 * @generated
	 */
	void setNumberOfQuantums(EObject value);

} // PriortyQuantums
