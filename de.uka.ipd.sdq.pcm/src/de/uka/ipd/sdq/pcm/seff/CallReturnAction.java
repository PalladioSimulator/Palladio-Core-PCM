/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.parameter.SetVariable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Return Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CallReturnAction#getSetVariableReturns__CallReturnAction <em>Set Variable Returns Call Return Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallReturnAction()
 * @model abstract="true"
 * @generated
 */
public interface CallReturnAction extends CallAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Set Variable Returns Call Return Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.SetVariable}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable <em>Call Return Action Set Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set Variable Returns Call Return Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set Variable Returns Call Return Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallReturnAction_SetVariableReturns__CallReturnAction()
	 * @see de.uka.ipd.sdq.pcm.parameter.SetVariable#getCallReturnAction__SetVariable
	 * @model opposite="callReturnAction__SetVariable" containment="true" ordered="false"
	 * @generated
	 */
	EList<SetVariable> getSetVariableReturns__CallReturnAction();

} // CallReturnAction
