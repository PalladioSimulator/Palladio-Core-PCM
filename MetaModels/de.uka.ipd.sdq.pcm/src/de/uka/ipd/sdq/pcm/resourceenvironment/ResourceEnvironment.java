/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.common.util.EList;
import org.palladiosimulator.mdsdprofiles.ProfileableElement;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resource Environment</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Repository element of&nbsp;the resource environment
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getLinkingResources__ResourceEnvironment
 * <em>Linking Resources Resource Environment</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment
 * <em>Resource Container Resource Environment</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment()
 * @model
 * @generated
 */
public interface ResourceEnvironment extends ProfileableElement, NamedElement {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Linking Resources Resource Environment</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource}. It is bidirectional and its
     * opposite is '
     * {@link de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getResourceEnvironment_LinkingResource
     * <em>Resource Environment Linking Resource</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Linking Resources Resource Environment</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Linking Resources Resource Environment</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment_LinkingResources__ResourceEnvironment()
     * @see de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource#getResourceEnvironment_LinkingResource
     * @model opposite="resourceEnvironment_LinkingResource" containment="true" ordered="false"
     * @generated
     */
    EList<LinkingResource> getLinkingResources__ResourceEnvironment();

    /**
     * Returns the value of the '<em><b>Resource Container Resource Environment</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer}. It is bidirectional and its
     * opposite is '
     * {@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getResourceEnvironment_ResourceContainer
     * <em>Resource Environment Resource Container</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Container Resource Environment</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Container Resource Environment</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceEnvironment_ResourceContainer_ResourceEnvironment()
     * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getResourceEnvironment_ResourceContainer
     * @model opposite="resourceEnvironment_ResourceContainer" containment="true" ordered="false"
     * @generated
     */
    EList<ResourceContainer> getResourceContainer_ResourceEnvironment();

} // ResourceEnvironment
