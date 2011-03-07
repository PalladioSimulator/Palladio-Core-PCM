/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Calculator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.BinaryCalculator#getProbeSet <em>Probe Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probespec.probespecPackage#getBinaryCalculator()
 * @model abstract="true"
 * @generated
 */
public interface BinaryCalculator extends Calculator {
	/**
	 * Returns the value of the '<em><b>Probe Set</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probespec.ProbeSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Set</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Set</em>' containment reference list.
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#getBinaryCalculator_ProbeSet()
	 * @model containment="true" lower="2" upper="2" ordered="false"
	 * @generated
	 */
	EList<ProbeSet> getProbeSet();

} // BinaryCalculator
