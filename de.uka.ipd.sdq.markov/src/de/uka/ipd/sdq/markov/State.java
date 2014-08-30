/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.markov;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>State</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.markov.State#getType <em>Type</em>}</li>
 * <li>{@link de.uka.ipd.sdq.markov.State#getLabels <em>Labels</em>}</li>
 * <li>{@link de.uka.ipd.sdq.markov.State#getTraces <em>Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.markov.MarkovPackage#getState()
 * @model
 * @generated
 */
public interface State extends Entity {
    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are from the
     * enumeration {@link de.uka.ipd.sdq.markov.StateType}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a
     * description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Type</em>' attribute.
     * @see de.uka.ipd.sdq.markov.StateType
     * @see #setType(StateType)
     * @see de.uka.ipd.sdq.markov.MarkovPackage#getState_Type()
     * @model required="true"
     * @generated
     */
    StateType getType();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.markov.State#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Type</em>' attribute.
     * @see de.uka.ipd.sdq.markov.StateType
     * @see #getType()
     * @generated
     */
    void setType(StateType value);

    /**
     * Returns the value of the '<em><b>Labels</b></em>' containment reference list. The list
     * contents are of type {@link de.uka.ipd.sdq.markov.Label}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Labels</em>' reference list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Labels</em>' containment reference list.
     * @see de.uka.ipd.sdq.markov.MarkovPackage#getState_Labels()
     * @model containment="true" keys="key"
     * @generated
     */
    EList<Label> getLabels();

    /**
     * Returns the value of the '<em><b>Traces</b></em>' attribute list. The list contents are of
     * type {@link java.lang.String}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Traces</em>' attribute list isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Traces</em>' attribute list.
     * @see de.uka.ipd.sdq.markov.MarkovPackage#getState_Traces()
     * @model default=""
     * @generated
     */
    EList<String> getTraces();

} // State
