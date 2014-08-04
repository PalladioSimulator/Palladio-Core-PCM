/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.markov;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Chain</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.markov.MarkovChain#getStates <em>States</em>}</li>
 * <li>{@link de.uka.ipd.sdq.markov.MarkovChain#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.markov.MarkovPackage#getMarkovChain()
 * @model
 * @generated
 */
public interface MarkovChain extends Entity {
    /**
     * Returns the value of the '<em><b>States</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.markov.State}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>States</em>' containment reference list isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>States</em>' containment reference list.
     * @see de.uka.ipd.sdq.markov.MarkovPackage#getMarkovChain_States()
     * @model containment="true"
     * @generated
     */
    EList<State> getStates();

    /**
     * Returns the value of the '<em><b>Transitions</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.markov.Transition}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Transitions</em>' containment reference list.
     * @see de.uka.ipd.sdq.markov.MarkovPackage#getMarkovChain_Transitions()
     * @model containment="true"
     * @generated
     */
    EList<Transition> getTransitions();

} // MarkovChain
