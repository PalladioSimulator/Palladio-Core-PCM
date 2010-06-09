/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.parameter.SetVariable;
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
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CallAction#getSetVariableInputs__CallAction <em>Set Variable Inputs Call Action</em>}</li>
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
	 * Returns the value of the '<em><b>Set Variable Inputs Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.SetVariable}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable <em>Call Action Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Variable Inputs Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Variable Inputs Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction_SetVariableInputs__CallAction()
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallAction__SetVariable
	 * @model opposite="callAction__SetVariable" containment="true" ordered="false"
	 * @generated
	 */
	EList<SetVariable> getSetVariableInputs__CallAction();

} // CallAction
