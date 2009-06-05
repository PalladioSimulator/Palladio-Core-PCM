
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Demanding Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour <em>Steps Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour()
 * @model
 * @generated
 */
public interface ResourceDemandingBehaviour extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Steps Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.AbstractAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getResourceDemandingBehaviour_Steps_Behaviour()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractAction> getSteps_Behaviour();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.steps_Behaviour->select(s|s.oclIsTypeOf(StopAction))->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ExactlyOneStopAction(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.steps_Behaviour->select(s|s.oclIsTypeOf(StartAction))->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ExactlyOneStartAction(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).predecessor_AbstractAction.oclIsUndefined()) and not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).successor_AbstractAction.oclIsUndefined())
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ResourceDemandingBehaviour
