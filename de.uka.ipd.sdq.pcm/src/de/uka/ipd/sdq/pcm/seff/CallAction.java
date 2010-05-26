/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Generic class realising call relations between behaviours (e.g. method call).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CallAction#getOutputVariableUsages_ExternalCallAction <em>Output Variable Usages External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CallAction#getInputParameterUsages_ExternalCallAction <em>Input Parameter Usages External Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction()
 * @model abstract="true"
 * @generated
 */
public interface CallAction extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Output Variable Usages External Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_out_VariableUsage <em>Call Action out Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Usages External Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Usages External Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction_OutputVariableUsages_ExternalCallAction()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_out_VariableUsage
	 * @model opposite="callAction_out_VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getOutputVariableUsages_ExternalCallAction();

	/**
	 * Returns the value of the '<em><b>Input Parameter Usages External Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_in_VariableUsage <em>Call Action in Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Usages External Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Usages External Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction_InputParameterUsages_ExternalCallAction()
	 * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction_in_VariableUsage
	 * @model opposite="callAction_in_VariableUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getInputParameterUsages_ExternalCallAction();

} // CallAction
