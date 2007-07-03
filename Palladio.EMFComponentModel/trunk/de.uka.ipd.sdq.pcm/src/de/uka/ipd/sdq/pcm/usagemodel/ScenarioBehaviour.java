
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour#getActions_ScenarioBehaviour <em>Actions Scenario Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getScenarioBehaviour()
 * @model
 * @generated
 */
public interface ScenarioBehaviour extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Actions Scenario Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Scenario Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Scenario Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getScenarioBehaviour_Actions_ScenarioBehaviour()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractUserAction> getActions_ScenarioBehaviour();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Start))->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean Exactlyonestart(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.actions_ScenarioBehaviour->select(s|s.oclIsTypeOf(Stop))->size() = 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean Exactlyonestop(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).predecessor.oclIsUndefined()) and not self.actions_ScenarioBehaviour->select(s|not s.oclIsTypeOf(Start) and not s.oclIsTypeOf(Stop))->exists(a|a.oclAsType(AbstractUserAction).successor.oclIsUndefined())
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EachuseractionexceptStartandStopmusthaveapredecessorandsuccessor(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ScenarioBehaviour
