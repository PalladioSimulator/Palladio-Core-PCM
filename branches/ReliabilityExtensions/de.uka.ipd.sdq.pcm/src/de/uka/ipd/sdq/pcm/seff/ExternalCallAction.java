/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService <em>Called Service External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getInputParameterUsages_ExternalCallAction <em>Input Parameter Usages External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getOutputVariableUsages_ExternalCallAction <em>Output Variable Usages External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRole_ExternalService <em>Role External Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction()
 * @model
 * @generated
 */
public interface ExternalCallAction extends AbstractAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Called Service External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Service External Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Service External Service</em>' reference.
	 * @see #setCalledService_ExternalService(Signature)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_CalledService_ExternalService()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getCalledService_ExternalService();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService <em>Called Service External Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Service External Service</em>' reference.
	 * @see #getCalledService_ExternalService()
	 * @generated
	 */
	void setCalledService_ExternalService(Signature value);

	/**
	 * Returns the value of the '<em><b>Input Parameter Usages External Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Usages External Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Usages External Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_InputParameterUsages_ExternalCallAction()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getInputParameterUsages_ExternalCallAction();

	/**
	 * Returns the value of the '<em><b>Output Variable Usages External Call Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Usages External Call Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Usages External Call Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_OutputVariableUsages_ExternalCallAction()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getOutputVariableUsages_ExternalCallAction();

	/**
	 * Returns the value of the '<em><b>Role External Service</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role External Service</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role External Service</em>' reference.
	 * @see #setRole_ExternalService(Role)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_Role_ExternalService()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Role getRole_ExternalService();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRole_ExternalService <em>Role External Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role External Service</em>' reference.
	 * @see #getRole_ExternalService()
	 * @generated
	 */
	void setRole_ExternalService(Role value);

} // ExternalCallAction
