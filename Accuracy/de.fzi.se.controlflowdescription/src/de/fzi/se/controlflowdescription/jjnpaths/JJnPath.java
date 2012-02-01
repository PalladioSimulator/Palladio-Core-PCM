/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import de.fzi.se.controlflowdescription.graph.Vertex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JJn Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A single sequence of JJ-Paths.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset <em>Jjnpathset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjpaths <em>Jjpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJumpTo <em>Jump To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath()
 * @model
 * @generated
 */
public interface JJnPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Jjnpathset</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpaths <em>Jjnpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathset</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathset</em>' container reference.
	 * @see #setJjnpathset(JJnPathSet)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath_Jjnpathset()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpaths
	 * @model opposite="jjnpaths" transient="false" ordered="false"
	 * @generated
	 */
	JJnPathSet getJjnpathset();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset <em>Jjnpathset</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpathset</em>' container reference.
	 * @see #getJjnpathset()
	 * @generated
	 */
	void setJjnpathset(JJnPathSet value);

	/**
	 * Returns the value of the '<em><b>Jjpaths</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJPath}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath <em>Jjnpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjpaths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjpaths</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath_Jjpaths()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJPath#getJjnpath
	 * @model opposite="jjnpath" containment="true" required="true"
	 * @generated
	 */
	EList<JJPath> getJjpaths();

	/**
	 * Returns the value of the '<em><b>From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     <font color="#3F5FBF" size="3"><font color="#3F5FBF" size="3">The from-Vertex of&nbsp;first JJ-Path in the sequence of
	 *     paths.</font></font>
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>From</em>' reference.
	 * @see #setFrom(Vertex)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath_From()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 *        extendedMetaData="name='from'"
	 * @generated
	 */
	Vertex getFrom();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getFrom <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Vertex value);

	/**
	 * Returns the value of the '<em><b>Jump To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     <font color="#3F5FBF" size="3"><font color="#3F5FBF" size="3">The&nbsp;jumpTo-Vertex of the last JJ-Path&nbsp;in the
	 *     sequence of paths.</font></font>
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jump To</em>' reference.
	 * @see #setJumpTo(Vertex)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath_JumpTo()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 *        extendedMetaData="name='jumpTo'"
	 * @generated
	 */
	Vertex getJumpTo();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJumpTo <em>Jump To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump To</em>' reference.
	 * @see #getJumpTo()
	 * @generated
	 */
	void setJumpTo(Vertex value);

	/**
	 * Returns the value of the '<em><b>Jjnpathtestset</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnhelperpaths <em>Jjnhelperpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathtestset</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathtestset</em>' container reference.
	 * @see #setJjnpathtestset(JJnPathTestSuite)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPath_Jjnpathtestset()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnhelperpaths
	 * @model opposite="jjnhelperpaths" transient="false" ordered="false"
	 * @generated
	 */
	JJnPathTestSuite getJjnpathtestset();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset <em>Jjnpathtestset</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpathtestset</em>' container reference.
	 * @see #getJjnpathtestset()
	 * @generated
	 */
	void setJjnpathtestset(JJnPathTestSuite value);

} // JJnPath
