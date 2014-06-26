/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Value Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getSetValueProvider()
 * @model
 * @generated
 */
public interface SetValueProvider extends ValueProvider {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute.
	 * @see #setValues(String)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getSetValueProvider_Values()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getValues();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.SetValueProvider#getValues <em>Values</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Values</em>' attribute.
	 * @see #getValues()
	 * @generated
	 */
	void setValues(String value);

} // SetValueProvider
