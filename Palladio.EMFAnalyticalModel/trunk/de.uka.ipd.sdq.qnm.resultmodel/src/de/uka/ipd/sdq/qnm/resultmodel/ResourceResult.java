/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getResource <em>Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getResourceResult()
 * @model
 * @generated
 */
public interface ResourceResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(Resource)
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getResourceResult_Resource()
	 * @model required="true"
	 * @generated
	 */
	Resource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.resultmodel.ResourceResult#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(Resource value);

	/**
	 * Returns the value of the '<em><b>Taskresourceusages</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResourceResult <em>Resource Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taskresourceusages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taskresourceusages</em>' reference list.
	 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage#getResourceResult_Taskresourceusages()
	 * @see de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage#getResourceResult
	 * @model type="de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage" opposite="resourceResult"
	 * @generated
	 */
	EList getTaskresourceusages();

} // ResourceResult