/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription;

import de.fzi.se.controlflowdescription.graph.Graph;

import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Flow Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjnpathsets <em>Jjnpathsets</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjpaths <em>Jjpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions <em>Controlflowdescriptions</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph <em>Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescription()
 * @model
 * @generated
 */
public interface ControlFlowDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Jjnpathsets</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathsets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathsets</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescription_Jjnpathsets()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription
	 * @model opposite="controlflowdescription" containment="true" ordered="false"
	 * @generated
	 */
	EList<JJnPathSet> getJjnpathsets();

	/**
	 * Returns the value of the '<em><b>Jjpaths</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJPath}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjpaths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjpaths</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescription_Jjpaths()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription
	 * @model opposite="controlflowdescription" containment="true" ordered="false"
	 * @generated
	 */
	EList<JJPath> getJjpaths();

	/**
	 * Returns the value of the '<em><b>Controlflowdescriptions</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.ControlFlowDescriptions#getControlFlowDescription <em>Control Flow Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowdescriptions</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowdescriptions</em>' container reference.
	 * @see #setControlflowdescriptions(ControlFlowDescriptions)
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescription_Controlflowdescriptions()
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptions#getControlFlowDescription
	 * @model opposite="controlFlowDescription" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ControlFlowDescriptions getControlflowdescriptions();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions <em>Controlflowdescriptions</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controlflowdescriptions</em>' container reference.
	 * @see #getControlflowdescriptions()
	 * @generated
	 */
	void setControlflowdescriptions(ControlFlowDescriptions value);

	/**
	 * Returns the value of the '<em><b>Graph</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription <em>Controlflowdescription</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph</em>' containment reference.
	 * @see #setGraph(Graph)
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescription_Graph()
	 * @see de.fzi.se.controlflowdescription.graph.Graph#getControlflowdescription
	 * @model opposite="controlflowdescription" containment="true" ordered="false"
	 * @generated
	 */
	Graph getGraph();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph <em>Graph</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph</em>' containment reference.
	 * @see #getGraph()
	 * @generated
	 */
	void setGraph(Graph value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.jjnpaths->size() > 0) implies self.graph->size() = 1
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean GraphMustBeDefinedIfJJnPathsPresent(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ControlFlowDescription
