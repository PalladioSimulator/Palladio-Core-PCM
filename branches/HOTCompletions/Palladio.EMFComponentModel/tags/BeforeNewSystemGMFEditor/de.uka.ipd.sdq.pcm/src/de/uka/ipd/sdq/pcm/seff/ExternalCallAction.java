
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService <em>Called Service External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getParametricParameterUsage_ParametricParameterUsage <em>Parametric Parameter Usage Parametric Parameter Usage</em>}</li>
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
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	 * Returns the value of the '<em><b>Parametric Parameter Usage Parametric Parameter Usage</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parametric Parameter Usage Parametric Parameter Usage</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parametric Parameter Usage Parametric Parameter Usage</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_ParametricParameterUsage_ParametricParameterUsage()
	 * @model type="de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage" ordered="false"
	 * @generated
	 */
	EList getParametricParameterUsage_ParametricParameterUsage();

} // ExternalCallAction