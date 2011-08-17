/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Call Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * ExternalCallAction models the invocation of a service specified in a required interface. Therefore, it references a Role, from which the providing component can be derived, and a Signature to specify the called service. ExternalCallActions model synchronous calls to required services, i.e., the caller waits until the called service finishes execution before continuing execution itself. The PCM allows modelling asynchronous calls to required services by using an ExternalCallAction inside a ForkedBehaviour.
 * ExternalCallActions do not have resource demands by themselves. Component developers need to specify the resource demand of the called service in the RDSEFF of that service. The resource demand can also be calculated by analysing the providing component. This keeps the RDSEFF specification of different component developers independent from each other and makes them replaceable in an architectural model.
 * ExternalCallActions may contain two sets of VariableUsages specifying input parameter characterisations and output parameter characterisations respectively. VariableUsages for input parameters may only reference IN or INOUT parameters of the call’s referenced signature. The random variable characterisation inside such a VariableUsage may be constants, probability distribution functions, or include a stochastic expression involving for example arithmetic operations. The latter models a dependency between the current service’s own input parameters and the input parameters of the required service.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getCalledService_ExternalService <em>Called Service External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRole_ExternalService <em>Role External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRetryCount <em>Retry Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction()
 * @model
 * @generated
 */
public interface ExternalCallAction extends AbstractAction, CallAction, FailureHandlingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

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

	/**
	 * Returns the value of the '<em><b>Retry Count</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies&nbsp;the&nbsp;number of&nbsp;retries this ExternalCallAction shoul be re-executed&nbsp; in case of failure
	 * occurence.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Retry Count</em>' attribute.
	 * @see #setRetryCount(int)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getExternalCallAction_RetryCount()
	 * @model default="0" required="true" ordered="false"
	 * @generated
	 */
	int getRetryCount();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction#getRetryCount <em>Retry Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry Count</em>' attribute.
	 * @see #getRetryCount()
	 * @generated
	 */
	void setRetryCount(int value);

} // ExternalCallAction
