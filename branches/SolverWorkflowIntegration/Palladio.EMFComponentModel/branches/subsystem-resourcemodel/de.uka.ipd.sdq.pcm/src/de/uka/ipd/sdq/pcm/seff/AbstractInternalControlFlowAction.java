/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Internal Control Flow Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction#getResourceDemand_Action <em>Resource Demand Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractInternalControlFlowAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractInternalControlFlowAction extends AbstractAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Demand Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand <em>Action Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Demand Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Demand Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractInternalControlFlowAction_ResourceDemand_Action()
	 * @see de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand#getAction_ParametricResourceDemand
	 * @model opposite="action_ParametricResourceDemand" containment="true" ordered="false"
	 * @generated
	 */
	EList<ParametricResourceDemand> getResourceDemand_Action();

} // AbstractInternalControlFlowAction
