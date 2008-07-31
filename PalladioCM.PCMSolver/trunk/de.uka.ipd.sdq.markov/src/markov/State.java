/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package markov;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link markov.State#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see markov.MarkovPackage#getState()
 * @model
 * @generated
 */
public interface State extends Entity {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link markov.StateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see markov.StateType
	 * @see #setType(StateType)
	 * @see markov.MarkovPackage#getState_Type()
	 * @model required="true"
	 * @generated
	 */
	StateType getType();

	/**
	 * Sets the value of the '{@link markov.State#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see markov.StateType
	 * @see #getType()
	 * @generated
	 */
	void setType(StateType value);

} // State
