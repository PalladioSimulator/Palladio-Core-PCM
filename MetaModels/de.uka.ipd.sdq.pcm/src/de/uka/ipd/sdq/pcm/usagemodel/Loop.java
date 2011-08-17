
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations_Loop <em>Iterations Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends AbstractUserAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Behaviour Loop</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #setBodyBehaviour_Loop(ScenarioBehaviour)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop_BodyBehaviour_Loop()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ScenarioBehaviour getBodyBehaviour_Loop();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 */
	void setBodyBehaviour_Loop(ScenarioBehaviour value);

	/**
	 * Returns the value of the '<em><b>Iterations Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations Loop</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations Loop</em>' containment reference.
	 * @see #setIterations_Loop(LoopIterations)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getLoop_Iterations_Loop()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	LoopIterations getIterations_Loop();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.Loop#getIterations_Loop <em>Iterations Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations Loop</em>' containment reference.
	 * @see #getIterations_Loop()
	 * @generated
	 */
	void setIterations_Loop(LoopIterations value);

} // Loop
