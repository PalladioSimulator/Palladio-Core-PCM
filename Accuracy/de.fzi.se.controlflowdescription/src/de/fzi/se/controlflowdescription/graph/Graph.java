/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.graph;

import de.fzi.se.controlflowdescription.ControlFlowDescription;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Graph#getVertices <em>Vertices</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription <em>Controlflowdescription</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.graph.Vertex}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Vertex#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getGraph_Vertices()
	 * @see de.fzi.se.controlflowdescription.graph.Vertex#getGraph
	 * @model opposite="graph" containment="true" ordered="false"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * Returns the value of the '<em><b>Controlflowdescription</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowdescription</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowdescription</em>' container reference.
	 * @see #setControlflowdescription(ControlFlowDescription)
	 * @see de.fzi.se.controlflowdescription.graph.GraphPackage#getGraph_Controlflowdescription()
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph
	 * @model opposite="graph" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ControlFlowDescription getControlflowdescription();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription <em>Controlflowdescription</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controlflowdescription</em>' container reference.
	 * @see #getControlflowdescription()
	 * @generated
	 */
	void setControlflowdescription(ControlFlowDescription value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There must be exactly one source vertex for each graph.
	 * self.vertices->select(v : Vertex | v.from->size() = 0)->size() = 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GraphMustHaveAUniqueSourceVertex(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There must be exactly one sink vertex for each graph.
	 * self.vertices->select(v : Vertex | v.to->size() = 0)->size() = 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GraphMustHaveAUniqueSinkVertex(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Graph
