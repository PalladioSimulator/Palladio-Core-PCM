/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Interval Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getTo <em>To</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntegerIntervalRange()
 * @model
 * @generated
 */
public interface IntegerIntervalRange extends IntervalRange {
	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(int)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntegerIntervalRange_To()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getTo();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(int value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(int)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getIntegerIntervalRange_From()
	 * @model default="0" required="true" ordered="false"
	 * @generated
	 */
	int getFrom();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(int value);

} // IntegerIntervalRange
