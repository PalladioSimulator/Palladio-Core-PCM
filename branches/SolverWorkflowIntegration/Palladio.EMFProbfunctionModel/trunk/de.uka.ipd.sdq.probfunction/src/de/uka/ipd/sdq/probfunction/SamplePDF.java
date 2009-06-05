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
 * A representation of the model object '<em><b>Sample PDF</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probfunction.SamplePDF#getDistance <em>Distance</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probfunction.SamplePDF#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getSamplePDF()
 * @model
 * @generated
 */
public interface SamplePDF extends ProbabilityDensityFunction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getSamplePDF_Distance()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.probfunction.SamplePDF#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.probfunction.Complex}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see de.uka.ipd.sdq.probfunction.ProbfunctionPackage#getSamplePDF_Values()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Complex> getValues();

} // SamplePDF
