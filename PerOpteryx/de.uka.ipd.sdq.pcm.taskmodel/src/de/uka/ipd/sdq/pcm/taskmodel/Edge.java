/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Edge connects two Tasks. Each Task has a set of Edges, that themselves point to one successor Task each. For example, for a task with three successor tasks, you have three Edges, each pointing to one of the successors. 
 * 
 * Loops in the PCM might be unrolled into "branches" in this model with adjusted transition probabilities. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getTransitionProbability <em>Transition Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getSuccessor_Edge <em>Successor Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Transition Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The transition probability of this Task. The transition probabilities of all Edges exiting one Task usually sum up to 1. If they do not, this is an implicit stop task, i.e. the control flow ends here with the remaining probability. TODO: Add OCL that sum of probabilities must not be larger than 1. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Transition Probability</em>' attribute.
	 * @see #setTransitionProbability(double)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getEdge_TransitionProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getTransitionProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getTransitionProbability <em>Transition Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Probability</em>' attribute.
	 * @see #getTransitionProbability()
	 * @generated
	 */
	void setTransitionProbability(double value);

	/**
	 * Returns the value of the '<em><b>Successor Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association points to the successor Task of this Edge. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Successor Edge</em>' reference.
	 * @see #setSuccessor_Edge(Task)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getEdge_Successor_Edge()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Task getSuccessor_Edge();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Edge#getSuccessor_Edge <em>Successor Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor Edge</em>' reference.
	 * @see #getSuccessor_Edge()
	 * @generated
	 */
	void setSuccessor_Edge(Task value);

} // Edge
