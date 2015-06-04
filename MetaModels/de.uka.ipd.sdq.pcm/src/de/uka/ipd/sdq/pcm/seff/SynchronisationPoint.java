/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Synchronisation Point</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> Component developers can use a SynchronisationPoint to join
 * synchronously ForkedBehaviours and specify a result of the computations with its attached
 * VariableUsages. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint
 * <em>Output Parameter Usage Synchronisation Point</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getForkAction_SynchronisationPoint <em>
 * Fork Action Synchronisation Point</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getSynchronousForkedBehaviours_SynchronisationPoint
 * <em>Synchronous Forked Behaviours Synchronisation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint()
 * @model
 * @generated
 */
public interface SynchronisationPoint extends Entity {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Output Parameter Usage Synchronisation Point</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSynchronisationPoint_VariableUsage
     * <em>Synchronisation Point Variable Usage</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the ' <em>Output Parameter Usage Synchronisation Point</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Output Parameter Usage Synchronisation Point</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint_OutputParameterUsage_SynchronisationPoint()
     * @see de.uka.ipd.sdq.pcm.parameter.VariableUsage#getSynchronisationPoint_VariableUsage
     * @model opposite="synchronisationPoint_VariableUsage" containment="true" ordered="false"
     * @generated
     */
    EList<VariableUsage> getOutputParameterUsage_SynchronisationPoint();

    /**
     * Returns the value of the '<em><b>Fork Action Synchronisation Point</b></em>' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction
     * <em>Synchronising Behaviours Fork Action</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fork Action Synchronisation Point</em>' container reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Fork Action Synchronisation Point</em>' container reference.
     * @see #setForkAction_SynchronisationPoint(ForkAction)
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint_ForkAction_SynchronisationPoint()
     * @see de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction
     * @model opposite="synchronisingBehaviours_ForkAction" required="true" transient="false"
     *        ordered="false"
     * @generated
     */
    ForkAction getForkAction_SynchronisationPoint();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getForkAction_SynchronisationPoint
     * <em>Fork Action Synchronisation Point</em>}' container reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Fork Action Synchronisation Point</em>' container
     *            reference.
     * @see #getForkAction_SynchronisationPoint()
     * @generated
     */
    void setForkAction_SynchronisationPoint(ForkAction value);

    /**
     * Returns the value of the '<em><b>Synchronous Forked Behaviours Synchronisation Point</b></em>
     * ' containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour}. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour#getSynchronisationPoint_ForkedBehaviour
     * <em>Synchronisation Point Forked Behaviour</em>}'. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the ' <em>Synchronous Forked Behaviours Synchronisation Point</em>'
     * containment reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Synchronous Forked Behaviours Synchronisation Point</em>'
     *         containment reference list.
     * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint_SynchronousForkedBehaviours_SynchronisationPoint()
     * @see de.uka.ipd.sdq.pcm.seff.ForkedBehaviour#getSynchronisationPoint_ForkedBehaviour
     * @model opposite="synchronisationPoint_ForkedBehaviour" containment="true" required="true"
     *        ordered="false"
     * @generated
     */
    EList<ForkedBehaviour> getSynchronousForkedBehaviours_SynchronisationPoint();

} // SynchronisationPoint
