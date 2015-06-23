/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource Demanding Internal Behaviour</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Class representing component-internal behaviour not accessible from the
 * component's interface. Comparable to internal method in object-oriented programming. This
 * behaviour can be called from within a resource demanding behaviour using an InternalCallAction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour#getResourceDemandingSEFF_ResourceDemandingInternalBehaviour
 * <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingInternalBehaviour()
 * @model
 * @generated
 */
public interface ResourceDemandingInternalBehaviour extends ResourceDemandingBehaviour {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '
     * <em><b>Resource Demanding SEFF Resource Demanding Internal Behaviour</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF#getResourceDemandingInternalBehaviours
     * <em>Resource Demanding Internal Behaviours</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '
     * <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em> ' container reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '
     *         <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em>' container
     *         reference.
     * @see #setResourceDemandingSEFF_ResourceDemandingInternalBehaviour(ResourceDemandingSEFF)
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingInternalBehaviour_ResourceDemandingSEFF_ResourceDemandingInternalBehaviour()
     * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF#getResourceDemandingInternalBehaviours
     * @model opposite="resourceDemandingInternalBehaviours" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    ResourceDemandingSEFF getResourceDemandingSEFF_ResourceDemandingInternalBehaviour();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour#getResourceDemandingSEFF_ResourceDemandingInternalBehaviour
     * <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em>}' container reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Resource Demanding SEFF Resource Demanding Internal Behaviour</em>' container
     *            reference.
     * @see #getResourceDemandingSEFF_ResourceDemandingInternalBehaviour()
     * @generated
     */
    void setResourceDemandingSEFF_ResourceDemandingInternalBehaviour(ResourceDemandingSEFF value);

} // ResourceDemandingInternalBehaviour
