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
 * A representation of the model object '<em><b>JJn Path Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpaths <em>Jjnpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestCase()
 * @model
 * @generated
 */
public interface JJnPathTestCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Jjnpaths</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.jjnpaths.JJnPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpaths</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpaths</em>' reference list.
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestCase_Jjnpaths()
	 * @model
	 * @generated
	 */
	EList<JJnPath> getJjnpaths();

	/**
	 * Returns the value of the '<em><b>Jjnpathtestset</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getTestcases <em>Testcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jjnpathtestset</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jjnpathtestset</em>' container reference.
	 * @see #setJjnpathtestset(JJnPathTestSuite)
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage#getJJnPathTestCase_Jjnpathtestset()
	 * @see de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite#getTestcases
	 * @model opposite="testcases" required="true" transient="false" ordered="false"
	 * @generated
	 */
	JJnPathTestSuite getJjnpathtestset();

	/**
	 * Sets the value of the '{@link de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase#getJjnpathtestset <em>Jjnpathtestset</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jjnpathtestset</em>' container reference.
	 * @see #getJjnpathtestset()
	 * @generated
	 */
	void setJjnpathtestset(JJnPathTestSuite value);

} // JJnPathTestCase
