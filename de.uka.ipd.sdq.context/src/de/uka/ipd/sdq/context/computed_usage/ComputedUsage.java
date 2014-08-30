/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Computed Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.context.computed_usage.ComputedUsage#getUsageContexts_ComputedUsage
 * <em>Usage Contexts Computed Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsage()
 * @model
 * @generated
 */
public interface ComputedUsage extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Usage Contexts Computed Usage</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usage Contexts Computed Usage</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Usage Contexts Computed Usage</em>' containment reference list.
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getComputedUsage_UsageContexts_ComputedUsage()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ComputedUsageContext> getUsageContexts_ComputedUsage();

} // ComputedUsage
