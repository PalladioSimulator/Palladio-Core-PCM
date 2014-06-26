/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linear Value Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getSummand <em>Summand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getFactor <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getLinearValueProvider()
 * @model
 * @generated
 */
public interface LinearValueProvider extends ValueProvider {
	/**
	 * Returns the value of the '<em><b>Summand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Summand</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Summand</em>' attribute.
	 * @see #setSummand(double)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getLinearValueProvider_Summand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getSummand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getSummand <em>Summand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Summand</em>' attribute.
	 * @see #getSummand()
	 * @generated
	 */
	void setSummand(double value);

	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see #setFactor(double)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getLinearValueProvider_Factor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.LinearValueProvider#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(double value);

} // LinearValueProvider
