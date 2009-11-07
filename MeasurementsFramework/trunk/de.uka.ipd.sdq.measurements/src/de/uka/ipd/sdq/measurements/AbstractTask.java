/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.AbstractTask#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.AbstractTask#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getAbstractTask()
 * @model abstract="true"
 * @generated
 */
public interface AbstractTask extends Identifier {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getAbstractTask_Description()
	 * @model ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.AbstractTask#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getAbstractTask_Name()
	 * @model ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.AbstractTask#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AbstractTask
