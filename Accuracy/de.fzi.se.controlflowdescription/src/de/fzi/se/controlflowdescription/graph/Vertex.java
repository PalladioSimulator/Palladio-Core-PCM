/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getTo <em>To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getNumber <em>Number</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getIterations <em>Iterations</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getTransitionProbability <em>Transition Probability</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Vertex#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex()
 * @model
 * @generated
 */
public interface Vertex extends EObject {
	/**
	 * Returns the value of the '<em><b>To</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.graph.Vertex}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Vertex#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference list.
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_To()
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getFrom
	 * @model opposite="from"
	 * @generated
	 */
	EList<Vertex> getTo();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.graph.Vertex}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Vertex#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' reference list.
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_From()
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getTo
	 * @model opposite="to" ordered="false"
	 * @generated
	 */
	EList<Vertex> getFrom();

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unique number of the vertex in the control-flow graph. The source vertex must have number 1, the sink vertex the number of
	 * vertices in the graph as number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_Number()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.Vertex#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Transition Probability</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.graph.TransitionProbability}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Probability</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Probability</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_TransitionProbability()
	 * @see de.fzi.se.controlflowdescription.graph.TransitionProbability#getVertex
	 * @model opposite="vertex" containment="true"
	 * @generated
	 */
	EList<TransitionProbability> getTransitionProbability();

	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' attribute.
	 * @see #setIterations(double)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_Iterations()
	 * @model ordered="false"
	 * @generated
	 */
	double getIterations();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.Vertex#getIterations <em>Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterations</em>' attribute.
	 * @see #getIterations()
	 * @generated
	 */
	void setIterations(double value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Graph#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' container reference.
	 * @see #setGraph(Graph)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getVertex_Graph()
	 * @see de.fzi.se.controlflowdescription.graph.Graph#getVertices
	 * @model opposite="vertices" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.Vertex#getGraph <em>Graph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' container reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The number of this vertex must be unique in the context of the graph in which it is contained.
	 * </p>
	 * self.graph.vertices->select(v : Vertex | v.number = self.number)->size() = 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean NumberMustBeUniqueForGraph(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The source vertex must have the number 1.
	 * self.from->size() = 0 implies self.number = 0
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean SourceVertexMustHaveNumber1(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     The sink vertex must have the number of all vertices in the graph as its number.
	 * </p>
	 * self.to->size() = 0 implies self.number = self.graph.vertices->size()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean SinkVertexMustHaveTheNumberOfOverallVerticesInTheGraphAsNumber(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * transitionProbability->size() > 0 implies transitionProbability->size() = to->size()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean TransitionProbabilitiesMustBeDefinedForAllTargetVerticesOrForNone(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Vertex
