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
 * <em><b>Alternative Resource Usage</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage#getOptions <em>Options</em>}
 * </li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getAlternativeResourceUsage()
 * @model
 * @generated
 */
public interface AlternativeResourceUsage extends AbstractResourceUsage {
    /**
     * Returns the value of the '<em><b>Options</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.spa.resourcemodel.Option}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Options</em>' containment reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Options</em>' containment reference list.
     * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getAlternativeResourceUsage_Options()
     * @model type="de.uka.ipd.sdq.spa.resourcemodel.Option" containment="true"
     * @generated
     */
    EList getOptions();

} // AlternativeResourceUsage
