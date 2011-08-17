/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.OCLRule#getMainOclQuery <em>Main Ocl Query</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.OCLRule#getHelperDefinition <em>Helper Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getOCLRule()
 * @model
 * @generated
 */
public interface OCLRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Main Ocl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Ocl Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Ocl Query</em>' attribute.
	 * @see #setMainOclQuery(String)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getOCLRule_MainOclQuery()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getMainOclQuery();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.OCLRule#getMainOclQuery <em>Main Ocl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Ocl Query</em>' attribute.
	 * @see #getMainOclQuery()
	 * @generated
	 */
	void setMainOclQuery(String value);

	/**
	 * Returns the value of the '<em><b>Helper Definition</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.GDoF.HelperOCLDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper Definition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Definition</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getOCLRule_HelperDefinition()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<HelperOCLDefinition> getHelperDefinition();

} // OCLRule
