/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exponential Value Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExponentialValueProvider()
 * @model
 * @generated
 */
public interface ExponentialValueProvider extends ValueProvider {
	/**
	 * Returns the value of the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' attribute.
	 * @see #setBase(double)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getExponentialValueProvider_Base()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getBase();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.ExponentialValueProvider#getBase <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' attribute.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(double value);

} // ExponentialValueProvider
