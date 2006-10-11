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
 * A representation of the model object '<em><b>Probability Mass Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#getSamples <em>Samples</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.probfunctionPackage#getProbabilityMassFunction()
 * @model
 * @generated
 */
public interface ProbabilityMassFunction extends ProbabilityFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright by SDQ U Karlsruhe (TH) 2006";

	/**
	 * Returns the value of the '<em><b>Samples</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probfunction.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Samples</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Samples</em>' reference list.
	 * @see de.uka.ipd.sdq.probfunction.probfunctionPackage#getProbabilityMassFunction_Samples()
	 * @model type="de.uka.ipd.sdq.probfunction.Sample"
	 * @generated
	 */
	EList getSamples();

} // ProbabilityMassFunction