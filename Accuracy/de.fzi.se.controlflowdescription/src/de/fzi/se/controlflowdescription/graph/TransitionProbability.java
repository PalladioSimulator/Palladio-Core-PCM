/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Probability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex <em>Vertex</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getTransitionProbability()
 * @model
 * @generated
 */
public interface TransitionProbability extends EObject {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getTransitionProbability_Probability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Vertex</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Vertex#getTransitionProbability <em>Transition Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertex</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertex</em>' container reference.
	 * @see #setVertex(Vertex)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getTransitionProbability_Vertex()
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getTransitionProbability
	 * @model opposite="transitionProbability" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Vertex getVertex();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex <em>Vertex</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vertex</em>' container reference.
	 * @see #getVertex()
	 * @generated
	 */
	void setVertex(Vertex value);

} // TransitionProbability
