
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Named Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.AbstractNamedReference#getReferenceName <em>Reference Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getAbstractNamedReference()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNamedReference extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Name</em>' attribute.
	 * @see #setReferenceName(String)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getAbstractNamedReference_ReferenceName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getReferenceName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.AbstractNamedReference#getReferenceName <em>Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Name</em>' attribute.
	 * @see #getReferenceName()
	 * @generated
	 */
	void setReferenceName(String value);

} // AbstractNamedReference