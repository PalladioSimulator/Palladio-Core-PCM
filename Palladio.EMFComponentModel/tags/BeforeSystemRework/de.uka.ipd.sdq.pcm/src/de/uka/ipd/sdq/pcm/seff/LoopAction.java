
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations <em>Iterations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations_LoopAction <em>Iterations Loop Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction()
 * @model
 * @generated
 */
public interface LoopAction extends AbstractResourceDemandingAction {
	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' attribute.
	 * @see #setIterations(String)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction_Iterations()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getIterations();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations</em>' attribute.
	 * @see #getIterations()
	 * @generated
	 */
	void setIterations(String value);

	/**
	 * Returns the value of the '<em><b>Body Behaviour Loop</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Behaviour Loop</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #setBodyBehaviour_Loop(ResourceDemandingBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction_BodyBehaviour_Loop()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ResourceDemandingBehaviour getBodyBehaviour_Loop();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getBodyBehaviour_Loop <em>Body Behaviour Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Behaviour Loop</em>' containment reference.
	 * @see #getBodyBehaviour_Loop()
	 * @generated
	 */
	void setBodyBehaviour_Loop(ResourceDemandingBehaviour value);

	/**
	 * Returns the value of the '<em><b>Iterations Loop Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations Loop Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations Loop Action</em>' containment reference.
	 * @see #setIterations_LoopAction(IterationCount)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction_Iterations_LoopAction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	IterationCount getIterations_LoopAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations_LoopAction <em>Iterations Loop Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations Loop Action</em>' containment reference.
	 * @see #getIterations_LoopAction()
	 * @generated
	 */
	void setIterations_LoopAction(IterationCount value);

} // LoopAction