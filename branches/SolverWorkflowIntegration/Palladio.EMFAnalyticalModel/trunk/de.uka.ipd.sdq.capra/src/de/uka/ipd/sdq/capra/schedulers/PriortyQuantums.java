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
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriortyQuantums_Priority()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Number Of Quantums</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Quantums</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Quantums</em>' attribute.
	 * @see #setNumberOfQuantums(int)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriortyQuantums_NumberOfQuantums()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumberOfQuantums();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.PriortyQuantums#getNumberOfQuantums <em>Number Of Quantums</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Quantums</em>' attribute.
	 * @see #getNumberOfQuantums()
	 * @generated
	 */
	void setNumberOfQuantums(int value);

} // PriortyQuantums
