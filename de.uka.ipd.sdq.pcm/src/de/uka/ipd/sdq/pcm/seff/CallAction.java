/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.EStereotypableObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Call Action</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> Generic class realising call relations between behaviours (e.g. method
 * call). <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.CallAction#getInputVariableUsages__CallAction <em>Input
 * Variable Usages Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction()
 * @model abstract="true"
 * @extends EStereotypableObject
 * @generated
 */
public interface CallAction extends EStereotypableObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Input Variable Usages Call Action</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction__VariableUsage
     * <em>Call Action Variable Usage</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Variable Usages Call Action</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Input Variable Usages Call Action</em>' containment reference
     *         list.
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCallAction_InputVariableUsages__CallAction()
     * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getCallAction__VariableUsage
     * @model opposite="callAction__VariableUsage" containment="true" ordered="false"
     * @generated
     */
    EList<VariableUsage> getInputVariableUsages__CallAction();

} // CallAction
