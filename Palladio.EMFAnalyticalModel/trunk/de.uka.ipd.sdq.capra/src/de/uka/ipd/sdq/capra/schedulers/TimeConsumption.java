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
 * A representation of the model object '<em><b>Time Consumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getTime <em>Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getScaling <em>Scaling</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getTimeConsumption()
 * @model
 * @generated
 */
public interface TimeConsumption extends EObject {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(double)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getTimeConsumption_Time()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(double value);

	/**
	 * Returns the value of the '<em><b>Scaling</b></em>' attribute.
	 * The default value is <code>"Constant"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.capra.schedulers.BigOClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scaling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scaling</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.BigOClass
	 * @see #setScaling(BigOClass)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getTimeConsumption_Scaling()
	 * @model default="Constant" required="true" ordered="false"
	 * @generated
	 */
	BigOClass getScaling();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.TimeConsumption#getScaling <em>Scaling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scaling</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.BigOClass
	 * @see #getScaling()
	 * @generated
	 */
	void setScaling(BigOClass value);

} // TimeConsumption