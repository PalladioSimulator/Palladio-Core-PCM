/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>External Call Input</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getParameterCharacterisations_ExternalCallInput
 * <em>Parameter Characterisations External Call Input</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getExternalCallAction_ExternalCallInput
 * <em>External Call Action External Call Input</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput
 * <em>Computed Usage Context External Call Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallInput()
 * @model
 * @generated
 */
public interface ExternalCallInput extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Parameter Characterisations External Call Input</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter Characterisations External Call Input</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Parameter Characterisations External Call Input</em>'
     *         containment reference list.
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallInput_ParameterCharacterisations_ExternalCallInput()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<VariableUsage> getParameterCharacterisations_ExternalCallInput();

    /**
     * Returns the value of the '<em><b>External Call Action External Call Input</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>External Call Action External Call Input</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>External Call Action External Call Input</em>' reference.
     * @see #setExternalCallAction_ExternalCallInput(ExternalCallAction)
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallInput_ExternalCallAction_ExternalCallInput()
     * @model required="true" ordered="false"
     * @generated
     */
    ExternalCallAction getExternalCallAction_ExternalCallInput();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getExternalCallAction_ExternalCallInput
     * <em>External Call Action External Call Input</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>External Call Action External Call Input</em>'
     *            reference.
     * @see #getExternalCallAction_ExternalCallInput()
     * @generated
     */
    void setExternalCallAction_ExternalCallInput(ExternalCallAction value);

    /**
     * Returns the value of the '<em><b>Computed Usage Context External Call Input</b></em>'
     * container reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallInput_ComputedUsageContext
     * <em>External Call Input Computed Usage Context</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Computed Usage Context External Call Input</em>' container
     * reference isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Computed Usage Context External Call Input</em>' container
     *         reference.
     * @see #setComputedUsageContext_ExternalCallInput(ComputedUsageContext)
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#getExternalCallInput_ComputedUsageContext_ExternalCallInput()
     * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext#getExternalCallInput_ComputedUsageContext
     * @model opposite="externalCallInput_ComputedUsageContext" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    ComputedUsageContext getComputedUsageContext_ExternalCallInput();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_usage.ExternalCallInput#getComputedUsageContext_ExternalCallInput
     * <em>Computed Usage Context External Call Input</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Computed Usage Context External Call Input</em>'
     *            container reference.
     * @see #getComputedUsageContext_ExternalCallInput()
     * @generated
     */
    void setComputedUsageContext_ExternalCallInput(ComputedUsageContext value);

} // ExternalCallInput
