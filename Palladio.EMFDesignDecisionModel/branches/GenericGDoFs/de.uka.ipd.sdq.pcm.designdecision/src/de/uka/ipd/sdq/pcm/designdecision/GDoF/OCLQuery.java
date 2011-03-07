/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.OCLQuery#getOclWithContext <em>Ocl With Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getOCLQuery()
 * @model
 * @generated
 */
public interface OCLQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Ocl With Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ocl With Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ocl With Context</em>' attribute.
	 * @see #setOclWithContext(String)
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getOCLQuery_OclWithContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getOclWithContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.OCLQuery#getOclWithContext <em>Ocl With Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ocl With Context</em>' attribute.
	 * @see #getOclWithContext()
	 * @generated
	 */
	void setOclWithContext(String value);

} // OCLQuery
