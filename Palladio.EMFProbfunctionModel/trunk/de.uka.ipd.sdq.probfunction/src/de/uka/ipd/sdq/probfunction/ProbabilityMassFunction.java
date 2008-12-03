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
 *   <li>{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#isOrderedDomain <em>Ordered Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getProbabilityMassFunction()
 * @model
 * @generated
 */
public interface ProbabilityMassFunction extends ProbabilityFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Samples</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probfunction.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Samples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Samples</em>' containment reference list.
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getProbabilityMassFunction_Samples()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sample> getSamples();

	/**
	 * Returns the value of the '<em><b>Ordered Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Domain</em>' attribute.
	 * @see #setOrderedDomain(boolean)
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getProbabilityMassFunction_OrderedDomain()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isOrderedDomain();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probfunction.ProbabilityMassFunction#isOrderedDomain <em>Ordered Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered Domain</em>' attribute.
	 * @see #isOrderedDomain()
	 * @generated
	 */
	void setOrderedDomain(boolean value);

} // ProbabilityMassFunction
