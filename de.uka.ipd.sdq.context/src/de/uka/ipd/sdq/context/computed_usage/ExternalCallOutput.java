/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Call Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getParameterCharacterisations_ExternalCallOutput <em>Parameter Characterisations External Call Output</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getExternalCallAction_ExternalCallOutput <em>External Call Action External Call Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallOutput()
 * @model
 * @generated
 */
public interface ExternalCallOutput extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Parameter Characterisations External Call Output</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Characterisations External Call Output</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Characterisations External Call Output</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallOutput_ParameterCharacterisations_ExternalCallOutput()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getParameterCharacterisations_ExternalCallOutput();

	/**
	 * Returns the value of the '<em><b>External Call Action External Call Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Call Action External Call Output</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Call Action External Call Output</em>' reference.
	 * @see #setExternalCallAction_ExternalCallOutput(ExternalCallAction)
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallOutput_ExternalCallAction_ExternalCallOutput()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ExternalCallAction getExternalCallAction_ExternalCallOutput();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput#getExternalCallAction_ExternalCallOutput <em>External Call Action External Call Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Call Action External Call Output</em>' reference.
	 * @see #getExternalCallAction_ExternalCallOutput()
	 * @generated
	 */
	void setExternalCallAction_ExternalCallOutput(ExternalCallAction value);

} // ExternalCallOutput
