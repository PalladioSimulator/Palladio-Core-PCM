/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package markov;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link markov.MarkovChain#getStates <em>States</em>}</li>
 *   <li>{@link markov.MarkovChain#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see markov.MarkovPackage#getMarkovChain()
 * @model
 * @generated
 */
public interface MarkovChain extends Entity {
	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link markov.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see markov.MarkovPackage#getMarkovChain_States()
	 * @model
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' reference list.
	 * The list contents are of type {@link markov.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' reference list.
	 * @see markov.MarkovPackage#getMarkovChain_Transitions()
	 * @model
	 * @generated
	 */
	EList<Transition> getTransitions();

} // MarkovChain
