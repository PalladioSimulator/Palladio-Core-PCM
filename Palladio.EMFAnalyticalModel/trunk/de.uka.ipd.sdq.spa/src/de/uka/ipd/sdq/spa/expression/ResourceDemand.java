/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

import de.uka.ipd.sdq.spa.resource.ProcessingResource;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.ResourceDemand#getPdf <em>Pdf</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.ResourceDemand#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getResourceDemand()
 * @model
 * @generated
 */
public interface ResourceDemand extends EObject {
	/**
	 * Returns the value of the '<em><b>Pdf</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pdf</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pdf</em>' containment reference.
	 * @see #setPdf(ProbabilityDensityFunction)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getResourceDemand_Pdf()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProbabilityDensityFunction getPdf();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.ResourceDemand#getPdf <em>Pdf</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pdf</em>' containment reference.
	 * @see #getPdf()
	 * @generated
	 */
	void setPdf(ProbabilityDensityFunction value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(ProcessingResource)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getResourceDemand_Resource()
	 * @model required="true"
	 * @generated
	 */
	ProcessingResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.ResourceDemand#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(ProcessingResource value);

} // ResourceDemand