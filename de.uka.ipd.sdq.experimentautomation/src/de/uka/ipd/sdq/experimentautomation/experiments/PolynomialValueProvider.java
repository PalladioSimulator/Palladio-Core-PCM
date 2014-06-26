/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polynomial Value Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getExponent <em>Exponent</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getFactor <em>Factor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getPolynomialValueProvider()
 * @model
 * @generated
 */
public interface PolynomialValueProvider extends ValueProvider {
	/**
	 * Returns the value of the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exponent</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exponent</em>' attribute.
	 * @see #setExponent(double)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getPolynomialValueProvider_Exponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getExponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getExponent <em>Exponent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exponent</em>' attribute.
	 * @see #getExponent()
	 * @generated
	 */
	void setExponent(double value);

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
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getPolynomialValueProvider_Factor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.PolynomialValueProvider#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(double value);

} // PolynomialValueProvider
