/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Input</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.context.computed_usage.Input#getParameterChacterisations_Input <em>
 * Parameter Chacterisations Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getInput()
 * @model
 * @generated
 */
public interface Input extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Parameter Chacterisations Input</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Chacterisations Input</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parameter Chacterisations Input</em>' containment reference
     *         list.
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getInput_ParameterChacterisations_Input()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<VariableUsage> getParameterChacterisations_Input();

} // Input
