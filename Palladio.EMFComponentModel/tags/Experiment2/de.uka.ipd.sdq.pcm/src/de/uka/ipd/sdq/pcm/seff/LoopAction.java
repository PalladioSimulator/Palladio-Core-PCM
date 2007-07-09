
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterations_LoopAction <em>Iterations Loop Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction()
 * @model
 * @generated
 */
public interface LoopAction extends AbstractLoopAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

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
