/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Sequential Resource Usage</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage#getResourceUsages <em>
 * Resource Usages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getSequentialResourceUsage()
 * @model
 * @generated
 */
public interface SequentialResourceUsage extends AbstractResourceUsage {
    /**
     * Returns the value of the '<em><b>Resource Usages</b></em>' containment reference list. The
     * list contents are of type {@link de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Usages</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Usages</em>' containment reference list.
     * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getSequentialResourceUsage_ResourceUsages()
     * @model type="de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage" containment="true"
     * @generated
     */
    EList getResourceUsages();

} // SequentialResourceUsage
