/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Internal Call Action</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> A "SubSEFF"-Action: Realises an internal method call within a SEFF. <!--
 * end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.InternalCallAction#getCalledResourceDemandingInternalBehaviour
 * <em>Called Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getInternalCallAction()
 * @model
 * @generated
 */
public interface InternalCallAction extends CallAction, AbstractInternalControlFlowAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Called Resource Demanding Internal Behaviour</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the ' <em>Called Resource Demanding Internal Behaviour</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Called Resource Demanding Internal Behaviour</em>' reference.
     * @see #setCalledResourceDemandingInternalBehaviour(ResourceDemandingInternalBehaviour)
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getInternalCallAction_CalledResourceDemandingInternalBehaviour()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceDemandingInternalBehaviour getCalledResourceDemandingInternalBehaviour();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.seff.InternalCallAction#getCalledResourceDemandingInternalBehaviour
     * <em>Called Resource Demanding Internal Behaviour</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Called Resource Demanding Internal Behaviour</em>'
     *            reference.
     * @see #getCalledResourceDemandingInternalBehaviour()
     * @generated
     */
    void setCalledResourceDemandingInternalBehaviour(ResourceDemandingInternalBehaviour value);

} // InternalCallAction
