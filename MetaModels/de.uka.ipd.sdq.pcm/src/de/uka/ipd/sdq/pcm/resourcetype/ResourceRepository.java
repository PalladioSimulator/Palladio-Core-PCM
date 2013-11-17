/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.EStereotypableObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource Repository</b></em>
 * '. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Extendable repository of resource types of the PCM. The resource type repository is intentionally left open to support
 * arbitrary resources in the future
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getResourceInterfaces__ResourceRepository <em>Resource Interfaces Resource Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getSchedulingPolicies__ResourceRepository <em>Scheduling Policies Resource Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository#getAvailableResourceTypes_ResourceRepository <em>Available Resource Types Resource Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository()
 * @model
 * @extends EStereotypableObject
 * @generated
 */
public interface ResourceRepository extends EStereotypableObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Resource Interfaces Resource Repository</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceRepository__ResourceInterface <em>Resource Repository Resource Interface</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Interfaces Resource Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Resource Interfaces Resource Repository</em>' containment reference list.
     * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository_ResourceInterfaces__ResourceRepository()
     * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceRepository__ResourceInterface
     * @model opposite="resourceRepository__ResourceInterface" containment="true" ordered="false"
     * @generated
     */
    EList<ResourceInterface> getResourceInterfaces__ResourceRepository();

    /**
     * Returns the value of the '<em><b>Scheduling Policies Resource Repository</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy#getResourceRepository__SchedulingPolicy <em>Resource Repository Scheduling Policy</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scheduling Policies Resource Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scheduling Policies Resource Repository</em>' containment reference list.
     * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository_SchedulingPolicies__ResourceRepository()
     * @see de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy#getResourceRepository__SchedulingPolicy
     * @model opposite="resourceRepository__SchedulingPolicy" containment="true" ordered="false"
     * @generated
     */
    EList<SchedulingPolicy> getSchedulingPolicies__ResourceRepository();

    /**
     * Returns the value of the '<em><b>Available Resource Types Resource Repository</b></em>' containment reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourcetype.ResourceType}.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceType#getResourceRepository_ResourceType <em>Resource Repository Resource Type</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Available Resource Types Resource Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Available Resource Types Resource Repository</em>' containment reference list.
     * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceRepository_AvailableResourceTypes_ResourceRepository()
     * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceType#getResourceRepository_ResourceType
     * @model opposite="resourceRepository_ResourceType" containment="true" ordered="false"
     * @generated
     */
    EList<ResourceType> getAvailableResourceTypes_ResourceRepository();

} // ResourceRepository
