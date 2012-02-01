/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import de.fzi.se.controlflowdescription.ControlFlowDescription;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JJn Path Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Set of&nbsp;sequential JJ-Paths for the graph. JJ1-Paths are&nbsp;all JJ-Paths, JJn-Paths are all JJ-Paths which are
 *     put up to&nbsp;n times in sequence.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpaths <em>Jjnpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getN <em>N</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription <em>Controlflowdescription</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathSet()
 * @model
 * @generated
 */
public interface JJnPathSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Jjnpaths</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset <em>Jjnpathset</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpaths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpaths</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathSet_Jjnpaths()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathset
	 * @model opposite="jjnpathset" containment="true" ordered="false"
	 * @generated
	 */
	EList<JJnPath> getJjnpaths();

	/**
	 * Returns the value of the '<em><b>Jjnpathtestset</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset <em>Jjnpathset</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathtestset</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathtestset</em>' containment reference.
	 * @see #setJjnpathtestset(JJnPathTestSuite)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathSet_Jjnpathtestset()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset
	 * @model opposite="jjnpathset" containment="true" ordered="false"
	 * @generated
	 */
	JJnPathTestSuite getJjnpathtestset();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset <em>Jjnpathtestset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpathtestset</em>' containment reference.
	 * @see #getJjnpathtestset()
	 * @generated
	 */
	void setJjnpathtestset(JJnPathTestSuite value);

	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of sequences of JJ-Paths described by this instance.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #setN(int)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathSet_N()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getN();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #getN()
	 * @generated
	 */
	void setN(int value);

	/**
	 * Returns the value of the '<em><b>Controlflowdescription</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjnpathsets <em>Jjnpathsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowdescription</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowdescription</em>' container reference.
	 * @see #setControlflowdescription(ControlFlowDescription)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathSet_Controlflowdescription()
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getJjnpathsets
	 * @model opposite="jjnpathsets" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ControlFlowDescription getControlflowdescription();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getControlflowdescription <em>Controlflowdescription</em>}' container reference.
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
	 * <p>
	 *     The attribute n must be a number greater or equal to 1.
	 * </p>
	 * self.n >= 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean NMustBeGreaterOrEqualToOne(DiagnosticChain diagnostics, Map<Object, Object> context);

} // JJnPathSet
