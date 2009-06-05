
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Iterator Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction#getParameter_CollectionIteratorAction <em>Parameter Collection Iterator Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCollectionIteratorAction()
 * @model
 * @generated
 */
public interface CollectionIteratorAction extends AbstractLoopAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parameter Collection Iterator Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Collection Iterator Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Collection Iterator Action</em>' reference.
	 * @see #setParameter_CollectionIteratorAction(Parameter)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCollectionIteratorAction_Parameter_CollectionIteratorAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getParameter_CollectionIteratorAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction#getParameter_CollectionIteratorAction <em>Parameter Collection Iterator Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Collection Iterator Action</em>' reference.
	 * @see #getParameter_CollectionIteratorAction()
	 * @generated
	 */
	void setParameter_CollectionIteratorAction(Parameter value);

} // CollectionIteratorAction