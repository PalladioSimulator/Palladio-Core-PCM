/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probfunction;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boxed PDF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probfunction.BoxedPDF#getSamples <em>Samples</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getBoxedPDF()
 * @model
 * @generated
 */
public interface BoxedPDF extends ProbabilityDensityFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Samples</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probfunction.ContinuousSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Samples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Samples</em>' containment reference list.
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getBoxedPDF_Samples()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ContinuousSample> getSamples();

} // BoxedPDF
