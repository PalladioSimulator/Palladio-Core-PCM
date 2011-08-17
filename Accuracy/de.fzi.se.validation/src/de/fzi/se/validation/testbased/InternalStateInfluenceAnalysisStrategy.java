/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal State Influence Analysis Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality <em>Tb Validation Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getInternalStateInfluenceAnalysisStrategy()
 * @model abstract="true"
 * @generated
 */
public interface InternalStateInfluenceAnalysisStrategy extends EObject {
	/**
	 * Returns the value of the '<em><b>Tb Validation Quality</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tb Validation Quality</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tb Validation Quality</em>' container reference.
	 * @see #setTbValidationQuality(TBValidationQuality)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getInternalStateInfluenceAnalysisStrategy_TbValidationQuality()
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getInternalStateInfluenceAnalysisStrategy
	 * @model opposite="internalStateInfluenceAnalysisStrategy" required="true" transient="false" ordered="false"
	 * @generated
	 */
	TBValidationQuality getTbValidationQuality();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy#getTbValidationQuality <em>Tb Validation Quality</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tb Validation Quality</em>' container reference.
	 * @see #getTbValidationQuality()
	 * @generated
	 */
	void setTbValidationQuality(TBValidationQuality value);

} // InternalStateInfluenceAnalysisStrategy
