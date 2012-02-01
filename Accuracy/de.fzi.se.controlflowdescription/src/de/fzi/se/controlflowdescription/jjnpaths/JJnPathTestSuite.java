/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JJn Path Test Suite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnhelperpaths <em>Jjnhelperpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset <em>Jjnpathset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getTestcases <em>Testcases</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getRequiredTests <em>Required Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestSuite()
 * @model
 * @generated
 */
public interface JJnPathTestSuite extends EObject {
	/**
	 * Returns the value of the '<em><b>Jjnhelperpaths</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnhelperpaths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnhelperpaths</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestSuite_Jjnhelperpaths()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPath#getJjnpathtestset
	 * @model opposite="jjnpathtestset" containment="true"
	 * @generated
	 */
	EList<JJnPath> getJjnhelperpaths();

	/**
	 * Returns the value of the '<em><b>Jjnpathset</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathset</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathset</em>' container reference.
	 * @see #setJjnpathset(JJnPathSet)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestSuite_Jjnpathset()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet#getJjnpathtestset
	 * @model opposite="jjnpathtestset" required="true" transient="false" ordered="false"
	 * @generated
	 */
	JJnPathSet getJjnpathset();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getJjnpathset <em>Jjnpathset</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpathset</em>' container reference.
	 * @see #getJjnpathset()
	 * @generated
	 */
	void setJjnpathset(JJnPathSet value);

	/**
	 * Returns the value of the '<em><b>Testcases</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset <em>Jjnpathtestset</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestSuite_Testcases()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset
	 * @model opposite="jjnpathtestset" containment="true" ordered="false"
	 * @generated
	 */
	EList<JJnPathTestCase> getTestcases();

	/**
	 * Returns the value of the '<em><b>Required Tests</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Tests</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Tests</em>' attribute.
	 * @see #setRequiredTests(int)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestSuite_RequiredTests()
	 * @model ordered="false"
	 * @generated
	 */
	int getRequiredTests();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getRequiredTests <em>Required Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Tests</em>' attribute.
	 * @see #getRequiredTests()
	 * @generated
	 */
	void setRequiredTests(int value);

} // JJnPathTestSuite
