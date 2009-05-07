/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterationCount_LoopAction <em>Iteration Count Loop Action</em>}</li>
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
	 * Returns the value of the '<em><b>Iteration Count Loop Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Count Loop Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Count Loop Action</em>' containment reference.
	 * @see #setIterationCount_LoopAction(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getLoopAction_IterationCount_LoopAction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getIterationCount_LoopAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.LoopAction#getIterationCount_LoopAction <em>Iteration Count Loop Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Count Loop Action</em>' containment reference.
	 * @see #getIterationCount_LoopAction()
	 * @generated
	 */
	void setIterationCount_LoopAction(PCMRandomVariable value);

} // LoopAction
