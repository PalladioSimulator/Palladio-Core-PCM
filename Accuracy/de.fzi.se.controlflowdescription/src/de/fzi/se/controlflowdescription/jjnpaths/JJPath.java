/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import de.fzi.se.controlflowdescription.ControlFlowDescription;

import de.fzi.se.controlflowdescription.graph.Vertex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JJ Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A single JJ-Path.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getTo <em>To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJumpTo <em>Jump To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription <em>Controlflowdescription</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath <em>Jjnpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath()
 * @model
 * @generated
 */
public interface JJPath extends EObject {
	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Vertex of&nbsp;the graph at which the JJ-Path begins.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Vertex)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath_From()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Vertex getFrom();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Vertex value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Vertex of the graph at which the JJ-Path ends.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Vertex)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath_To()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Vertex getTo();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Vertex value);

	/**
	 * Returns the value of the '<em><b>Jump To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Vertex of the graph to which the jumpt at the end of the JJ-Path is made.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jump To</em>' reference.
	 * @see #setJumpTo(Vertex)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath_JumpTo()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Vertex getJumpTo();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJumpTo <em>Jump To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump To</em>' reference.
	 * @see #getJumpTo()
	 * @generated
	 */
	void setJumpTo(Vertex value);

	/**
	 * Returns the value of the '<em><b>Controlflowdescription</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjpaths <em>Jjpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowdescription</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowdescription</em>' container reference.
	 * @see #setControlflowdescription(ControlFlowDescription)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath_Controlflowdescription()
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getJjpaths
	 * @model opposite="jjpaths" transient="false" ordered="false"
	 * @generated
	 */
	ControlFlowDescription getControlflowdescription();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getControlflowdescription <em>Controlflowdescription</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controlflowdescription</em>' container reference.
	 * @see #getControlflowdescription()
	 * @generated
	 */
	void setControlflowdescription(ControlFlowDescription value);

	/**
	 * Returns the value of the '<em><b>Jjnpath</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjpaths <em>Jjpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpath</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpath</em>' container reference.
	 * @see #setJjnpath(JJnPath)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJPath_Jjnpath()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjpaths
	 * @model opposite="jjpaths" transient="false" ordered="false"
	 * @generated
	 */
	JJnPath getJjnpath();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath <em>Jjnpath</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpath</em>' container reference.
	 * @see #getJjnpath()
	 * @generated
	 */
	void setJjnpath(JJnPath value);

} // JJPath
