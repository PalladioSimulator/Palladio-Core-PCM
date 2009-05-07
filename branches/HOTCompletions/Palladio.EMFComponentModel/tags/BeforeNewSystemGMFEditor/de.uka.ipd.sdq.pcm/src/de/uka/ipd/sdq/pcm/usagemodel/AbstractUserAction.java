
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract User Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor <em>Predecessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getAbstractUserAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractUserAction extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(AbstractUserAction)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getAbstractUserAction_Successor()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor
	 * @model opposite="predecessor" ordered="false"
	 * @generated
	 */
	AbstractUserAction getSuccessor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(AbstractUserAction value);

	/**
	 * Returns the value of the '<em><b>Predecessor</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor</em>' reference.
	 * @see #setPredecessor(AbstractUserAction)
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getAbstractUserAction_Predecessor()
	 * @see de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getSuccessor
	 * @model opposite="successor" ordered="false"
	 * @generated
	 */
	AbstractUserAction getPredecessor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction#getPredecessor <em>Predecessor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor</em>' reference.
	 * @see #getPredecessor()
	 * @generated
	 */
	void setPredecessor(AbstractUserAction value);

} // AbstractUserAction