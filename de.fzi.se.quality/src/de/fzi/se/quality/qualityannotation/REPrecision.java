/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>RE Precision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Precision&nbsp;of specification on&nbsp;required element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.REPrecision#getDefaultPrecisionNumberOfCalls <em>Default Precision Number Of Calls</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.REPrecision#getDefaultPrecisionCallParameter <em>Default Precision Call Parameter</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.REPrecision#getRequiredElement <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getREPrecision()
 * @model
 * @generated
 */
public interface REPrecision extends Identifier {
	/**
     * Returns the value of the '<em><b>Default Precision Number Of Calls</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Precision Number Of Calls</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Default Precision Number Of Calls</em>' containment reference.
     * @see #setDefaultPrecisionNumberOfCalls(Precision)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getREPrecision_DefaultPrecisionNumberOfCalls()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
	Precision getDefaultPrecisionNumberOfCalls();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.REPrecision#getDefaultPrecisionNumberOfCalls <em>Default Precision Number Of Calls</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Precision Number Of Calls</em>' containment reference.
     * @see #getDefaultPrecisionNumberOfCalls()
     * @generated
     */
	void setDefaultPrecisionNumberOfCalls(Precision value);

	/**
     * Returns the value of the '<em><b>Default Precision Call Parameter</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Precision Call Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Default Precision Call Parameter</em>' containment reference.
     * @see #setDefaultPrecisionCallParameter(Precision)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getREPrecision_DefaultPrecisionCallParameter()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
	Precision getDefaultPrecisionCallParameter();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.REPrecision#getDefaultPrecisionCallParameter <em>Default Precision Call Parameter</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Precision Call Parameter</em>' containment reference.
     * @see #getDefaultPrecisionCallParameter()
     * @generated
     */
	void setDefaultPrecisionCallParameter(Precision value);

	/**
     * Returns the value of the '<em><b>Required Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.RequiredElement#getPrecision <em>Precision</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Required Element</em>' container reference.
     * @see #setRequiredElement(RequiredElement)
     * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getREPrecision_RequiredElement()
     * @see de.fzi.se.quality.qualityannotation.RequiredElement#getPrecision
     * @model opposite="precision" required="true" transient="false" ordered="false"
     * @generated
     */
	RequiredElement getRequiredElement();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.REPrecision#getRequiredElement <em>Required Element</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Element</em>' container reference.
     * @see #getRequiredElement()
     * @generated
     */
	void setRequiredElement(RequiredElement value);

} // REPrecision
