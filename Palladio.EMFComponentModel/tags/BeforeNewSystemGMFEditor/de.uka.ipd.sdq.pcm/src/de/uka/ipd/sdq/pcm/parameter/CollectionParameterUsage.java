
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getInnerElement_ParameterUsage <em>Inner Element Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getParameterCharacterisation_CollectionParameterUsage <em>Parameter Characterisation Collection Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterUsage()
 * @model
 * @generated
 */
public interface CollectionParameterUsage extends ParameterUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Inner Element Parameter Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Element Parameter Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Element Parameter Usage</em>' containment reference.
	 * @see #setInnerElement_ParameterUsage(ParameterUsage)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterUsage_InnerElement_ParameterUsage()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ParameterUsage getInnerElement_ParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getInnerElement_ParameterUsage <em>Inner Element Parameter Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Element Parameter Usage</em>' containment reference.
	 * @see #getInnerElement_ParameterUsage()
	 * @generated
	 */
	void setInnerElement_ParameterUsage(ParameterUsage value);

	/**
	 * Returns the value of the '<em><b>Parameter Characterisation Collection Parameter Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Characterisation Collection Parameter Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Characterisation Collection Parameter Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterUsage_ParameterCharacterisation_CollectionParameterUsage()
	 * @model type="de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation" containment="true" ordered="false"
	 * @generated
	 */
	EList getParameterCharacterisation_CollectionParameterUsage();

} // CollectionParameterUsage