/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Characterisation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getDoubleCharacterisationValue()
 * @model
 * @generated
 */
public interface DoubleCharacterisationValue extends MeasuredCharacterisationValue {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#getDoubleCharacterisationValue_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

} // DoubleCharacterisationValue
