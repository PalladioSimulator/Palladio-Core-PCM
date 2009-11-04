/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Synchronisation Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Component developers can use a SynchronisationPoint to join synchronously ForkedBehaviours and specify a result of the computations with its attached VariableUsages.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getSynchronousForkedBehaviours_SynchronisationPoint <em>Synchronous Forked Behaviours Synchronisation Point</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint#getOutputParameterUsage_SynchronisationPoint <em>Output Parameter Usage Synchronisation Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint()
 * @model
 * @generated
 */
public interface SynchronisationPoint extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Synchronous Forked Behaviours Synchronisation Point</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronous Forked Behaviours Synchronisation Point</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronous Forked Behaviours Synchronisation Point</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint_SynchronousForkedBehaviours_SynchronisationPoint()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ForkedBehaviour> getSynchronousForkedBehaviours_SynchronisationPoint();

	/**
	 * Returns the value of the '<em><b>Output Parameter Usage Synchronisation Point</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Usage Synchronisation Point</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Usage Synchronisation Point</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSynchronisationPoint_OutputParameterUsage_SynchronisationPoint()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableUsage> getOutputParameterUsage_SynchronisationPoint();

} // SynchronisationPoint
