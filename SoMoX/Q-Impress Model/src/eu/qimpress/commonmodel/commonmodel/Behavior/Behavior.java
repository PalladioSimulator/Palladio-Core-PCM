/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.Behavior;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The class Behavior is the root class definning Behavior model associated with a service interface. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.Behavior.Behavior#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.Behavior.BehaviorPackage#getBehavior()
 * @model abstract="true"
 * @generated
 */
public interface Behavior extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The operation property allows externall call of operations from service behavior model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see eu.qimpress.commonmodel.commonmodel.Behavior.BehaviorPackage#getBehavior_Operation()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.Behavior.Behavior#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // Behavior
