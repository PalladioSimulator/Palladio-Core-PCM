/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Calculator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.UnaryCalculator#getProbeSet <em>Probe Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probespec.probespecPackage#getUnaryCalculator()
 * @model abstract="true"
 * @generated
 */
public interface UnaryCalculator extends Calculator {
	/**
	 * Returns the value of the '<em><b>Probe Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Set</em>' containment reference.
	 * @see #setProbeSet(ProbeSet)
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getUnaryCalculator_ProbeSet()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ProbeSet getProbeSet();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probespec.UnaryCalculator#getProbeSet <em>Probe Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Set</em>' containment reference.
	 * @see #getProbeSet()
	 * @generated
	 */
	void setProbeSet(ProbeSet value);

} // UnaryCalculator
